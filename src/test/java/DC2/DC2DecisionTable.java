package DC2;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DC2DecisionTable {
    ArrayList<DC2CpuAgent> agentList;

    @Test
    public void balancePower_DecisionTable1() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 1;
        String value = "ON";
        String state = "ON";
        DC2PowerControl pc = new DC2PowerControl(agentList);
        pc.balancePower(agentList, value, pmp,state);
        assertEquals(pc.agentlistSize, agentList.size());
        assertEquals(pc.agentlistSize > pmp.optimalCpuNum,true);
        assertTrue(pc.r>0);
    }
    @Test
    public void balancePower_DecisionTable2() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 1;
        String value = "ON";
        String state = "OFF";
        DC2PowerControl pc = new DC2PowerControl(agentList);
        pc.balancePower(agentList, value, pmp,state);
        assertEquals(pc.agentlistSize, agentList.size());
    }
    @Test
    public void balancePower_DecisionTable3() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 3;
        String value = "ON";
        String state = "ON";
        DC2PowerControl pc = new DC2PowerControl(agentList);
        pc.balancePower(agentList, value, pmp,state);
        assertEquals(pc.agentlistSize, agentList.size());
        assertEquals(pc.agentlistSize < pmp.optimalCpuNum,true);
    }
    @Test
    public void balancePower_DecisionTable4() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 4;
        String value = "ON";
        String state = "OFF";
        DC2PowerControl pc = new DC2PowerControl(agentList);
        pc.balancePower(agentList, value, pmp,state);
        assertEquals(pc.agentlistSize, agentList.size());
    }

    @Test
    public void balancePower_DecisionTable5() {

        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = -1;
        boolean thrown = false;
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 2 \nInput  Test Parameters --> \n CPUAgentList \n PMP-Optimal:-1 \n");
        try {
            pc.balancePower(agentList, pmp);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        System.out.println("\n *******End of Test******\n\n");

    }
    @Test
    public void checkScore_DecisionTable6() {
        DC2CpuMatrix cm= new DC2CpuMatrix(30F,null);
        System.out.println("TEST 1  \nInput  Test Parameters --> \n Score:30F \n Agent:null \n");
        assertEquals("Valid score",cm.checkScore());
        cm.checkScore();
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void checkScore_DecisionTable7() {
        DC2CpuMatrix cm= new DC2CpuMatrix(-2F,null);
        System.out.println("TEST 2  \nInput  Test Parameters --> \n Score:-2F \n Agent:null \n");
        assertEquals("Score cannot be less than zero",cm.checkScore());
        System.out.println("\n *******End of Test******\n\n");
    }
    @Test
    public void checkScore_DecisionTable8() {
        DC2CpuMatrix cm= new DC2CpuMatrix(1000F,null);
        System.out.println("TEST 3  \nInput  Test Parameters --> \n Score:1000F \n Agent:null \n");
        assertEquals("Score cannot be greater than 50",cm.checkScore());
        System.out.println("\n *******End of Test******\n\n");
    }
}
