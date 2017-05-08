import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by kos on 4/27/17.
 */
public class Class_Item {
    ArrayList<Item> classItems = new ArrayList<Item>();
    int name;
    double classAvg;
    double size;
    HashSet<Integer> edges = new HashSet<>();
    ArrayList<Integer> garbageSet = new ArrayList<>();

    public Class_Item(int item){
        this.name = item;
        classAvg = 0;

    }


    public void addClass_Items(Item item){

        this.classItems.add(item);
        this.size = this.size + 1;
        this.classAvg = (item.resale_value + this.classAvg) / size;

    }

    public void addEdge(Class_Item a, Class_Item b){
        a.edges.add(b.name);
        b.edges.add(a.name);
        a.garbageSet.add(b.name);
        b.garbageSet.add(a.name);
    }

}