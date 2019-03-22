package DC2;
enum TaskPriorty{
    High, MediumHigh, Medium, MediumLow, low
}
public class DC2ComputingTask {
    public Long duration;
    public Float occupation;
    public String id;

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
    public String checkId(String id) {

        if(Integer.parseInt(id)<0)
            return "Error: Task Id cannot be less than 0";
        return id;
    }
}


