package test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class TestSuite {
	@Test
    public void fileExists() {
		File inputResource = new File("testInput/rawData.txt");
		assertTrue(inputResource.exists());
    }
	
	@Test
    public void fileHasData() throws FileNotFoundException {
		File inputResource = new File("testInput/rawData.txt");
		Scanner sc = new Scanner(inputResource);
		assertTrue(sc.hasNextLine());
    }
	
	@Test
	public void saleDataisEmptynessOrNull() throws FileNotFoundException{
		File inputResource = new File("testInput/rawData.txt");
		Scanner sc = new Scanner(inputResource);
		while ((sc.hasNextLine())) {
			assertTrue(!sc.nextLine().isEmpty());
			assertTrue(sc.nextLine() != null);
		}
	}
	
	@Test
	public void parseMessageFormat3(){
		String oneSale = "Add 20p apples";
		String[] itemArray = oneSale.trim().split("\\s+");
		String firstWord = itemArray[0];
		assertTrue(firstWord.matches("Add|Subtract|Multiply"));
	}
	
	@Test
	public void checkLengthOfMessage3(){
		String oneSale = "Add 20p apples";
		String[] itemArray = oneSale.trim().split("\\s+");
		assertTrue(itemArray.length==3);
	}
	
	@Test
	public void parseTypeforMessageFormat3(){
		String oneSale = "Add 20p apples";
		String[] itemArray = oneSale.trim().split("\\s+");
		String itemType = itemArray[2];
		assertTrue(!itemType.isEmpty());
		assertTrue(itemType!=null);
	}
	
	@Test
	public void parsePriceforMessageFormat3(){
		String oneSale = "Add 20p apples";
		String[] itemArray = oneSale.trim().split("\\s+");
		String itemPrice = itemArray[1];
		assertTrue(!itemPrice.isEmpty());
		assertTrue(itemPrice!=null);
	}
	
	@Test
	public void parseMessageFormat2(){
		String oneSale = "20 sales of mango for 10p each";
		String[] itemArray = oneSale.trim().split("\\s+");
		String firstWord = itemArray[0];
		assertTrue(firstWord.matches("^\\d+"));
	}
	
	@Test
	public void checkLengthOfMessage2(){
		String oneSale = "20 sales of mango for 10p each";
		String[] itemArray = oneSale.trim().split("\\s+");
		assertTrue(itemArray.length==7);
	}
	
	@Test
	public void parseTypeforMessageFormat2(){
		String oneSale = "20 sales of mango for 10p each";
		String[] itemArray = oneSale.trim().split("\\s+");
		String itemType = itemArray[3];
		assertTrue(!itemType.isEmpty());
		assertTrue(itemType!=null);
	}
	
	@Test
	public void parsePriceforMessageFormat2(){
		String oneSale = "20 sales of mango for 10p each";
		String[] itemArray = oneSale.trim().split("\\s+");
		String itemPrice = itemArray[5];
		assertTrue(!itemPrice.isEmpty());
		assertTrue(itemPrice!=null);
	}
	
	@Test
	public void parseMessageFormat1(){
		String oneSale = "apple for 10p";
		String[] itemArray = oneSale.trim().split("\\s+");
		String firstWord = itemArray[0];
		assertTrue(itemArray.length == 3 && itemArray[1].contains("for"));
	}
	
	@Test
	public void parseTypeforMessageFormat1(){
		String oneSale = "apple for 10p";
		String[] itemArray = oneSale.trim().split("\\s+");
		String itemType = itemArray[0];
		assertTrue(!itemType.isEmpty());
		assertTrue(itemType!=null);
	}
	
	@Test
	public void parsePriceforMessageFormat1(){
		String oneSale = "apple for 10p";
		String[] itemArray = oneSale.trim().split("\\s+");
		String itemPrice = itemArray[2];
		assertTrue(!itemPrice.isEmpty());
		assertTrue(itemPrice!=null);
	}
	
	
}
