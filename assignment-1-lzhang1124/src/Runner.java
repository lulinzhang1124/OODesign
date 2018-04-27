class Runner {

    private String name;
    private Time startTime;
    private Time duration;

    public Runner(String name,Time startTime, Time duration){
        this.name = name;
        this.startTime = startTime;
        this.duration = duration;
    }

    public String getName() {
        return this.name;
    }

    public Time getStartTime() {
        return this.startTime;
    }

    public Time getDuration() {
        return this.duration;
    }

    public Time getEndTime(){
        Integer seconds = startTime.getSeconds() + duration.getSeconds();
        Integer minutes = startTime.getMinutes() + duration.getMinutes();
        Integer hours = startTime.getHours() + duration.getHours();
        if(seconds >= 60){
            seconds -= 60;
            minutes++;
        }
        if(minutes >= 60){
            minutes -= 60;
            hours++;
        }
        if(hours >=24){
            hours -= 24;
        }
        return new Time(hours,minutes,seconds);

    }
}
