package DC2;

import java.util.ArrayList;

public class DC2MonitoringService {
    private ArrayList<DC2CpuAgent> agentList;
    private ArrayList<DC2CpuMatrix> matrixList;

    public DC2MonitoringService(ArrayList<DC2CpuAgent> agentList){
        this.agentList = agentList;
    }
    public void updateCpuMatrix() {
        matrixList.clear();
        for(DC2CpuAgent agent: agentList){
            DC2CpuMatrix matrix = new DC2CpuMatrix(agent);
            matrix.workload = agent.getWorkload();
            matrixList.add(matrix);
        }
    }

    public ArrayList<DC2CpuMatrix> getCpuMatrix(){
        return new ArrayList<>(matrixList);
    }
}
