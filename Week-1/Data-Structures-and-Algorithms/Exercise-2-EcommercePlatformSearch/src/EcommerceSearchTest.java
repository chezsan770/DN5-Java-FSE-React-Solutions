import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product(104, "Wireless Mouse", "Electronics"),
            new Product(101, "Running Shoes", "Footwear"),
            new Product(105, "Coffee Maker", "Home Appliances"),
            new Product(102, "Laptop Stand", "Electronics"),
            new Product(103, "Travel Backpack", "Bags")
        };

        Product linearResult = ProductSearch.linearSearch(products, 102);
        System.out.println("Linear search result: " + linearResult);

        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparingInt(Product::getProductId));

        Product binaryResult = ProductSearch.binarySearch(sortedProducts, 102);
        System.out.println("Binary search result: " + binaryResult);

        if (linearResult == null || binaryResult == null) {
            throw new AssertionError("The product should be found by both algorithms.");
        }

        if (linearResult.getProductId() != binaryResult.getProductId()) {
            throw new AssertionError("Both algorithms should find the same product.");
        }

        Product missingProduct = ProductSearch.binarySearch(sortedProducts, 999);
        if (missingProduct != null) {
            throw new AssertionError("A nonexistent product should not be found.");
        }

        System.out.println("Test passed: both search algorithms work correctly.");
    }
}
