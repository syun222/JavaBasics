import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        int age = readValue("What is your age?");
        int maxHeartRate = 220 - age;
        int targetMin = (int) Math.round(0.5*maxHeartRate);
        int targetMax = (int) Math.round(0.85*maxHeartRate);

        System.out.println("Your maximum heart rate should be " + maxHeartRate + " beats per minute");
        System.out.println("Your target HR zone is " + targetMin + " - " + targetMax + " beats per minute");
    }

    public static int readValue(String promt) {
        Scanner sc = new Scanner(System.in);
        int value = 0;
        boolean isValid = false;
        do {
            try {
                System.out.println(promt);
                value = Integer.parseInt(sc.nextLine());
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("not valid");
            }
        } while (!isValid);
        return value;
    }
}
