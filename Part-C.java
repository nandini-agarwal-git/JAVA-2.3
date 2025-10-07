import java.util.*;
import java.util.stream.*;

public class PBLJ6Experiment {

    static class Product {
        String name;
        double price;
        String category;

        Product(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        @Override
        public String toString() {
            return name + " - " + category + " - ₹" + price;
        }
    }

    public static void productStreamOperations() {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 55000, "Electronics"),
                new Product("Mouse", 800, "Electronics"),
                new Product("Keyboard", 1500, "Electronics"),
                new Product("Monitor", 12000, "Electronics"),
                new Product("Chair", 3500, "Furniture"),
                new Product("Table", 7000, "Furniture"),
                new Product("Sofa", 25000, "Furniture"),
                new Product("T-shirt", 800, "Clothing"),
                new Product("Jeans", 1800, "Clothing"),
                new Product("Jacket", 3500, "Clothing")
        );

        System.out.println("=== Part C: Stream Operations on Product Dataset ===\n");

        Map<String, List<Product>> groupedByCategory = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));

        System.out.println("Grouped Products by Category:");
        groupedByCategory.forEach((category, prodList) -> {
            System.out.println("\nCategory: " + category);
            prodList.forEach(System.out::println);
        });

        Map<String, Optional<Product>> maxPriceByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));

        System.out.println("\nMost Expensive Product in Each Category:");
        maxPriceByCategory.forEach((category, prod) ->
                System.out.println(category + ": " + prod.get()));

        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(p -> p.price));

        System.out.println("\nAverage Price of All Products: ₹" + averagePrice);
        System.out.println();
    }

    public static void main(String[] args) {
        productStreamOperations();
    }
}
