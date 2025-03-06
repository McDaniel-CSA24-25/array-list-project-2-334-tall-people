import java.util.*;
public class Main {

    public static void main(String[] args) {
        //initialize the ArrayList
        ArrayList<Products> products = new ArrayList<>();
        String input = "0";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your products");
        //get the products (name, id, quantity) until the user enters "-1"
        //if a name is entered before -1, an object will still be created with default values
        //TODO: check for products with the name or id to force the user to re enter objects deemed duplicates
        while (!input.equals("-1")) {
            Products product = new Products();
            String[] attrList = {"name", "id", "quantity"};
            for (String attr : attrList) {
                System.out.println(attr + " of product:");
                input = scanner.nextLine();
                if (input.equals("-1")) {
                    break;
                }
                product.setVariable(attr, input);
                if (attr.equals("quantity")) {
                    products.add(product);
                }
            }

        }
        //iterate through each object the user entered and check if the quantity is < 5 and print a warning
        for (Products p : products) {
            if (Integer.parseInt(p.getVariable("quantity")) < 5) {
                System.out.println(p.getVariable("name") + " is low on quantity, quantity is less than 5");
            }

        }
    }
}
