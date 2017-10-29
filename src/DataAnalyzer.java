public class DataAnalyzer {

    private String itemType;

    private double itemPrice;
    private int volume;
    private String regulatorOperation;
    public DataAnalyzer(String message) {
        this.itemType = "";
        this.itemPrice = 0.0;
        this.volume = 0;
        this.regulatorOperation = "";
        readTextData(message);
    }
    private boolean readTextData(String message) {
        if (message == null || message.isEmpty()) {
            return false;
        }
        String[] itemArray = message.trim().split("\\s+");
        String firstWord = itemArray[0];
        if (firstWord.matches("Add|Subtract|Multiply")) {
            return parseDataFormat3(itemArray);
        } else if (firstWord.matches("^\\d+")) {
            return parseDataFormat2(itemArray);
        } else if (itemArray.length == 3 && itemArray[1].contains("for")) {
            return parseDataFormat1(itemArray);
        } else {
            System.out.println("Wrong sales notice");
        }
        return true;
    }

    private boolean parseDataFormat1(String[] itemArray) {
        if(itemArray.length > 3 || itemArray.length < 3) return false;
        itemType = parseType(itemArray[0]);
        itemPrice = parsePrice(itemArray[2]);
        volume = 1;
        return true;
    }

    private boolean parseDataFormat2(String[] itemArray) {
        if(itemArray.length > 7 || itemArray.length < 7) return false;
        itemType = parseType(itemArray[3]);
        itemPrice = parsePrice(itemArray[5]);
        volume = Integer.parseInt(itemArray[0]);
        return true;
    }

    private boolean parseDataFormat3(String[] itemArray) {
        if(itemArray.length > 3 || itemArray.length < 3) return false;
        regulatorOperation = itemArray[0];
        itemType = parseType(itemArray[2]);
        volume = 0;
        itemPrice = parsePrice(itemArray[1]);
        return true;
    }

    public String parseType(String rawType) {
        String parsedType = "";
        String typeWithoutLastChar = rawType.substring(0, rawType.length() - 1);
        //enum DEPREC
        if (rawType.endsWith("o")) {
            parsedType = String.format("%soes", typeWithoutLastChar);
        } else if (rawType.endsWith("y")) {
            parsedType = String.format("%sies", typeWithoutLastChar);
        } else if (rawType.endsWith("h")) {
            parsedType = String.format("%shes", typeWithoutLastChar);
        } else if (!rawType.endsWith("s")) {
            parsedType = String.format("%ss", rawType);
        } else {
            parsedType = String.format("%s", rawType);
        }
        return parsedType.toLowerCase();
    }

    public double parsePrice(String rawPrice) {
        double price = Double.parseDouble(rawPrice.replaceAll("£|p", ""));
        if (!rawPrice.contains(".")) {
            price = Double.valueOf(Double.valueOf(price) / Double.valueOf("100"));
        }
        return price;
    }
    public String getItemType() {
        return itemType;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public String getRegulatorOperation() {
        return regulatorOperation;
    }
    public int getVolume() {
        return volume;
    }


}