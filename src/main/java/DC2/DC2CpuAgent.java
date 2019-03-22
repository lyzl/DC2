package DC2;

import java.util.LinkedList;
import java.util.Queue;

enum DC2CpuState {
    ON, OFF, SHUTTING
}
public class DC2CpuAgent extends DC2Facility{
    private Float workload;

    public Float getMaxWorkload() {
        return maxWorkload;
    }

    private Float maxWorkload;
    private DC2CpuState cpuState;
    private Queue<Long> finishedTimeQueue = new LinkedList<>();

    public int getQueueSize(){
        return finishedTimeQueue.size();
    }

    public Float getWorkload() {
        return workload;
    }
    public DC2CpuState getCpuState() {
        return cpuState;
    }
    public void setCpuState(DC2CpuState cpuState) {
        this.cpuState = cpuState;
    }

    public DC2CpuAgent(String tag, float maxWorkLoad, long interval){
        super(interval);
        workload = maxWorkLoad;
    }

    public void assign(DC2ComputingTask task){
        workload += task.getOccupation();
        finishedTimeQueue.add(task.getDuration() + tickCount);
    }

    public void shutDown(){
        this.cpuState = DC2CpuState.SHUTTING;
    }

    public void powerOn(){
        this.cpuState = DC2CpuState.ON;
    }

    @Override
    void mainTask() {
        if(this.cpuState == DC2CpuState.ON){
            while (finishedTimeQueue.peek() < tickCount){
                finishedTimeQueue.poll();
            }
            if(finishedTimeQueue.size() == 0 &&  this.cpuState == DC2CpuState.SHUTTING){
                this.cpuState = DC2CpuState.OFF;
            }
        }
    }
}
