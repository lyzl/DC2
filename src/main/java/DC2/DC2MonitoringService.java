package DC2;

import java.util.ArrayList;

public class DC2MonitoringService {
    private ArrayList<DC2CpuAgent> agentList;
    private ArrayList<DC2CpuMatrix> matrixList;

    public void updateCpuMatrix() {
        matrixList.clear();
        for(DC2CpuAgent agent: agentList){
            DC2CpuMatrix matrix = new DC2CpuMatrix(agent);
            matrix.workload = agent.getWorkload();
            matrixList.add(matrix);
        }
    }
}
