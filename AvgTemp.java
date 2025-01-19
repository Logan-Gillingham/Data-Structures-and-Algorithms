import java.util.Scanner;

public class AvgTemp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of days: ");
        int numDays = scanner.nextInt();

        double[] temps = new double[numDays];

        System.out.println("Enter the temperatures for each day:");
        for (int i = 0; i < numDays; i++) {
            temps[i] = scanner.nextDouble();
        }

        double sum = 0;
        for (double temp : temps) {
            sum += temp;
        }
        double averageTemperature = sum / numDays;

        System.out.println("Average temperature: " + averageTemperature);

        int daysAboveAverage = 0;
        for (double temp : temps) {
            if (temp > averageTemperature) {
                daysAboveAverage++;
            }
        }

        System.out.println("Number of days above average temperature: " + daysAboveAverage);
        scanner.close();
    }
}