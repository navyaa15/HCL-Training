package Assignment2;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

// Parent class for all products
class Product {
    int id;
    String name;
    double price;
    int quantity;
    String category;

    Product(int id, String name, double price,
            int quantity, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    void display() {
        System.out.println(
                "ID: " + id +
                        " | Name: " + name +
                        " | Category: " + category +
                        " | Price: Rs. " + price +
                        " | Quantity: " + quantity
        );
    }
}

// Clothes product
class Clothes extends Product {
    Clothes(int id, String name, double price, int quantity) {
        super(id, name, price, quantity, "Clothes");
    }
}

// Electronic product
class Electronics extends Product {
    Electronics(int id, String name, double price, int quantity) {
        super(id, name, price, quantity, "Electronics");
    }
}

// Toys product
class Toys extends Product {
    Toys(int id, String name, double price, int quantity) {
        super(id, name, price, quantity, "Toys");
    }
}

// Shopping cart management
class ShoppingCart {
    ArrayList<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        for (Product p : products) {
            if (p.id == product.id) {
                System.out.println("Product ID already exists.");
                return;
            }
        }

        products.add(product);
        System.out.println("Product added successfully.");
    }

    void removeProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).id == id) {
                products.remove(i);
                System.out.println("Product removed successfully.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    void updateProduct(int id, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        for (Product p : products) {
            if (p.id == id) {
                p.quantity = quantity;
                System.out.println("Product updated successfully.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    void showCart() {
        if (products.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        products.sort(
                Comparator.comparing((Product p) -> p.category)
                        .thenComparing(p -> p.name)
        );

        System.out.println("\n----- SHOPPING CART -----");

        for (Product p : products) {
            p.display();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("\n1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Product");
            System.out.println("4. Show Cart");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(
                            "Category: 1.Clothes 2.Electronics 3.Toys"
                    );
                    int type = sc.nextInt();

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter name: ");
                    String name = sc.next();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    if (id <= 0 || price < 0 || quantity <= 0) {
                        System.out.println("Invalid product details.");
                        break;
                    }

                    Product product;

                    if (type == 1) {
                        product = new Clothes(id, name, price, quantity);
                    } else if (type == 2) {
                        product = new Electronics(id, name, price, quantity);
                    } else if (type == 3) {
                        product = new Toys(id, name, price, quantity);
                    } else {
                        System.out.println("Invalid category.");
                        break;
                    }

                    cart.addProduct(product);
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    cart.removeProduct(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter product ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter new quantity: ");
                    int newQuantity = sc.nextInt();

                    cart.updateProduct(updateId, newQuantity);
                    break;

                case 4:
                    cart.showCart();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}