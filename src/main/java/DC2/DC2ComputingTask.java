package DC2;
enum TaskPriorty{
    High, MediumHigh, Medium, MediumLow, low
}
public class DC2ComputingTask {
    private Long duration;
    private Float occupation;
    private String id;

    public Long getDuration() {
        return duration;
    }

    public Float getOccupation() {
        return occupation;
    }

    public String getId() {
        return id;
    }

    DC2ComputingTask(Long duration, Float occupation, String id) {
        this.duration = duration;
        this.id = id;
        this.occupation = occupation;
    }
}


