package DC2;

import java.util.ArrayList;
import java.util.Queue;

public class DC2CpuSelection extends DC2Facility {
    private Queue<DC2ComputingTask> taskQueue;
    private DC2Database database;

    @Override
    void mainTask() {
        monitorTaskQueue();
    }
    private void monitorTaskQueue(){
        ArrayList<DC2CpuMatrix> cpuRankingList = database.getTopRankingList(taskQueue.size());
        for(DC2CpuMatrix cpuMatrix: cpuRankingList){
            if(taskQueue.size() > 0){
                assignTask(cpuMatrix.agent, taskQueue.poll());
            }else{
                break;
            }
        }

    }

    private void assignTask(DC2CpuAgent agent, DC2ComputingTask task){
        agent.assign(task);
    }

    public void receiveTask(DC2ComputingTask task){
        taskQueue.add(task);
    }
}
