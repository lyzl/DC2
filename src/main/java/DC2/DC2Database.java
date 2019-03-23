package DC2;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;

public class DC2Database extends DC2Facility{
    private DC2MonitoringService ms;
    private ArrayList<DC2CpuMatrix> cpuRankingList;
    private Map<DC2CpuAgent, Queue<Float>> cpuRecordingMap;

    public ArrayList<DC2CpuMatrix> getTopRankingList(Integer n){
        if(n <= 0){
            throw new IllegalArgumentException("require Cpu number must greater than 0");
        }
        if(n < cpuRankingList.size()){
            return new ArrayList<DC2CpuMatrix>(cpuRankingList.subList(0, n - 1));
        }else{
            return cpuRankingList;
        }
    }

    public ArrayList<DC2CpuRecordingMatrix> getRecordingMatrixList(){
        ArrayList<DC2CpuRecordingMatrix> recordingList = new ArrayList<>();
        for(DC2CpuAgent agent: cpuRecordingMap.keySet()){
            DC2CpuRecordingMatrix matrix = new DC2CpuRecordingMatrix(agent);
            matrix.occupationHistoryQueue = cpuRecordingMap.get(agent);
        }
        return recordingList;
    }

    public DC2Database(DC2MonitoringService ms, Long timeInterval){
        super(timeInterval);
        this.ms = ms;
    }

    private void rankCpuList(){
        cpuRankingList.sort((o1, o2) -> o1.score < o2.score ? 0 : 1);
    }

    private void recordCpuList(){

    }

    public String rankCpuList(ArrayList<DC2CpuMatrix> cpuRankingList){
        cpuRankingList.sort((o1, o2) -> o1.score < o2.score ? 0:1);
        return "CPU Rank list sorted";
    }

    @Override
    void mainTask() {

        rankCpuList();
        recordCpuList();
    }
}
