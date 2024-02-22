package model;

import domain.Movie;
import domain.Time;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Cinema {

    TreeMap<String, Schedule> schedules = new TreeMap<String, Schedule>();
    ArrayList<Movie> moviesLibrary = new ArrayList<>();

    Time open;
    Time close;

    public Cinema(Time open, Time close) {
        this.open = open;
        this.close = close;
    }

    public Cinema(TreeMap<String, Schedule> schedules) {
        this.schedules = schedules;
    }

    public void addMovie(Movie movie){
        moviesLibrary.add(movie);
    }

    public void output(){
        moviesLibrary.forEach(System.out::println);
    }

    public void removeMovie(Movie movie){
       boolean remove = moviesLibrary.removeIf(movies -> movie.getTitle().equalsIgnoreCase(movies.getTitle()) &&
                (movie.getDuration().getHour() == movies.getDuration().getHour())
                && (movie.getDuration().getMin() == movies.getDuration().getMin()));
       if(remove){
           System.out.println("You successfully delete movie");
       }
       else { System.out.println("No matching movie found for deletion");}

    }

    public void addSeance(String day, Seance seance){
        if (isOpen(seance.getStartTime()) && isClose(seance.getEndTime())) {
            boolean isWeekday = Arrays.stream(DayOfWeek.values())
                    .anyMatch(dayOfWeek -> dayOfWeek.name().equals(day.toUpperCase()));
            if (isWeekday){
                //перевіряє чи існує вже такий розклад за днем тижня, яко існує то повертає його, ні - створє новий
                Schedule schedule = schedules.getOrDefault(day, new Schedule());
                schedule.addSeance(seance);
                schedules.put(day, schedule);
                System.out.println("You add new seance");
            }
           else{System.out.println("You enter the wrong day of week");}
        }
        else {System.out.println("The cinema is closed during this time");}
    }

    public void removeSeance(String day, Seance seance){
        if (isOpen(seance.getStartTime()) && isClose(seance.getEndTime())) {
            boolean isWeekday = Arrays.stream(DayOfWeek.values())
                    .anyMatch(dayOfWeek -> dayOfWeek.name().equals(day.toUpperCase()));
            if (isWeekday){
                //перевіряє чи існує вже такий розклад за днем тижня, яко існує то повертає його, ні - створє новий
                Schedule schedule = schedules.get(day);
                schedule.removeSeance(seance);
                System.out.println("You delete seance");
            }
            else{System.out.println("You enter the wrong day of week");}
        }
        else {System.out.println("The cinema is closed during this time");}
    }

    public void outputSchedules(){
        for(Schedule schedule : schedules.values()){
            System.out.println(schedule);
        }
    }

    public boolean isOpen(Time time){
        return (time.getHour() > open.getHour() || (time.getHour() == open.getHour() && time.getMin() >= open.getMin()));
    }

    public boolean isClose(Time time){
        return (time.getHour() < close.getHour() || (time.getHour() == close.getHour() && time.getMin() <= close.getMin()));
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "schedules=" + schedules +
                '}';
    }
}
