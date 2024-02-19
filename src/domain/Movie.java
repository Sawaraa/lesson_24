package domain;

public class Movie {
    String title;
    Time duration;

    public Movie() {
    }

    public Movie(String title, Time duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public Time getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Movie: " +
                "Title - '" + title + '\'' +
                ", duration - " + duration;
    }

}
