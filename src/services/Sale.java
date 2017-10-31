package services;

public class Sale {

    public Reports log;

    private PriceRegulator regulator;

    private Item item;


    public Sale() {
        log = new Reports();
    }
    public boolean processMessage(String saleNotice) {
        DataAnalyzer messageParser;
        messageParser = new DataAnalyzer(saleNotice);
        String productType = messageParser.getItemType();
        if (productType.isEmpty()) {
            return false;
        }
        this.item = log.getProduct(productType);
        this.regulator = new PriceRegulator(item);
        this.item.setVolume(messageParser.getVolume());
        this.item.setTotalQuantity(messageParser.getVolume());
        this.item.setItemPrice(messageParser.getItemPrice());
        this.item.setRegulatedOperation(messageParser.getRegulatorOperation());
        setProductTotalPrice();
        log.setNormalReports(saleNotice);
        log.updateProduct(item);
        return true;
    }
    private void setProductTotalPrice() {
        double adjustedPrice;
        double productValue;
        if (!item.getRegulatedOperation().isEmpty()) {
            adjustedPrice = regulator.getAdjustedPrice();
            log.setRegulatedReports(regulator.adjustmentReport());
            item.setTotalPrice(adjustedPrice);
        } else {
            productValue = item.calculateAmount(item.getVolume(), item.getItemPrice());
            item.addtoTotalPrice(productValue);
        }
    }

}