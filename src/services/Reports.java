package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reports {

	private HashMap<String, Item> itemsMap = new HashMap<>();
	private double totalSalesValue;
	private ArrayList<String> intitialReports;
	private ArrayList<String> regulatedReports;

	public Reports() {
		this.intitialReports = new ArrayList();
		this.regulatedReports = new ArrayList();
		this.totalSalesValue = 0.0;
	}

	public Item getProduct(String type) {
		return itemsMap.getOrDefault(type, new Item(type));
	}

	public void updateProduct(Item item) {
		itemsMap.put(item.getItemType(), item);
	}

	public ArrayList<String> getNormalReports() {
		return intitialReports;
	}

	public void setNormalReports(String normalReport) {
		this.intitialReports.add(normalReport);
	}

	public ArrayList<String> getRegulatedReports() {
		return regulatedReports;
	}

	public void setRegulatedReports(String adjustmentReport) {
		this.regulatedReports.add(adjustmentReport);
	}

	public double getTotalSalesValue() {
		return totalSalesValue;
	}

	public void appendTotalSalesValue(double productTotalPrice) {
		totalSalesValue += productTotalPrice;
	}

	public void setTotalSalesValue(double productTotalPrice) {
		totalSalesValue = productTotalPrice;
	}

	public void report() {

		if ((intitialReports.size() % 10) == 0 && intitialReports.size() != 0) {
			setTotalSalesValue(0.0);
			System.out.println("10 Transactions Recorded");
			System.out.println("------------------------------------------");

			System.out.println("Product          |Quantity   |Value      ");
			System.out.println("------------------------------------------");

			for (String key : itemsMap.keySet()) {
				formatReports(key, itemsMap.get(key));
			}
			System.out.println("===========================================");
			System.out.println(String.format("%-30s %-11.2f ", "Total Sales",
					getTotalSalesValue()));
			System.out.println("===========================================");
			System.out.println("End\n\n");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if ((intitialReports.size() % 50) == 0 && intitialReports.size() != 0) {
			System.out
					.println("Message Service processed 50 transactions reached threshold Cannot process anymore transactions. The following are the Regulated records made;\n");
			List<String> adjReports = getRegulatedReports();
			for (int i = 0; i <= adjReports.size(); i++) {
				System.out.println();
			}
			System.exit(1);
		}
	}

	public void formatReports(String type, Item item) {
		String lineItem = String.format("%-18s|%-11d|%-11.2f",
				item.getItemType(), item.getTotalVolume(),
				item.getConsolidatedPrice());
		appendTotalSalesValue(item.getConsolidatedPrice());
		System.out.println(lineItem);
	}

}
