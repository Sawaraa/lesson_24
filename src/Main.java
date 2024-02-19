import domain.Movie;
import domain.Time;
import model.Cinema;
import model.DaysOfWeek;
import model.Seance;

import java.util.Scanner;

public class Main {

    public static void list(){
        System.out.println("1. Add movie in Movies Library" + "\n"
                        + "2. Output all movie" + "\n"
                        + "3. Delete movie from Movies Library" + "\n"
                        + "4. Add new seance in schedules" + "\n"
                        + "5. Remove seance from schedules" + "\n"
                        + "6. Output schedules" + "\n"
                        + "7. Exit" + "\n"
                        + "Enter your option");

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Time open = new Time(10, 0);
        Time close = new Time(23, 0);
        Cinema cinema = new Cinema(open,close);
        Seance newSeance = new Seance();
        while (true) {
            list();
            int option = scanner.nextInt();
            switch (option) {
                case 1:{
                    System.out.println("Enter movie title:");
                    String title = scanner.next();
                    System.out.println("Enter movie duration:");
                    int hour = scanner.nextInt();
                    int min = scanner.nextInt();
                    Time duration = new Time(hour, min);
                    Movie movie = new Movie(title, duration);
                    cinema.addMovie(movie);
                }
                    break;
                case 2: {
                    cinema.output();
                }
                    break;
                case 3: {
                    System.out.println("Enter movie title:");
                    String title = scanner.next();
                    System.out.println("Enter movie duration:");
                    int hour = scanner.nextInt();
                    int min = scanner.nextInt();
                    Time duration = new Time(hour, min);
                    Movie movie = new Movie(title, duration);
                    cinema.removeMovie(movie);
                }
                    break;
                case 4: {
                    System.out.println("Enter day");
                    String day = scanner.next();
                    System.out.println("Enter movie title:");
                    String title = scanner.next();
                    System.out.println("Enter movie duration:");
                    int hour = scanner.nextInt();
                    int min = scanner.nextInt();
                    Time duration = new Time(hour, min);
                    Movie movie = new Movie(title, duration);
                    System.out.println("Enter movie start time -");
                    int hourStart = scanner.nextInt();
                    int minStart = scanner.nextInt();
                    Time startTime = new Time(hourStart, minStart);
                    Seance seance= new Seance(movie,startTime,newSeance.calculateEndTime(startTime,duration));
                    cinema.addSeance(day,seance);
                }
                    break;
                case 5: {
                    System.out.println("Enter day");
                    String day = scanner.next();
                    System.out.println("Enter movie title:");
                    String title = scanner.next();
                    System.out.println("Enter movie duration:");
                    int hour = scanner.nextInt();
                    int min = scanner.nextInt();
                    Time duration = new Time(hour, min);
                    Movie movie = new Movie(title, duration);
                    System.out.println("Enter movie start time -");
                    int hourStart = scanner.nextInt();
                    int minStart = scanner.nextInt();
                    Time startTime = new Time(hourStart, minStart);
                    Seance seance= new Seance(movie,startTime,newSeance.calculateEndTime(startTime,duration));
                    cinema.removeSeance(day,seance);
                }
                    break;
                case 6:{
                    cinema.outputSchedules();
                }
                break;
                case 7: {
                    System.exit(0);
                }
                    break;
                default:
                    System.out.println("Число не в діапазоні від 1 до 6");
            }
        }



    }
}