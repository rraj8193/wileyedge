package ProductAssignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ReadProductData {

	BufferedReader reader;

	public ReadProductData(String inputFile) throws FileNotFoundException {
		FileReader fileReader = new FileReader(inputFile);
		reader = new BufferedReader(fileReader);
	}

	public List<Product> readData() {

		List<Product> productList = new ArrayList<>();

		String line = "";

		try {
			while ((line = reader.readLine()) != null) {

//				System.out.println(line);
				StringTokenizer tokens = new StringTokenizer(line, ",");
				String productName = tokens.nextToken();
		        String productDescription = tokens.nextToken();
		        float rating = Float.parseFloat(tokens.nextToken());
		        double price = Double.parseDouble(tokens.nextToken());
		        
		        productList.add(new Product(productName,productDescription,rating,price));

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}

	public static void main(String[] args) throws FileNotFoundException {
		ReadProductData productData = new ReadProductData("C:\\\\Users\\\\Rishav Raj\\\\Desktop\\\\product.csv");

		List<Product> productList = productData.readData();
		
		System.err.format("|  %-20s| %-90s | %-10s | %-10s |\n","Product Name","Product Description", "Rating","Price");
		
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
		for(Product product:productList) {
			System.out.format("|  %-20s| %-90s | %-10.1f | %-10.2f |\n",product.getProductName(),product.getProductDescription(),product.getRating(),product.getPrice());
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

		}

	}

}
