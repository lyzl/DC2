package DC2;
enum CpuState{
    ON, OFF, SHUTTING
}
public class DC2CpuAgent extends DC2Facility{
    private Float workload;

    public Float getWorkload() {
        return workload;
    }

    private Float maxWorkLoad;

    public CpuState getCpuState() {
        return cpuState;
    }

    public void setCpuState(CpuState cpuState) {
        this.cpuState = cpuState;
    }

    private CpuState cpuState;

    public DC2CpuAgent(String tag, float maxWorkLoad){}

    public void assign(DC2ComputingTask task){
        workload += task.getOccupation();
    }

    public void shutDown(){
        this.cpuState = CpuState.SHUTTING;
    }

    @Override
    void mainTask() {

    }
}
