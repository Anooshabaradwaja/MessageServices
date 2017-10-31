package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MessageService {

	public static void main(String[] args) {
		Sale sale = new Sale();
		MessageService service = new MessageService();
		service.readFile("testInput/rawData.txt");
	}

	@SuppressWarnings("resource")
	public File readFile(String fileName) {
		Sale sale = new Sale();
		File inputResource = new File(fileName);
		Scanner sc;
		try {
			sc = new Scanner(inputResource);

			while ((sc.hasNextLine())) {
				sale.processMessage(sc.nextLine());
				sale.log.report();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Exception in readFile :: " + e.getMessage());
		}
		return inputResource;
	}

}
