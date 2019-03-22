package DC2;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


import static org.junit.Assert.*;

@SuppressWarnings("ThrowablePrintedToSystemOut")
public class DC2CpuAgentTest {

    Float max;
    Long duration;
    Long timeInterval;
    Float occupation;
    String id;
    String tag;

    private DC2CpuAgent ca;
    private DC2ComputingTask task;

    // Setting Values for test
    @Before
    public void before(){
        max = 100.0f;
        duration = 1000l;
        occupation = 10.0f;
        id = "1b";
        tag = "1a";
        timeInterval = 1l;
    }


    @Test
    public void getMaxWorkload_validMaxWorkLoad_passed(){
        ca = new DC2CpuAgent(tag, max, timeInterval);

        System.out.println("Max Workload");
        System.out.println(ca.getMaxWorkLoad());
        System.out.println("Workload");
        System.out.println(ca.getWorkload());

        assertEquals(String.valueOf(ca.getMaxWorkLoad()), String.valueOf(max));
    }

    @Test
    public void getWorkload_validWorkLoad_passed(){
        //assertTrue(ca.getWorkload() instanceof Float);
        ca = new DC2CpuAgent(tag, max, timeInterval);
        assertTrue(ca.getWorkload() >= 0.0f);
    }

    @Test
    public void shutDown_CpuStateOn_CpuStateOff(){
        ca = new DC2CpuAgent(tag, max, timeInterval);
        ca.shutDown();
        ca.tick();
        assertEquals(ca.getCpuState(), CpuState.OFF);
    }
////////////////////////// Finished check at here.
    @Test
    public void getCpuStateOff() {
        ca = new DC2CpuAgent(tag, max, timeInterval);
        ca.shutDown();
        try{
            wait(10000);
        } catch(Exception e){
            System.out.println(e);
        }
        assertEquals(ca.getCpuState(),CpuState.OFF);
    }
    @Test
    public void getCpuStateOn_CpuStateOn_pass(){
        ca.powerOn();
        assertEquals(ca.getCpuState(), CpuState.ON);
    }

    @Test
    public void setCpuState() {
        ca.setCpuState(CpuState.ON);
        try{
            wait(10000);
        } catch(Exception e){
            System.out.print(e);
        }

        assertEquals(ca.getCpuState(),CpuState.ON);
    }

    @Ignore("Test not yet implemented")
    public void assign() {

    }

    @Test
    public void shutDown() {
        ca.shutDown();

        try{
            wait(10000);
        } catch(Exception e){
            System.out.print(e);
        }

        assertEquals(ca.getCpuState(), CpuState.OFF);
    }

    @Test
    public void powerOn() {
        ca.powerOn();

        try{
            wait(10000);
        } catch(Exception e){
            System.out.print(e);
        }

        assertEquals(ca.getCpuState(), CpuState.ON);
    }

    @Test
    public void mainTask() {
    }
}