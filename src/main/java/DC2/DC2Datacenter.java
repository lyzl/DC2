package DC2;

import java.util.ArrayList;

public class DC2Datacenter {
    private DC2MonitoringService ms;
    private DC2Database db;
    private DC2CpuSelection cs;
    private DC2Prediction pd;
    private DC2PowerControl pc;
    private ArrayList<DC2CpuAgent> cpus;

    public void executeTask(DC2ComputingTask task){
        cs.receiveTask(task);
    }
}
