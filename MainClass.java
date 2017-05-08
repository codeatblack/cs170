import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by tesfahunt on 4/26/17.
 */
public class MainClass {
    public Class_Item class_set;
    public MainClass (){}

    public static ArrayList<Class_Item> getItemList(int itemNum, Scanner inFile) {
        ArrayList<Class_Item> itemList = new ArrayList<>();

        for (int i = 0; i < itemNum; i++){
            Class_Item class_item= new Class_Item(i);
            itemList.add(class_item);
        }

        for (int i = 0; i < itemNum; i++) {
            String[] str = inFile.nextLine().split("; ");
            Item item = new Item(str[0], Integer.parseInt(str[1]), Double.parseDouble(str[2]),
                    Double.parseDouble(str[3]), Double.parseDouble(str[4]));
            itemList.get(Integer.parseInt(str[1])).addClass_Items(item);
            //physically add size?
        }
        return itemList;
    }


    public static ArrayList<Class_Item> getGraph(int constraintNum, Scanner inFile, ArrayList<Class_Item> classList) {
        for (int i = 0; i < constraintNum; i++) {
            String[] str = inFile.nextLine().split(", ");
            int k = 0;
            // the edges arent being added into the class items
            while (k < str.length - 1) {//because we don't need any action for the last vertex as already edged with others
                for (int j = k + 1; j < str.length; j++) {
                    classList.get(Integer.parseInt(str[k])).addEdge(classList.get(Integer.parseInt(str[k])), classList.get(Integer.parseInt(str[j])));
                }
                k++;
            }}
        return classList;
    }



//    public static void ArrayList<Class_Item> classMergeSort(ArrayList<Class_Item> classList){}

        public static ArrayList<Class_Item> mergeSort(ArrayList<Class_Item> list){
            if (list.size() <= 1) {
                return list;
            }
            int N = list.size()/2;
            int N2 = list.size() - N;

            // Split the array in half
            ArrayList<Class_Item> first = new ArrayList<>();   //int[list.length / 2];
            ArrayList<Class_Item> second = new ArrayList<>();  //[list.length - first.length];

            for (int i = 0; i < N; i++){
                first.add(list.get(i));
            }

            for (int i = 0; i < N2 - 1; i++) {
                second.add(list.get(i + N2));
            }
            // Sort each half
            mergeSort(first);
            mergeSort(second);

            // Merge the halves together, overwriting the original array
            merge(first, second, list);
            return list;
        }

    public static ArrayList<Item> itemMergeSort(ArrayList<Item> list){
        if (list.size() <= 1) {
            return list;
        }
        int N = list.size()/2;
        int N2 = list.size() - N;

        // Split the array in half
        ArrayList<Item> first = new ArrayList<>();   //int[list.length / 2];
        ArrayList<Item> second = new ArrayList<>();  //[list.length - first.length];

        for (int i = 0; i < N; i++){
            first.add(list.get(i));
        }

        for (int i = 0; i < N2 - 1; i++) {
            second.add(list.get(i + N2));
        }
        // Sort each half
        itemMergeSort(first);
        itemMergeSort(second);

        // Merge the halves together, overwriting the original array
        itemMerge(first, second, list);
        return list;
    }

    private static void itemMerge(ArrayList<Item> first, ArrayList<Item> second, ArrayList<Item> result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;

        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.size() && iSecond < second.size()) {
            if (first.get(iFirst).value > second.get(iSecond).value) {
                result.set(j, first.get(iFirst));
                iFirst++;
            } else {
                result.set(j, second.get(iSecond));
                iSecond++;
            }
            j++;
        }
    }

    private static void merge(ArrayList<Class_Item> first, ArrayList<Class_Item> second, ArrayList<Class_Item> result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;

        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.size() && iSecond < second.size()) {
            if (first.get(iFirst).classAvg > second.get(iSecond).classAvg) {
                result.set(j, first.get(iFirst));
                iFirst++;
            } else {
                result.set(j, second.get(iSecond));
                iSecond++;
            }
            j++;
        }

    }

    public static void sortItemsInClass (ArrayList<Class_Item> class_){
        for (int i = 0; i < class_.size();i++){
            itemMergeSort(class_.get(i).classItems);
        }

    }



