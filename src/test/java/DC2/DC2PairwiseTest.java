package DC2;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

public class DC2PairwiseTest {
    ArrayList<DC2CpuAgent> agentList;

    @Test
    public void balancePower_Pair1() {
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        String value = "ON";
        String state = "ON";
        agentList = new ArrayList<>();
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 1 \n Defined-ON-Defined-ON \nInput  Test Parameters --> \n CPUAgentList \n Value: ON \n  PMP-Optimal\n state: ON \n");
        pc.balancePower(agentList, value, pmp,state);
        assertFalse(pc.setValue);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair2() {
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 2 ;
        String value = "OFF";
        String state = "OFF";
        agentList = new ArrayList<>();
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 2\n Defined-OFF-Initialised-OFF   \nInput  Test Parameters --> \n CPUAgentList \n Value: OFF \n  PMP-Optimal:1\nState: OFF \n");
        pc.balancePower(agentList, value, pmp,state);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair3() {
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        String value = "SHUTTING";
        String state = "SHUTTING";
        agentList = new ArrayList<>();
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 3\n Defined-SHUTTING-Undefined-SHUTTING  \nInput  Test Parameters --> \n CPUAgentList \n Value: SHUTTING \n  PMP-Optimal \nState: SHUTTING \n");
        pc.balancePower(agentList, value, pmp,state);
        assertFalse(pc.setValue);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair4 () {
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        String value = "ABCD";
        String state = "XYZ";
        agentList = new ArrayList<>();
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 4 \n Defined-Other---Other   \nInput  Test Parameters --> \n CPUAgentList \n Value: XYZ \n State: XYZ \n");
        pc.balancePower(agentList, value, pmp,state);
        assertFalse(pc.setValue);
        System.out.println("\n *******End of Test******\n\n");
    }


    @Test
    public void balancePower_Pair5 () {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        String value = "OFF";
        String state = "ABCD";
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 5\n Initialised-OFF-UnDefined-Other  \nInput  Test Parameters --> \n CPUAgentList \n Value: OFF \n  PMP-Optimal\n State: ABCD \n");
        pc.balancePower(agentList, value, pmp,state);
        assertFalse(pc.setValue);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair6 () {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        String value = "SHUTTING";
        String state = "ON";
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 6\n Initialised-SHUTTING---ON  \nInput  Test Parameters --> \n CPUAgentList \n Value: SHUTTING \n State: ON \n");
        pc.balancePower(agentList, value, pmp,state);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair7 () {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        String value = "ABCD";
        String state = "OFF";
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 7\n Initialised-OTHER-Defined-OFF   \nInput  Test Parameters --> \n CPUAgentList \n Value: ABCD \n  PMP-Optimal\nState:OFF \n");
        pc.balancePower(agentList, value, pmp,state);
        assertFalse(pc.setValue);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair8 () {
        DC2CpuAgent element1 = new DC2CpuAgent("10233", 70, 1l);
        DC2CpuAgent element2 = new DC2CpuAgent("10243", 40, 1l);
        DC2CpuAgent element3 = new DC2CpuAgent("10245", 40, 1l);
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 2 ;
        String value = "ON";
        String state = "SHUTTING";
        agentList = new ArrayList<>();
        agentList.add(element1);
        agentList.add(element2);
        agentList.add(element3);
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 8\n Initialised-ON-Initialised-Shutting  \nInput  Test Parameters --> \n CPUAgentList \n Value: ON \n PMP-Optimal:1\n State: SHUTTING  \n");
        pc.balancePower(agentList, value, pmp,state);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair9 () {
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        String value = "SHUTTING";
        String state = "SHUTTING";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 9\n Undefined-Shutting-Defined-Shutting  \nInput  Test Parameters --> \n CPUAgentList \n Value: SHUTTING \n PMP-Optimal:1\n State: SHUTTING \n");
        pc.balancePower(agentList, value, pmp,state);
        assertFalse(pc.setValue);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair10 () {
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 2 ;
        String value = "ABCD";
        String state = "XYZ";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 10\n Undefined-Other-Initialised-Other  \nInput  Test Parameters --> \n CPUAgentList \n Value: ABCD \n  PMP-Optimal:1\n State: XYZ \n");
        pc.balancePower(agentList, value, pmp,state);
        assertFalse(pc.setValue);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair11 () {
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        String value = "ON";
        String state = "ON";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 11 \n UnDefined-ON-Undefined-ON  \nInput  Test Parameters --> \n CPUAgentList \n Value: ON \n  PMP-Optimal\n State: ON \n");
        pc.balancePower(agentList, value, pmp,state);
        assertFalse(pc.setValue);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair12 () {
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        String value = "OFF";
        String state = "OFF";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 12\n UnDefined-OFF---OFF   \nInput  Test Parameters --> \n CPUAgentList \n Value: OFF \n State: OFF \n");
        pc.balancePower(agentList, value, pmp,state);
        assertFalse(pc.setValue);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair13 () {
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        String state = "OFF";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 13\n ---Other-Undefined-OFF   \nInput  Test Parameters --> \n Value: ABCD \n State: OFF \n");
        pc.balancePower(agentList, "OFF", pmp,state);
        assertFalse(pc.setValue);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair14 () {
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        String value = "ON";
        String state = "SHUTTING";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 14\n ---ON---SHUTTING  \nInput  Test Parameters --> \n Value: ON \n State: SHUTTING \n");
        pc.balancePower(agentList, value, pmp,state);
        assertFalse(pc.setValue);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair15 () {
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        String value = "OFF";
        String state = "XYZ";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 15 \n ---OFF-Defined-Other  \nInput  Test Parameters --> \n Value: OFF \n PMP-Optimal:1 \n State: XYZ\n");
        pc.balancePower(agentList, value, pmp,state);
        assertFalse(pc.setValue);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void balancePower_Pair16 () {
        DC2PowerManagementPolicy pmp = new DC2PowerManagementPolicy();
        pmp.optimalCpuNum = 2 ;
        String value = "SHUTTING";
        String state = "ON";
        DC2PowerControl pc = new DC2PowerControl(null);
        System.out.println("TEST 16 \n ---SHUTTING-Initialsed-ON  \nInput  Test Parameters -->\n Value: SHUTTING\n PMP-Optimal:1\n Value: ON\n");
        pc.balancePower(agentList, value, pmp,state);
        System.out.println("\n *******End of Test******\n\n");
    }

}