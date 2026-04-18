import java.util.Scanner;

public class Hotel {
    private boolean[] rooms;
    private Scanner scanner;

    public Hotel(int totalRooms) {
        rooms = new boolean[totalRooms]; // false = available
        scanner = new Scanner(System.in);
    }

    public void run() {
        int choice;
        do {
            System.out.println("\nHotel Booking System");
            System.out.println("1. Book a room");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Display available rooms");
            System.out.println("4. Calculate bill");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> bookRoom();
                case 2 -> cancelReservation();
                case 3 -> displayAvailableRooms();
                case 4 -> calculateBill();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option!");
            }
        } while (choice != 0);
    }

    public void bookRoom() {
        System.out.print("Enter room number (0 - " + (rooms.length - 1) + "): ");
        int room = scanner.nextInt();
        if (isValid(room)) {
            if (!rooms[room]) {
                rooms[room] = true;
                System.out.println("Room " + room + " booked successfully.");
            } else {
                System.out.println("Room already booked.");
            }
        } else {
            System.out.println("Invalid room number.");
        }
    }

    public void cancelReservation() {
        System.out.print("Enter room number to cancel: ");
        int room = scanner.nextInt();
        if (isValid(room)) {
            if (rooms[room]) {
                rooms[room] = false;
                System.out.println("Reservation for room " + room + " cancelled.");
            } else {
                System.out.println("Room is not booked.");
            }
        } else {
            System.out.println("Invalid room number.");
        }
    }

    public void displayAvailableRooms() {
        System.out.print("Available rooms: ");
        for (int i = 0; i < rooms.length; i++) {
            if (!rooms[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public void calculateBill() {
        System.out.print("Enter number of nights: ");
        int nights = scanner.nextInt();
        System.out.print("Enter price per night: ");
        double rate = scanner.nextDouble();
        double total = nights * rate;

        if (nights >= 5) {
            total *= 0.9; // 10% discount
            System.out.println("10% discount applied for long stay.");
        }

        System.out.printf("Total bill: $%.2f%n", total);
    }

    private boolean isValid(int room) {
        return room >= 0 && room < rooms.length;
    }
}
