package DC2;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class DC2PowerControlTest {
    ArrayList<DC2CpuAgent> agentList;

    @Test
    public void balancePower_AddToList() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 1;
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 1 \nInput  Test Parameters --> \n CPUAgentList \n PMP-Optimal:1 \n");
        pc.balancePower(agentList, pmp);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_IndexOutOfBoundException() {

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
    public void balancePower_AddToOnline() {

        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerControl pc = new DC2PowerControl(null);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 2;
        System.out.println("TEST 3 \nInput  Test Parameters --> \n CPU-State:ON \n PMP-Optimal:2 \n");
        pc.balancePower("ON", pmp);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_AddToOffline() {

        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<DC2CpuAgent>();
        agentList.add(element1);
        agentList.add(element2);
        agentList = new ArrayList<>();
        DC2PowerControl pc = new DC2PowerControl(null);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 2;
        System.out.println("TEST 4 \nInput  Test Parameters --> \n CPU-State:ON \n PMP-Optimal:2 \n");
        pc.balancePower("OFF", pmp);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_CPUShutDown() {

        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerControl pc = new DC2PowerControl(null);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 4;
        System.out.println("TEST 5 \nInput  Test Parameters --> \n CPU-State:ON \n PMP-Optimal:2 \n");
        pc.balancePower("OFF", pmp);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_CPUPowerOn() {

        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerControl pc = new DC2PowerControl(null);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 4;
        System.out.println("TEST 6 \nInput  Test Parameters --> \n CPU-State:ON \n PMP-Optimal:2 \n");
        pc.balancePower("ON", pmp);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_ShutDown1() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40,1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 1;
        String value = "ON";
        String state = "ON";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 7 \nInput  Test Parameters --> \nCPUAgentList \nValue: ON \nPMP-Optimal:1 \n");
        pc.balancePower(agentList, value, pmp,state);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_PowerOn1() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 1;
        String value = "ON";
        String state = "OFF";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 8 \nInput  Test Parameters --> \nCPUAgentList \nValue: ON \nPMP-Optimal:1 \n");
        pc.balancePower(agentList, value, pmp,state);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_PowerOn2() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 3;
        String value = "ON";
        String state = "OFF";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 9 \nInput  Test Parameters --> \nCPUAgentList \nValue: ON \nPMP-Optimal:1 \n");
        pc.balancePower(agentList, value, pmp,state);
        System.out.println("\n *******End of Test******\n\n");
    }
    @Test
    public void balancePower_PowerOn4() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        DC2CpuAgent element3 = new DC2CpuAgent("10253", 30, 1l);
        DC2CpuAgent element4 = new DC2CpuAgent("10273", 10, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        agentList.add(element3);
        agentList.add(element4);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 1;
        String value = "ON";
        String state = "ON";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 10 \nInput  Test Parameters --> \nCPUAgentList \nValue: ON \nPMP-Optimal:1 \n");
        pc.balancePower(agentList, value, pmp,state);
        System.out.println("\n *******End of Test******\n\n");
    }
    @Test
    public void balancePower_ShutDown5() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 1;
        String value = "ON";
        String state = "ON";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 11 \nInput  Test Parameters --> \nCPUAgentList \nValue: ON \nPMP-Optimal:1 \n");
        pc.balancePower(agentList, value, pmp,state);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_PowerOn6() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 2;
        String value = "ON";
        String state = "OFF";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 12 \nInput  Test Parameters --> \n CPUAgentList \n Value: ON \nPMP-Optimal:1 \n");
        pc.balancePower(agentList, value, pmp,state);
        System.out.println("\n *******End of Test******\n\n");
    }
    @Test
    public void balancePower_PowerOn7() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 2;
        String value = "ON";
        String state = "OFF";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 13 \nInput  Test Parameters --> \n CPUAgentList \n Value: ON \n  PMP-Optimal:1 \n");
        pc.balancePower(agentList, value, pmp,state);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_PowerOn8() {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 2;
        String value = "ON";
        String state = "OFF";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 14 \nInput  Test Parameters --> \n CPUAgentList \n Value: ON \n  PMP-Optimal:1 \n");
        pc.balancePower(agentList, value, pmp,state);
        System.out.println("\n *******End of Test******\n\n");
    }
}


