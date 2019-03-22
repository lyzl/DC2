package DC2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DC2CpuSelection extends DC2Facility {
    private Queue<DC2ComputingTask> taskQueue;
    private DC2Database database;

    DC2CpuSelection(DC2Database database, Long timeInterval) {
        super(timeInterval);
        this.database = database;
        taskQueue = new LinkedList<>();
    }

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

    public void monitorTaskQueue(ArrayList<DC2CpuMatrix> RankingList, int size){
        ArrayList<DC2CpuMatrix> cpuRankingList = RankingList;
        for(DC2CpuMatrix cpuMatrix: cpuRankingList){
            if(size > 0){
                assignTask(null,null);
            }else{
                break;
            }
        }

    }
    private void assignTask(DC2CpuAgent agent, DC2ComputingTask task){
        agent.assign(task);
    }

    public void receiveTask(DC2ComputingTask task){
        if(task.duration <= 0l){
            throw new IllegalArgumentException("Invalid Duration value");
        }
        else if (task.occupation <= 0.0f || task.occupation > 100.0f){
            throw  new IllegalArgumentException("Invalid occupation value");
        }
        else{
            taskQueue.add(task);
            System.out.println("Task has been added to the Queue");
        }
    }

    public  void monitorTaskQueue(DC2ComputingTask task){
        taskQueue.add(task);
        if(taskQueue.size() > 0){
            System.out.println("Assigning task to CPU");
        }else{
            System.out.println("Task cannot be assigned");
        }
    }

}
