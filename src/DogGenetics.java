import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args) {
        //ask for name
        System.out.println("What is your dog's name?");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Well then, I have this highly reliable report on " + name + "'s prestigious background right here.");
        System.out.println(name + " is:");

        //generate random genes
        String[] breeds = {"St. Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};

        Random rng = new Random();
        int[] partition = new int[breeds.length+1];
        partition[0] = 0;
        partition[partition.length-1] = 100;

        for (int i = 1; i < partition.length-1; i++) {
            partition[i] = rng.nextInt(101);
        }
        Arrays.sort(partition);

        for (int i = 1; i < partition.length; i++) {
            int percent = partition[i] - partition[i-1];
            System.out.println(percent + "% " + breeds[i-1]);
        }
    }
}
