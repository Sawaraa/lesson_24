package model;

import domain.Movie;

import java.util.Set;
import java.util.TreeSet;

public class Schedule {

    Set<Seance> seances = new TreeSet<>();

    public void addSeance(Seance seance){
        seances.add(seance);
    }

    public void removeSeance(Seance seance){
        seances.remove(seance);
    }

    @Override
    public String toString() {
        return "Schedule: "+ seances;
    }
}
