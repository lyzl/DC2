package DC2;

import org.junit.Test;

import static org.junit.Assert.*;

public class DC2PredictionTest {

    DC2Prediction prediction = new DC2Prediction(10L);

    int cpuOccupation = 100;

    float optimalRate = 0.6f;

    @Test
    public void optimalRateTest(){
        assertEquals(optimalRate, prediction.getOptimalRate(), 0.0002);
    }

    @Test
    public void totalCPUOccupationTest(){

        prediction.mainTask();
        assertTrue(prediction.getTotalCpuOccupation() <= optimalRate);
        assertTrue(prediction.getTotalCpuOccupation() >= 0);
    }

}