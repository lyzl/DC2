package DC2;

import org.junit.Ignore;
import org.junit.Test;


import static DC2.DC2CpuState.*;
import static org.junit.Assert.*;

public class DC2CpuAgentTest {

    // Setting Values for test
    private String tag = "1a";
    private float max = 100.0f;
    private long interval = 10;
    private DC2CpuAgent ca = new DC2CpuAgent(tag, max, interval);

    private long duration = 1000;
    private float occupation = 10.0f;
    private String id = "1a";
    private DC2ComputingTask task = new DC2ComputingTask(duration, occupation, id);

    @Test
    public void getWorkload(){
        assertEquals(String.valueOf(max),String.valueOf(ca.getWorkload()));
    }

    @Test
    public void getCpuStateShutting(){
        ca.shutDown();
        assertEquals(SHUTTING, ca.getCpuState());
    }

    @Ignore
    public void getCpuStateOff() {
        ca.shutDown();
        forwardTick(10);
        ca.mainTask();
        assertEquals(OFF, ca.getCpuState());
    }

    @Test
    public void getCpuStateOn(){
        ca.powerOn();
        assertEquals(ON, ca.getCpuState());
    }

    @Test
    public void setCpuState() {
        ca.setCpuState(ON);
        assertEquals(ca.getCpuState(), ON);
    }

    @Test
    public void assign() {
        int originalValue = ca.getQueueSize();
        ca.assign(task);
        assertEquals(originalValue+1, ca.getQueueSize());
    }

    @Test
    public void assign_task_taskFinished(){
        DC2CpuAgent agent = new DC2CpuAgent("agent1", 100.0f, 1l);
        agent.assign(new DC2ComputingTask(1l,10.0f,"id2"));
        agent.powerOn();
        agent.tick();
        agent.tick();
        assertTrue(agent.getQueueSize() == 0);
    }

    @Test
    public void shutDown() {
        ca.shutDown();
        forwardTick(10);
        assertEquals(ca.getCpuState(), SHUTTING);
    }

    @Test
    public void powerOn() {
        ca.powerOn();
        assertEquals(ca.getCpuState(), ON);
    }

    @Test
    public void workloadBoundaryTest(){
        assertTrue(ca.getWorkload() <= 100.0f);
        assertTrue(ca.getWorkload() > 0.0f);

    }

    private void forwardTick(int t){
        for(int i = 0; i < t; i++){
            ca.tick();
        }
    }
}