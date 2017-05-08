import sun.applet.Main;

/******************************************************************************
 *  Compilation:  javac Knapsack.java
 *  Execution:    java Knapsack N W
 *
 *  Generates an instance of the 0/1 knapsack problem with N items
 *  and maximum weight W and solves it in time and space proportional
 *  to N * W using dynamic programming.
 *
 *  For testing, the inputs are generated at random with weights between 0
 *  and W, and profits between 0 and 1000.
 *
 *  %  java Knapsack 6 2000
 *  item    profit  weight  take
 *  1       874     580     true
 *  2       620     1616    false
 *  3       345     1906    false
 *  4       369     1942    false
 *  5       360     50      true
 *  6       470     294     true
 *
 ******************************************************************************/

public class Knap {

    public void getKnap(String[] name2, double[] profit2, double weight2[], double[] cost2, double maxWeight, double budget) {

        int savedBudget = (int) budget;
        int N = name2.length;
        int  W = (int) maxWeight;
        String[] name = new String[N+1];
        int[] profit = new int[N+1];
        int[] weight = new int[N+1];
        int[] cost = new int[N+1];
        for (int n = 1; n <= N; n++) {
            name[n] = name2[n - 1];
            profit[n] = (int) profit2[n - 1];
            weight[n] = (int) weight2[n - 1];
            cost[n] = (int) cost2[n - 1];
        }
        // opt[n][w] = max profit of packing items 1..n with weight limit w
        // sol[n][w] = does opt solution to pack items 1..n with weight limit w include item n?
        int[][] opt = new int[N+1][W+1];
        boolean[][] sol = new boolean[N+1][W+1];

        for (int n = 1; n <= N; n++) {
            for (int w = 1; w <= W; w++) {

                // don't take item n
                int option1 = opt[n-1][w];

                // take item n
                int option2 = Integer.MIN_VALUE;
                if (weight[n] <= w) {
                    option2 = profit[n] + opt[n-1][w-weight[n]];
                }

                // select better of two options
                opt[n][w] = Math.max(option1, option2);

                sol[n][w] = (option2 > option1);
            }
        }

        // determine which items to take
        boolean[] take = new boolean[N+1];
        for (int n = N, w = W; n > 0; n--) {
            if (sol[n][w] && budget - cost[n] >= 0) {
                take[n] = true;
                w = w - weight[n];
                budget = budget - cost[n];
            }
            else {
                take[n] = false;
            }
        }

        // print results
        System.out.println("item name" + "\t\t" + "value" + "\t\t" + "weight" + "\t\t" + "cost");
        int totalWeight = 0;
        int totalValue = 0;
        for (int n = 1; n <= N; n++) {
            if (take[n]) {
                System.out.println(name[n] + "\t\t\t" + profit[n] + "\t\t\t" + weight[n] + "\t\t\t" + cost[n]);
                totalWeight = totalWeight + weight[n];
                totalValue = totalValue + profit[n];
            }
        }
        System.out.println("Total weight is : " + totalWeight);
        System.out.println("Total value is : " + totalValue);
        System.out.println("Original budget was : " + savedBudget + ", and Left budget is : " + budget);
    }

    public static void main(String[] args) {
        Knap knap = new Knap();
        String name[] = new String[]{"dummy_item", "item_1", "item_2", "item_3"};
        double profit[] = new double[]{0, 60, 100, 120};
        double weight[] = new double[]{0, 10, 20, 30};
        double cost[] = new double[]{0, 30, 50, 60};
        double budget = 200;
        double maxWeight = 50;
        knap.getKnap(name, profit, weight, cost, maxWeight, budget);
    }
}
