import java.util.Random;
import java.util.Scanner;
public class ArrayStuff {
    final static int SIZE = 100;
    final static int DATA_RANGE = 100;
    static int[] dataPoints;
    static Random gen = new Random();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        dataPoints = new int[SIZE]; // 0 - 100
        boolean found = false;
        int highest = -1;
        int lowest = 101;

        setData();
        showData();

        int target = SafeInput.getRangedInt(in, "Enter the target", 1,100);
        // FindAll
        for (int d = 0; d < dataPoints.length; d++) {
            if(dataPoints[d] == target) {
                System.out.println("Found target ("+ target + ") at locus " + d);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Did not find target " + target);
        }
        System.out.println();
        target = SafeInput.getRangedInt(in, "Enter the second target", 1,100);
        //FindFirst
        int foundLocus1 = -1;
        for (int d = 0; d < dataPoints.length; d++) {
            if(dataPoints[d] == target) {
                foundLocus1 = d;
                System.out.println("Found target ("+ target + ") at locus " + d);
                break;
            }
        }
        if(foundLocus1 == -1) {
            System.out.println("Did not find target " + target);
        }
        //FindLast
        int foundLocus = -1;
        for (int d = 0; d < dataPoints.length; d++) {
            if(dataPoints[d] == target) {
                foundLocus = d;
                System.out.println("Found target ("+ target + ") at locus " + d);
            }
        }
        if(foundLocus == -1) {
            System.out.println("Did not find target " + target);
        }
        //FindHighest
        for(int d = 0; d < dataPoints.length; d++) {
            if (dataPoints[d] > highest) {
                highest = dataPoints[d];
            }
        }
        System.out.println("Highest locus is " + highest);
        //FindLowest
        for (int d = 0; d < dataPoints.length; d++) {
            if (dataPoints[d] < lowest) {
                lowest = dataPoints[d];
            }
        }
        System.out.println("Lowest locus is " + lowest);

        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));

    }
    public static double getAverage(int values[]) {
        int sum = 0;
        int average = 0;

        for (int d = 0; d < values.length; d++) {
            sum += values[d];
            average = sum / values.length;
        }
        return average;
    }


        private static void setData () {
            //seed the array with random values
            for (int d = 0; d < dataPoints.length; d++) {
                dataPoints[d] = gen.nextInt(DATA_RANGE);
            }
            System.out.println();
        }
        private static void showData () {
            for (int d = 0; d < dataPoints.length; d++) {
                System.out.print(dataPoints[d] + " | ");
            }
            System.out.println();
        }
}

