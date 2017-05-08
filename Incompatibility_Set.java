//import java.util.*;
//import java.util.Set;
//
///**
// * Created by kos on 4/25/17.
// */
//public class Incompatibility_Set {
//    int Max_Set;
//    HashMap<Integer, HashSet<Integer>> set;
//    Graph graph;
//
////    public Incompatibility_Set(int class_size, Graph graph) {
////        this.graph = graph;
////        this.set  = make_Incompatible(class_size);
////    }
////
////    public HashMap<Integer, HashSet<Integer>> make_Incompatible(int size){
////        HashMap<Integer, HashSet<Integer>> temp = new HashMap<>();
////        for (int i = 0; i < size; i++){
////            Iterator<Integer> itr = (Iterator<Integer>) graph.adj(i);
////            HashSet<Integer> set = null;
////            while (itr.hasNext()) {
////                int num = itr.next();
////                set.add(num);
////            }
////
////            temp.put(i, set);
////        }
////        return temp;
////    }
//}
//