//    public static Item[] getBestValueItem(ArrayList<Class_Item> sorted_List, double MaxWeight, double Budget) {
//        Item[] bestSet = new Item[1000];
//        double copyWeight = MaxWeight;
//        double copyBudget = Budget;
//        int k = 0;
//
//        // added largest value in the front of the compatible set now to add all sets compatible
////        for (int i = 0; i < 1000; i++){
////            for (int j = 0; j < sorted_List.get(i).classItems.size(); j++){
////            if (sorted_List.get(i).classItems.get(j).weight <= MaxWeight &&
////                    sorted_List.get(i).classItems.get(j).cost <= Budget)
////            {
////                MaxWeight = MaxWeight - sorted_List.get(i).classItems.get(j).weight;
////                Budget =  Budget - sorted_List.get(i).classItems.get(j).cost;
////                bestSet.add(sorted_List.get(i).classItems.get(j));}
////            }
////        }
////        System.out.println("initial weight: " + MaxWeight);
////        System.out.println("intial budgt: " + Budget);
////
////        System.out.println("weight left over : " + MaxWeight);
////        System.out.println("budget left over: " + Budget);
//
//        for(int i = 0;)
//        return bestSet;
//    }
public static Item[] getBestItems(ArrayList<Class_Item> compatibleList, double MaxWeight, double Budget) {
    //ArrayList<Item> bestSet = new ArrayList<Item>();

    int size = 0;
    for (int i = 0; i < compatibleList.size();i++){
        size+= compatibleList.get(i).size;
    }
    Item[] bestItem = new Item[size - 1];
    double copyWeight = MaxWeight;
    double copyBudget = Budget;
    int k = 0;
    // added largest value in the front of the compatible set now to add all sets compatible
    for (int i = 0; i < compatibleList.size(); i++){
        Class_Item class_item = compatibleList.get(i);
        for (int j = 0; j < class_item.classItems.size(); j++){
            if (k == size - 1) {
                i = compatibleList.size();
                break;
            }
            Item item = class_item.classItems.get(j);
            if (item.weight <= MaxWeight && item.cost <= Budget) {
                MaxWeight = MaxWeight - item.weight;
                Budget = Budget - item.cost;
                //bestSet.add(item);
                bestItem[k] = item;
                k++;
            }

        }
    }
    System.out.println("orginal weight was : " + copyWeight + "and budget was : " + copyBudget);
    System.out.println("left over weight : " + MaxWeight);
    System.out.println("left over budget : " + Budget);
    return bestItem;

}
    public static ArrayList<Class_Item> findCompatible(ArrayList<Class_Item> sortedList){
        // assuming this is a sorted list
        HashSet<Integer> addedClasses = new HashSet<>();
        HashSet<Integer> GarbageEdges = new HashSet<>();
        ArrayList<Class_Item> compatibleSet = new ArrayList<>();
        compatibleSet.add(sortedList.get(0));
        for (int j = 0; j < sortedList.get(0).edges.size(); j++){
            GarbageEdges.add(sortedList.get(0).garbageSet.get(j));
        }

        for (int i = 1; i < sortedList.size(); i++){
            if (compatibleSet.get(0).edges.contains(sortedList.get(i).name)){
                //System.out.println("not compatible: " + sortedList.get(i).name);
            }
            if (!compatibleSet.get(0).edges.contains(sortedList.get(i).name) && !addedClasses.contains(sortedList.get(i).name)){

                compatibleSet.add(sortedList.get(i));

                addedClasses.add(sortedList.get(i).name);

                //System.out.println("compatible: " + sortedList.get(i).name);
            }
        }
        return compatibleSet;
    }
