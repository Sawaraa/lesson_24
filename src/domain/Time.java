package domain;

public class Time implements Comparable<Time>{

    int min;
    int hour;

    public Time(int hour, int min){
        if(hour < 0 || hour > 24){
            throw new IllegalArgumentException("Неправильне значення години: " + hour);
        }
        if (min < 0 || min > 60) {
            throw new IllegalArgumentException("Неправильне значення хвилини: " + min);
        }
        this.hour = hour;
        this.min = min;
    }

    public int getMin() {
        return min;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public String toString() {
        return  hour + ":" + min;
    }

    @Override
    public int compareTo(Time other) {
        if (this.hour != other.hour) {
            return Integer.compare(this.hour, other.hour);
        }
        return Integer.compare(this.min, other.min);
    }
}
