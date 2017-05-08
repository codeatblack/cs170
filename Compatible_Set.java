//import java.util.*;
//
///**
// * Created by kos on 4/25/17.
// */
//public class Compatible_Set {
//    int Max_Set;
//    HashMap<Integer, HashSet> compatibleSet;
//    HashMap<Integer, Integer> compatibleLength;
//    ArrayList<Integer> sortedSet;
//    ArrayList<Integer> sortedLenght;
//
//    public Compatible_Set(int class_size, Incompatibility_Set graph) {
//        HashSet allClasses = all_Classes(class_size);
//        this.sortedSet = new ArrayList<Integer>();
//        for (int i = 0; i < class_size; i++){
//            HashSet<Integer> temp2 = allClasses;
//            temp2.removeAll(graph.set.get(i));
//            this.compatibleSet.put(i, temp2);
//            this.compatibleLength.put(i, temp2.size());
//            sortedSet.add(temp2.size());
//        }
//
//
//
//    }
//
//    public HashSet<Integer> all_Classes(int size){
//        HashSet<Integer> temp = new HashSet<>();
//        for(int i = 0; i < size; i++){
//            temp.add(i);
//        }
//        return temp;
//    }
//
//    public void Top_K_Lengths(int amount, Compatible_Set comp){
//        List<Integer > sortedCompList = new ArrayList<Integer>(comp.sortedSet);
//
//    }
//
//}
//
//// Go to graph and add the Vertices to have their weight and value as well as the number assigned to them
//// nvm on vertex