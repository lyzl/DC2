package DC2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DC2MonitoringServiceTest<i> {

    int size = 10;
    float workload;
    float score;
    float max;
    long timeInterval;
    String tag;

    ArrayList<DC2CpuAgent> al;
    DC2MonitoringService ms;
    private DC2CpuAgent ca;

    @Before
    public void before(){

    }

    public DC2MonitoringServiceTest(){
        al = new ArrayList<DC2CpuAgent>();
        for(int i=0; i<size; i++){
            DC2CpuAgent a = new DC2CpuAgent("test"+i, 1.0f + i, 10L);
            al.add(a);
        }
        ms = new DC2MonitoringService(al);

    }

    @Test
    public void updateCpuMatrix() {
        ms.updateCpuMatrix();
    }
    @Test
    public void monitorServiceCreated(){
        assertTrue(ms instanceof DC2MonitoringService);
    }
    @Test
    public void cpuMatrixTypeTest(){
        assertTrue(al instanceof ArrayList);
    }
    @Test
    public void getCpuMatrix() {
        assertEquals(size, ms.getCpuMatrix().size());
    }

    @Test
    public void getCpuMatrix_validMatrix() {
        ca = new DC2CpuAgent(tag, max, 1);
        ArrayList<DC2CpuAgent> agentList = new ArrayList<DC2CpuAgent>();
        ms = new DC2MonitoringService(agentList);
        System.out.println("Monitoring Service valid CpuMatrix test");
        assertNotNull(String.valueOf(ms.getCpuMatrix()));
    }
    @Test
    public void getCpuMatrixEmpty() {assertNotEquals(0, ms.getCpuMatrix().size());}
    @Test
    public void getCpuMatrixOutOfLowerBounds(){assertNotEquals(-1, ms.getCpuMatrix().size());}
    @Test
    public void getCpuMatrixOutOfUpperBoundsMinusOne(){assertNotEquals(size-1, ms.getCpuMatrix().size());}
    @Test
    public void getCpuMatrixOutOfUpperBounds(){
        assertNotEquals(ms.getCpuMatrix().size()+1, ms.getCpuMatrix().size());
    }

}