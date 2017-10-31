package services;

public class Item {
    
	private double itemPrice;

    private int volume;

    private String regulatedOperation;

    private String itemType;

    private int totalVolume;

    private double consolidatedPrice;

    public Item(String type) {
        this.consolidatedPrice = 0.0;
        this.totalVolume = 0;
        this.itemType = type;
        this.regulatedOperation = null;
    }

    public double calculateAmount(int volume, double price){
        return volume * price;
    }

    public void setTotalPrice(double totalPrice) { this.consolidatedPrice = totalPrice;  }

    public void addtoTotalPrice(double price) {
        this.consolidatedPrice += price;
    }

    public void setTotalQuantity(int quantity){
        this.totalVolume += quantity;
    }
    
    public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getRegulatedOperation() {
		return regulatedOperation;
	}

	public void setRegulatedOperation(String regulatedOperation) {
		this.regulatedOperation = regulatedOperation;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(int totalVolume) {
		this.totalVolume = totalVolume;
	}

	public double getConsolidatedPrice() {
		return consolidatedPrice;
	}

	public void setConsolidatedPrice(double consolidatedPrice) {
		this.consolidatedPrice = consolidatedPrice;
	}
}
