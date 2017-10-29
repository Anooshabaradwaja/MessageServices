import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PriceRegulator {

	private double regulatedPrice;

	private Item item;

	public PriceRegulator(Item product) {
		this.item = product;
		this.regulatedPrice = 0.0;
	}

	public double getAdjustedPrice() {
		String adjustmentMethod = String.format("%sPrice", item
				.getRegulatedOperation().toLowerCase());
		try {
			Method method = this.getClass().getMethod(adjustmentMethod, null);
			method.invoke(this, null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return regulatedPrice;
	}

	public void addPrice() {
		this.regulatedPrice = this.item.getConsolidatedPrice()
				+ (this.item.getTotalVolume() * this.item.getItemPrice());
	}

	public void subtractPrice() {
		this.regulatedPrice = this.item.getConsolidatedPrice()
				- (this.item.getTotalVolume() * this.item.getItemPrice());
	}

	public void multiplyPrice() {
		this.regulatedPrice = this.item.getConsolidatedPrice()
				+ (this.item.getConsolidatedPrice() * this.item.getItemPrice())
				+ (this.item.getTotalVolume() * this.item.getItemPrice());
	}

	public String adjustmentReport() {
		String adjustmentReport = String
				.format("Performed %s %.2fp to %d %s and price adjusted from %.2fp to %.2fp",
						this.item.getRegulatedOperation(),
						this.item.getItemPrice(), this.item.getTotalVolume(),
						this.item.getItemType(),
						this.item.getConsolidatedPrice(), this.regulatedPrice);
		return adjustmentReport;
	}

}
