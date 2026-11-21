import java.util.ArrayList;
import java.util.Scanner;


/** A simple console app for adding, viewing, searching, and deleting appointments. */
public class AppointmentBook {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = readChoice();
            switch (choice) {
                case 1: addAppointment(); break;
                case 2: viewAppointments(); break;
                case 3: searchAppointments(); break;
                case 4: deleteAppointment(); break;
                case 5: System.out.println("Goodbye!"); break;
                default: System.out.println("Please choose a number from 1 to 5.");
            }
        } while (choice != 5);
    }

    private static void showMenu() {
        System.out.println("\n===== AppointmentBook =====");
        System.out.println("1. Add Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("3. Search by Name");
        System.out.println("4. Delete Appointment");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static int readChoice() {
        String input = scanner.nextLine();
        try { return Integer.parseInt(input); }
        catch (NumberFormatException e) { return -1; }
    }

    private static void addAppointment() {
        System.out.print("Person's name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Date (e.g., 2026-12-05): ");
        String date = scanner.nextLine().trim();
        System.out.print("Time (e.g., 10:30 AM): ");
        String time = scanner.nextLine().trim();
        System.out.print("Purpose: ");
        String purpose = scanner.nextLine().trim();

        if (name.isEmpty() || date.isEmpty() || time.isEmpty() || purpose.isEmpty()) {
            System.out.println("All fields are required. Appointment was not saved.");
            return;
        }
        appointments.add(new Appointment(name, date, time, purpose));
        System.out.println("Appointment added successfully!");
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments yet.");
            return;
        }
        System.out.println("\n--- Appointment List ---");
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println("Appointment #" + (i + 1));
            appointments.get(i).display();
        }
    }

    private static void searchAppointments() {
        System.out.print("Enter name to search: ");
        String searchName = scanner.nextLine().trim();
        boolean found = false;
        for (Appointment appointment : appointments) {
            if (appointment.getName().toLowerCase().contains(searchName.toLowerCase())) {
                appointment.display();
                found = true;
            }
        }
        if (!found) System.out.println("No matching appointments found.");
    }

    private static void deleteAppointment() {
        viewAppointments();
        if (appointments.isEmpty()) return;
        System.out.print("Enter appointment number to delete: ");
        int number = readChoice();
        if (number >= 1 && number <= appointments.size()) {
            appointments.remove(number - 1);
            System.out.println("Appointment deleted.");
        } else {
            System.out.println("Invalid appointment number.");
        }
    }
}
