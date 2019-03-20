package DC2;

import java.util.ArrayList;

public class DC2Database extends DC2Facility{
    private DC2MonitoringService ms;
    private ArrayList<DC2CpuMatrix> cpuRankingList;

    public ArrayList<DC2CpuMatrix> getCpuRecordingList() {
        return cpuRecordingList;
    }

    private ArrayList<DC2CpuMatrix> cpuRecordingList;
    public ArrayList<DC2CpuMatrix> getTopRankingList(Integer n){
        if(n < cpuRankingList.size()){
            return new ArrayList<DC2CpuMatrix>(cpuRankingList.subList(0, n - 1));
        }else{
            return cpuRankingList;
        }
    }

    public DC2Database(DC2MonitoringService ms){
        this.ms = ms;
    }

    private void rankCpuList(){
        cpuRankingList.sort((o1, o2) -> o1.score < o2.score ? 0 : 1);
    }

    @Override
    void mainTask() {
        rankCpuList();
    }
}
