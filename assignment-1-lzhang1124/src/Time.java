public class Time {

    private Integer hours;
    private  Integer minutes;
    private Integer seconds;

    public Time(Integer hours, Integer minutes, Integer seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Integer getHours() {
        return hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }
}
