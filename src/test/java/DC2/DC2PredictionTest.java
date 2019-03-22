package DC2;

//import DC2.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;

import static org.junit.Assert.*;

public class DC2PredictionTest {
    private DC2Prediction prediction;
    private DC2Database database;
    Queue<Float> occupationHistoryQueue = new LinkedList<Float>();
    DC2CpuAgent dc2CpuAgent = new DC2CpuAgent("1023",90,30l);
    DC2CpuRecordingMatrix dcasa = new DC2CpuRecordingMatrix(dc2CpuAgent);
    ArrayList<DC2CpuRecordingMatrix> recordingList = new ArrayList<>();
    DC2Prediction dc2Prediction = new DC2Prediction(10l);
    boolean thrown;
    @Before
    public void before()
    {
        occupationHistoryQueue.add(0.0f);
        recordingList.add(dcasa);
        thrown = false;
    }
    @Test
    public  void checkTotalOccupation(){
        occupationHistoryQueue.add(0.0f);
        try{  dc2Prediction.predict(occupationHistoryQueue,recordingList);
        }catch (IllegalArgumentException e){
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void checkTotalOccupation1(){
        occupationHistoryQueue.add(101.0f);
        try{
            dc2Prediction.predict(occupationHistoryQueue,recordingList);
        }catch (IllegalArgumentException e){
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void checkpuCount(){
        occupationHistoryQueue.add(-2.0f);
        try{  dc2Prediction.predict(occupationHistoryQueue,recordingList);
        }catch (IllegalArgumentException e){
            thrown = true;
        }
        assertTrue(thrown);
    }
}