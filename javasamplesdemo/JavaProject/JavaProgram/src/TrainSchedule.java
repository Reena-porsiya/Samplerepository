import java.util.*;

public class TrainSchedule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the from date (yyyy-MM-dd): ");
        String fromDate = scanner.nextLine();

        System.out.print("Enter the to date (yyyy-MM-dd): ");
        String toDate = scanner.nextLine();

        System.out.print("Enter the source: ");
        String source = scanner.nextLine();

        System.out.print("Enter the destination: ");
        String destination = scanner.nextLine();

        Train[] trains = {
            new Train("2023-09-16", "TrainNumber 12102", "CHENNAI", "DELHI"),
            new Train("2023-09-17", "TrainNumber 12102", "CHENNAI", "DELHI"),
            new Train("2023-09-16", "TrainNumber 13142", "CHENNAI", "Hyderabad"),
            new Train("2023-09-16", "TrainNumber 13153", "CHENNAI", "Hyderabad"),
        };

        // Method 1: Display train schedules based on date, source, and destination
        displayTrainSchedulesForDateAndLocation(trains, fromDate, source, destination);

        // Method 2: Display train schedules between two dates
        displayTrainSchedulesForDateRange(trains, fromDate, toDate);

        scanner.close();
    }

    public static void displayTrainSchedulesForDateAndLocation(Train[] trains, String date, String source, String destination) {
        boolean found = false;

        for (Train train : trains) {
            if (train.getDate().equals(date) && train.getSource().equals(source) && train.getDestination().equals(destination)) {
                System.out.println("Train schedule for " + date + ":");
                System.out.println("Train Number: " + train.getTrainNumber());
                System.out.println("Source: " + train.getSource());
                System.out.println("Destination: " + train.getDestination());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No train schedules found for the provided date, source, and destination.");
        }
    }

    public static void displayTrainSchedulesForDateRange(Train[] trains, String fromDate, String toDate) {
        boolean found = false;

        for (Train train : trains) {
            if (isDateInRange(train.getDate(), fromDate, toDate)) {
                System.out.println("Train schedule for " + train.getDate() + ":");
                System.out.println("Train Number: " + train.getTrainNumber());
                System.out.println("Source: " + train.getSource());
                System.out.println("Destination: " + train.getDestination());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No train schedules found for the provided date range.");
        }
    }

    public static boolean isDateInRange(String date, String fromDate, String toDate) {
        return date.compareTo(fromDate) >= 0 && date.compareTo(toDate) <= 0;
    }

    static class Train {
        private String date;
        private String trainNumber;
        private String source;
        private String destination;

        public Train(String date, String trainNumber, String source, String destination) {
            this.date = date;
            this.trainNumber = trainNumber;
            this.source = source;
            this.destination = destination;
        }

        public String getDate() {
            return date;
        }

        public String getTrainNumber() {
            return trainNumber;
        }

        public String getSource() {
            return source;
        }

        public String getDestination() {
            return destination;
        }
    }
}
