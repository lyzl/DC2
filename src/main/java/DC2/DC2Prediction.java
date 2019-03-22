package DC2;

import java.util.ArrayList;
import java.lang.Math.*;

public class DC2Prediction extends DC2Facility{
    private DC2Database database;
    private DC2PowerManagementPolicy PMP;

    public Float getTotalCpuOccupation() {
        return totalCpuOccupation;
    }

    private Float totalCpuOccupation;
    private Float optimalRate = 0.6f;

    DC2Prediction(Long timeInterval) {
        super(timeInterval);
    }

    private void predict(){
        ArrayList<DC2CpuRecordingMatrix> recordingList =  database.getRecordingMatrixList();
        totalCpuOccupation= 0.0f;
        for(DC2CpuRecordingMatrix recording: recordingList){
            Float totalOccupationPerCpu = 0.0f;
            for(Float occupation: recording.occupationHistoryQueue){
                totalOccupationPerCpu += occupation;
            }
            totalCpuOccupation += totalOccupationPerCpu / recording.occupationHistoryQueue.size();
        }
        Long cpuCount = Math.round(Math.floor(totalCpuOccupation / optimalRate));
        PMP.optimalCpuNum = cpuCount.intValue();

    }


    public Float getOptimalRate() {
        return optimalRate;
    }

    @Override
    void mainTask() {
        predict();
    }
}
