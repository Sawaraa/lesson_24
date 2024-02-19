package model;

import domain.Movie;
import domain.Time;

public class Seance implements Comparable<Seance>{

    Movie movie;

    Time startTime;

    Time endTime;

    public Seance(){
    }

    public Seance(Movie movie, Time startTime, Time endTime) {
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = calculateEndTime(startTime, movie.getDuration());
    }

    public Time calculateEndTime(Time startTime, Time duration){
        int durationTotal = duration.getHour() * 60 + duration.getMin();
        int endHour = startTime.getHour() + durationTotal / 60;
        int endMinute = startTime.getMin() + durationTotal % 60;

        if (endMinute >= 60) {
            endMinute -= 60;
            endHour++;
        }

        return new Time(endHour, endMinute);
    }

    public Movie getMovie() {
        return movie;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Seance: "+ movie +
                ", startTime - " + startTime +
                ", endTime - " + endTime;
    }

    @Override
    public int compareTo(Seance other) {
        return this.startTime.compareTo(other.startTime);
    }

//    @Override
//    public int compareTo(Seance otherSeance) {
//        // Порівнюємо час початку сеансів
//        return this.startTime.compareTo(otherSeance.startTime);
//    }
}
