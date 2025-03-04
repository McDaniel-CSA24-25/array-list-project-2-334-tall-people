import java.lang.reflect.Field;
public class Products {
    int id;
    //initialize values
    String name;
    int quantity;
    //make a default constructor
    public Products() {
        name = "None";
        id = 0;
        quantity = 0;
    }
    //normal constructor
    public Products(String n, int i, int q){
        name = n;
        id = i;
        quantity = q;
    }
    //getVariable gets the value with the variable name "input"
    //ex. if "quantity" is passed to getVariable(), it will return the value of the quantity variable
    //as a String and null if it encounters an error
    public String getVariable(String input){
        try {
            // "field" area of land. [countable] an area of land in the country used for
            // growing crops or keeping animals in, usually surrounded by a fence, etc
            Field field = this.getClass().getDeclaredField(input);
            field.setAccessible(true);
            return field.get(this).toString();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //setVariable does the same thing as getVariable, as the variable named in the parameter
    //"input" is then set to the value of the parameter "value". The value is converted to an int if
    //type conversion is possible, and false is return if an error is encountered
    public boolean setVariable(String input, String value){
        try {
            Field field = this.getClass().getDeclaredField(input);
            field.setAccessible(true);
            try {
                field.set(this, value);
            } catch (Exception e){
                field.set(this, Integer.parseInt(value));
            }
            return true;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }
    //but what use does lang.reflect.Field do in this program?
    //if you didn't enjoy my definition above, here's actually what field does:
    //Field lets me dynamically get variables based on the name of the variable. This allows
    //me to only need 1 getter and 1 setter total, that can get and set for every variable in each object.
    //this works because field allows for this kind of manipulation by comparing the name of the variables
    //to the input and returning it or changing the correct variable accordingly.
}
