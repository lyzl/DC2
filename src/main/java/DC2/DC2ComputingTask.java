package DC2;

public class DC2ComputingTask {
    private Float duration;
    private Float occupation;
    private String id;

    public Float getDuration() {
        return duration;
    }

    public Float getOccupation() {
        return occupation;
    }

    public String getId() {
        return id;
    }

    DC2ComputingTask(Float duration, Float occupation, String id) {
        this.duration = duration;
        this.id = id;
        this.occupation = occupation;
    }
}


