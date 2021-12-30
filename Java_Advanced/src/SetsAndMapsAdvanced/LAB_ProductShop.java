package SetsAndMapsAdvanced;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class LAB_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        TreeMap<String, List<Product>> productMap = new TreeMap<>();

        while(!input.equals("Revision")){
            String shop = input.split(", ")[0];
            String productName = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            Product product = new Product(productName, price);

            if (productMap.containsKey(shop)) {
                productMap.get(shop).add(product);
            }else{
                productMap.put(shop, new ArrayList<>());
                productMap.get(shop).add(product);
            }
            input = scanner.nextLine();
        }

        productMap.entrySet().forEach(el -> {
            System.out.println(el.getKey() + "->");
            List<Product> newList = el.getValue();
            newList.forEach(e-> {
                System.out.printf("Product: %s, Price: %.1f%n",e.getProduct(),e.getPrice());
            });
        });
    }

    private static class Product{
        private String product;
        private double price;

        public Product(String product, double price) {
            this.product = product;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public String getProduct() {
            return product;
        }
    }
}
