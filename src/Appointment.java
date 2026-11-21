import java.util.Scanner;

public class Appointment {
    private String name;
    private String date;
    private String time;
    private String purpose;

    public Appointment(String name, String date, String time, String purpose) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.purpose = purpose;
    }

    public String getName() { return name; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getPurpose() { return purpose; }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Purpose: " + purpose);
        System.out.println("------------------------------");
    }
}