//    public ArrayList<Class_Item> naieveCompatible(ArrayList<Class_Item> sortedlist){
//        HashSet<Integer> addedClasses = new HashSet<>();
//        HashSet<Integer> GarbageEdges = new HashSet<>();
//        ArrayList<Class_Item> compatibleSet = new ArrayList<>();
//        for (int i =1; i <sortedlist.size(); i++){
//
//        }
//    }

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        File file = new File(input.nextLine());
        try {
            Scanner inFile = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
        Scanner inFile = null;
        try {
            inFile = new Scanner(file);
        } catch (FileNotFoundException e) {
        }
        double maxWeight = Double.parseDouble(inFile.nextLine());
        double budget = Double.parseDouble(inFile.nextLine());
        int itemNum = Integer.parseInt(inFile.nextLine());
        int constraintNum = Integer.parseInt(inFile.nextLine());

        ArrayList<Class_Item> itemList = getItemList(itemNum, inFile);
        ArrayList<Class_Item> graph = getGraph(constraintNum, inFile, itemList);
        ArrayList<Class_Item> sortedGraph = mergeSort(graph);

        ArrayList<Class_Item> compatibleSet = findCompatible(sortedGraph);
        sortItemsInClass(compatibleSet);
        Item[] best = getBestItems(compatibleSet, maxWeight,budget);

        double bestResaleValue = 0;
        for (int i = 0; i < best.length - 1; i++){
           if (best[i] != null){
              System.out.println(best[i].name);
               bestResaleValue+= best[i].cost;
           }
        }
        System.out.println("total spent: " + bestResaleValue);
//        System.out.println("You Made: " + bestResaleValue + " $$$");
//
//        for (int j =0; j < 15000; j++){
//            System.out.println("Class: " + compatibleSet.get(j) + ", item: " + compatibleSet.get(j).classAvg +
//                    ", Size: " + compatibleSet.get(j).size);}

        double totalweight = 0;
        double totalcost = 0;
        Class_Item list1 = new Class_Item(1);
        Class_Item list2 = new Class_Item(2);
        Class_Item list3 = new Class_Item(3);
        Class_Item list4 = new Class_Item(4);
        list1.classAvg = 10;
        list2.classAvg = 5;
        list3.classAvg = 1;
        list4.classAvg = 2;
        list1.addEdge(list1,list2);
        list1.addEdge(list1,list4);
        ArrayList<Class_Item> allClass = new ArrayList<>();
        allClass.add(list1);
        allClass.add(list2);
        allClass.add(list3);
        allClass.add(list4);
     //   allClass = mergeSort(allClass);
     //   allClass = findCompatible(allClass);


//        for (int j =0; j < 1000; j++){
//
//            System.out.println("~*~*~*~*~*~*~*~*~*~*");
//            System.out.println("Class: " + sortedGraph.get(j));
//            for (int i = 0; i < sortedGraph.get(j).classItems.size();i++){
//                System.out.println(" name: " + sortedGraph.get(j).classItems.get(i).name);
//                System.out.println(" value: " + sortedGraph.get(j).classItems.get(i).value);
//                System.out.println(" cost: " + sortedGraph.get(j).classItems.get(i).cost);
//
//                System.out.println(" weight: " + sortedGraph.get(j).classItems.get(i).weight);
//                totalweight+= sortedGraph.get(j).classItems.get(i).weight;
//                totalcost+= sortedGraph.get(j).classItems.get(i).cost;
//
//            }
//            System.out.println("~*~*~*~*~*~*~*~*~*~*");
//
//        }
//        System.out.println("total cost: " + totalcost);
//        System.out.println("total weight: " + totalweight);

//        for (int j =0; j < 1000; j++){
//
//            System.out.println("~*~*~*~*~*~*~*~*~*~*");
//            System.out.println("Class: " + compatibleSet.get(j));
//            for (int i = 0; i < best.size();i++){
//                System.out.println(" name: " + best.get(j).name);
//                System.out.println(" value: " + best.get(j).value);
//                System.out.println(" cost: " + best.get(j).cost);
//
//                System.out.println(" weight: " + best.get(j).weight);
//                totalweight+= best.get(j).weight;
//                totalcost+= best.get(j).cost;
//
//            }
//            System.out.println("~*~*~*~*~*~*~*~*~*~*");
//            System.out.println("total cost: " + totalcost);
//            System.out.println("total weight: " + totalweight);
//}
    }}
