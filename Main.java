import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static double[][] distances= new double[12][12];
    //this array will store min values calculated by method.
    static ArrayList<Double> minumumDistances = new ArrayList<Double>();
    public static void main(String[] args) throws FileNotFoundException {
        java.io.File file = new java.io.File("input.txt");
        Scanner input = new Scanner(file);
        Scanner input1 = new Scanner(file);
        int numberOfHomes = 0;

        //computing array size.
        while (input.hasNextLine()) {
            input.nextLine();
            numberOfHomes++;
        }
        input.close();

        double[][] coordinates = new double[numberOfHomes][2];

        int coordinantOfMigros = 0;

        for (int i = 0; input1.hasNextLine(); i++) {
            String line = input1.nextLine();
            String[] arrLine = line.split(",");
            // if line contains three data then it is coordinate of Migros.
            if (arrLine.length == 3) coordinantOfMigros = i;
            coordinates[i][0] = Double.parseDouble(arrLine[0]);
            coordinates[i][1] = Double.parseDouble(arrLine[1]);

        }

        input1.close();

        ArrayList<Integer> homes = new ArrayList<>();
        // calculating distances and storing them in static distances double array
        for (int i  = 0 ; i<coordinates.length;i++){
            for (int j = 0 ; j<coordinates.length;j++){
                double disX = coordinates[i][0] - coordinates[j][0];
                double disY = coordinates[i][1] - coordinates[j][1];
                double distance = Math.sqrt(Math.pow(disY,2) + Math.pow(disX,2));
                distances[i][j]=distance;
            }
        }
        //adding all home numbers to ArrayList
        for (int i = 0 ; i<numberOfHomes;i++){
            if (i!=coordinantOfMigros) homes.add(i);
        }
        //adding 100 for comparison
        minumumDistances.add((double) 100);

        //initializing method

        drawPath(homes,0,coordinantOfMigros);


    }

    // this methol will compute distances with given points
    public static double mesureDistance(ArrayList<Integer> distances1,int migros){
        double ans = 0;
        int curr = 0;

        for (int i = 0 ; i<distances1.size();i++){

            if (i!=distances1.size()-1){
                ans+=distances[distances1.get(curr)][distances1.get(curr+1)];
                //updating this for not repeat same home
                curr = i+1;
            }
            //adding Migros distance at the end. it will reduce computation cost.
            else ans+=distances[distances1.get(distances1.size()-1)][migros]+distances[migros][distances1.get(0)];
        }
        return ans;

    }

    //this method will create all possible routes and compare total distance with very last element of minumumDistances arraylist
    //if current distance is less than last one method will add distance to arraylist and will do this until all paths calculated.
    static void drawPath(ArrayList<Integer> arr, int k, int migros){

        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            drawPath(arr, k+1,migros);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
            double x = mesureDistance(arr,migros);
            if (x<minumumDistances.get(minumumDistances.size()-1)){
                minumumDistances.add(x);

                // creating another list for printing
                ArrayList<Integer> a = new ArrayList<>(arr);
                a.add(0,migros);
                a.add(migros);
                for (int i = 0 ; i<a.size();i++){
                    a.set(i,a.get(i) +1);
                }
                System.out.println("Shortest Route:   "+a);
                System.out.println("Distance: " + x);
                System.out.println(" ");
            }
        }


    }

}

