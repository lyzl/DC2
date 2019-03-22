package DC2;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

enum CpuState{
    ON, OFF, SHUTTING
}
public class DC2CpuAgent extends DC2Facility{
    private Float workload;
    private Float maxWorkLoad;

    private String tag;
    private CpuState cpuState;
    private Queue<Long> finishedTimeQueue = new LinkedList<>();

    public Float getWorkload() {
        return workload;
    }

    public Float getMaxWorkLoad() {
        return maxWorkLoad;
    }

    public CpuState getCpuState() {
        return cpuState;
    }

    public String getTag() {
        return tag;
    }

    public void setCpuState(CpuState cpuState) {
        this.cpuState = cpuState;
    }



    public DC2CpuAgent(String tag, float maxWorkLoad, Long timeInterval){
        super(timeInterval);
        this.tag = tag;
        this.maxWorkLoad = maxWorkLoad;
        this.workload = 0.0f;
    }

    public void assign(DC2ComputingTask task){
        workload += task.getOccupation();
        finishedTimeQueue.add(task.getDuration() + tickCount);
    }

    public void shutDown(){
        this.cpuState = CpuState.SHUTTING;
    }

    public void powerOn(){
        this.cpuState = CpuState.ON;
    }

    @Override
    void mainTask() {
        if(this.cpuState == CpuState.ON || this.cpuState == CpuState.SHUTTING){
            while (finishedTimeQueue.size() > 0 && finishedTimeQueue.peek() < tickCount){
                finishedTimeQueue.poll();
            }
            if(finishedTimeQueue.size() == 0 &&  this.cpuState == CpuState.SHUTTING){
                this.cpuState = CpuState.OFF;
            }
        }
    }
}
