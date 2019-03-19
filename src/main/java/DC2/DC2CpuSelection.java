package DC2;

import java.util.ArrayList;
import java.util.Queue;

public class DC2CpuSelection extends DC2Facility {
    private Queue<DC2ComputingTask> taskQueue;
    private DC2Database database;

    @Override
    void mainTask() {

    }
    private void monitorTaskQueue(){
        ArrayList<DC2CpuMatrix> cpuRankingList = database.getTopRankingList(taskQueue.size());

    }
}
