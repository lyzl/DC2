package DC2;

import java.util.ArrayList;
import java.lang.Math.*;
import java.util.Queue;

public class DC2Prediction extends DC2Facility{
    private Float totalCpuOccupation;
    private Float optimalRate = 0.6f;
    public boolean valtotalCpuOccupation = false;
    public boolean valrecordingList = false;

    private DC2Database database;
    private DC2PowerManagementPolicy PMP;


    public Float getTotalCpuOccupation() {
        return totalCpuOccupation;
    }
    public Float getOptimalRate() {
        return optimalRate;
    }



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
    public void predict(Queue<Float> occupationHistoryQueue, ArrayList<DC2CpuRecordingMatrix> recordingList){
        Float totalCpuOccupation = 0.0f;
        for(DC2CpuRecordingMatrix recording: recordingList){
            Float totalOccupationPerCpu = 0.0f;
            for(Float occupation: occupationHistoryQueue){
                totalOccupationPerCpu += occupation;
            }
            if(totalOccupationPerCpu <= 0.0f || totalOccupationPerCpu >= 100.0f){
                valtotalCpuOccupation = false;
                throw new IllegalArgumentException("Invalid value of occupation");
            }
            totalCpuOccupation += totalOccupationPerCpu / occupationHistoryQueue.size();
        }
        Long cpuCount = Math.round(Math.floor(totalCpuOccupation / optimalRate));
        if(cpuCount <= 0.0f){
            throw new IllegalArgumentException("Invalid value of cpuCount");
        }
        // PMP.optimalCpuNum = cpuCount.intValue();
    }

    @Override
    void mainTask() {
        predict();
    }
}
