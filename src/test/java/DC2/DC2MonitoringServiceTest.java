package DC2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DC2MonitoringServiceTest<i> {

    ArrayList<DC2CpuAgent> al;
    DC2MonitoringService ms;
    int size = 10;

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
    public void monitorServiceCreated(){assertTrue(ms.equals(DC2MonitoringService.class));}
    @Test
    public void cpuMatrixTypeTest(){assertTrue(al.equals(ArrayList.class));}
    @Test
    public void getCpuMatrix() {
        assertEquals(size, ms.getCpuMatrix().size());
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