/**
 * Created by kos on 4/25/17.
 */
public class Item {
    String name;
    int class_number;
    double weight;
    double cost;
    double resale_value;
    double value;
    public Item(String name, int class_number, double weight, double cost, double resale_value){
        this.name = name;
        this.class_number = class_number;
        this.weight = weight;
        this.cost = cost;
        this.resale_value = resale_value;
        this.value = (resale_value - cost) / (weight + .01) * cost;

    }

}
