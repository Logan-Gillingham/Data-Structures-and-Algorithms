import java.util.*;

public class MovieTheater {

    private static final int ROWS = 10;
    private static final int COLS = 15;
    private static char[][] seatingChart;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeSeatingChart();
        displayMenu();
    }

    private static void initializeSeatingChart() {
        seatingChart = new char[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seatingChart[i][j] = '.';
            }
        }
    }

    private static void displayMenu() {
        int choice;
        do {
            System.out.println("\nMovie Theater Menu:");
            System.out.println("1. Reserve Seats");
            System.out.println("2. Cancel Seats");
            System.out.println("3. View Seating Chart");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    reserveSeats();
                    break;
                case 2:
                    cancelSeats();
                    break;
                case 3:
                    viewSeatingChart();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void reserveSeats() {
        System.out.print("Enter the number of seats to reserve: ");
        int numSeats = scanner.nextInt();

        List<String> reservedSeats = new ArrayList<>();

        for (int i = 0; i < numSeats; i++) {
            System.out.print("Enter row number (1-" + ROWS + "): ");
            int row = scanner.nextInt() - 1;
            System.out.print("Enter column number (1-" + COLS + "): ");
            int col = scanner.nextInt() - 1;

            if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
                System.out.println("Invalid seat selection. Please try again.");
                i--;
                continue;
            }

            if (seatingChart[row][col] == '.') {
                seatingChart[row][col] = 'X'; // 'X' represents a reserved seat
                reservedSeats.add("Row " + (row + 1) + ", Seat " + (col + 1));
            } else {
                System.out.println("Seat at Row " + (row + 1) + ", Seat " + (col + 1) + " is already taken.");

                for (int r = 0; r < ROWS; r++) {
                    for (int c = 0; c < COLS; c++) {
                        if (seatingChart[r][c] == '.') {
                            System.out.println("Available seat: Row " + (r + 1) + ", Seat " + (c + 1));
                            break;
                        }
                    }
                }

                i--;
            }
        }
        if (!reservedSeats.isEmpty()) {
            System.out.println("Seats reserved successfully:");
            for (String seat : reservedSeats) {
                System.out.println(seat);
            }
        }
    }

    private static void cancelSeats() {
        System.out.print("Enter the row number of the seat to cancel: ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter the column number of the seat to cancel: ");
        int col = scanner.nextInt() - 1;

        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Invalid seat selection.");
        } else if (seatingChart[row][col] == '.') {
            System.out.println("Seat at Row " + (row + 1) + ", Seat " + (col + 1) + " is already empty.");
        } else {
            seatingChart[row][col] = '.';
            System.out.println("Seat at Row " + (row + 1) + ", Seat " + (col + 1) + " has been canceled.");
        }
    }

    private static void viewSeatingChart() {
        System.out.println("\nSeating Chart:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(seatingChart[i][j] + " ");
            }
            System.out.println();
        }
    }
}