import java.util.Random;
import java.lang.*;

public class Sort {

    long counter = 0;

    int[] shuffleArray(int[] array) {
        Random random = new Random();
        int[] holder = new int[array.length];
        int[] holder2 = new int[array.length];
        boolean repeat = false;
        boolean startOver = false;

        for(int i = 1; i < array.length + 1; i++) {
            do {
                int rand = (Math.abs(random.nextInt()) % (array.length))+1;
                if (i != 1) {
                    for (int place : holder) {
                        if (place == rand) {
                            repeat = true;
                        }
                    }
                    if (!repeat) {
                        holder[i - 1] = rand;
                        startOver = false;
                    } else {
                        repeat = false;
                        startOver = true;
                    }
                } else {
                    holder[i - 1] = rand;
                }
            } while (startOver);
        }

        for (int i = 0; i < array.length; i++) {
            holder2[i] = array[i];
        }

        for (int i = 0; i < array.length; i++) {
            array[holder[i] - 1] = holder2[i];
        }

        return array;
    }

    long bogoSort(int[] array) {
        //shuffleArray(array);

        do {
            int x = -2147483648;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > x) {
                    if (i == array.length - 1) {
                        //printArray(array);
                        //System.out.println();
                        return counter;
                    }
                    x = array[i];
                } else {
                    counter++;
                    array = shuffleArray(array);
                    i = -1;
                    x = -2147483648;
                }
            }
        } while (true);

    }

    void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String args[]) {
        int[] randArray = {5,45,12345,0,-9,1,2};
        //int[] randArray = {1,2,3};
        Sort s = new Sort();

        long balancer = 0;
        int numberOfIterations = 100000;

        for (int i = 0; i < numberOfIterations; i++) {
            balancer += s.bogoSort(randArray);
        }

        System.out.println("Average: " + (double)balancer/numberOfIterations);

        //System.out.println("Number of times run: " + s.bogoSort(randArray));
    }
}