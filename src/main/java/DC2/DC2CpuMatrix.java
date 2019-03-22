package DC2;

public class DC2CpuMatrix {
    public Float workload;
    public Float score;
    public DC2CpuAgent agent;
    DC2CpuMatrix(DC2CpuAgent agent){
        this.agent = agent;
    }
    public String checkScore() {
        if(score<0)
            return "Score cannot be less than zero";
        else if (score >= 0 && score <= 50)
            return "Valid score";
        else if (score > 50)
            return "Score cannot be greater than 50";
        return "";
    }
    DC2CpuMatrix(Float score,DC2CpuAgent agent){
        this.score = score;
    }
}
