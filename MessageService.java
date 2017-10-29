import java.io.File;
import java.util.Scanner;

public class MessageService {

    public static void main(String[] args) {
        Sale sale = new Sale();
        try {
            File inputResource = new File("inputData.txt");
            Scanner sc = new Scanner(inputResource);

            while((sc.hasNextLine())) {
                sale.processMessage(sc.nextLine());
                sale.log.report();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

}