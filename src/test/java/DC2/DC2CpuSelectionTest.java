package DC2;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class DC2CpuSelectionTest {

    int size;
    DC2CpuMatrix[] cm=new DC2CpuMatrix[5];
    ArrayList<DC2CpuMatrix> RankingList= new ArrayList<DC2CpuMatrix>();
    Long duration=3L; Float occupation=5F; String id="1234";
    DC2ComputingTask ct=new DC2ComputingTask(duration,occupation,id);

    @Before
    public void before()
    {
        for(int i=0;i<5;i++) {
            cm[i] =new DC2CpuMatrix(null);
            cm[i].workload=0F;
        }
        cm[0].score=43F;
        cm[1].score=49F;
        cm[2].score=54F;
        cm[3].score=58F;
        cm[4].score=60F;
        for(int i=0;i<5;i++) {
            RankingList.add(cm[i]);
        }
    }

    @Test()
    public void receiveTask_Valid() {
        DC2ComputingTask task = new DC2ComputingTask(10l, 10.1f, "123");
        System.out.println("TEST 1 \nInput  Test Parameters --> \n Task-Duration:10 \n Task-Occupation:10.1 \n Task-id:10.1 \n");
        DC2CpuSelection d = new DC2CpuSelection(null, 5l);
        d.receiveTask(task);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void receiveTask_InvalidDuration() {

        DC2ComputingTask task = new DC2ComputingTask(0l, 10.1f, "123");
        boolean thrown = false;
        System.out.println("TEST 2  \nInput  Test Parameters --> \n Task-Duration:0 \n Task-Occupation:10.1 \n Task-id:10.1 \n");
        DC2CpuSelection d = new DC2CpuSelection(null, 5l);
        try {
            d.receiveTask(task);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
        System.out.println("\n *******End of Test******\n\n");
    }


    @Test
    public void receiveTask_InvalidOccupation() {

        DC2ComputingTask task = new DC2ComputingTask(10l, 0.0f, "123");
        boolean thrown = false;
        System.out.println("TEST 3  \nInput  Test Parameters --> \n Task-Duration:0 \n Task-Occupation:10.1 \n Task-id:10.1 \n");
        DC2CpuSelection d = new DC2CpuSelection(null, 5l);
        try {
            d.receiveTask(task);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
        System.out.println("\n *******End of Test******\n\n");
    }


    @Test
    public void receiveTask_InvalidOccupation1() {

        DC2ComputingTask task = new DC2ComputingTask(10l, 101.0f, "123");
        boolean thrown = false;
        System.out.println("TEST 4  \nInput  Test Parameters --> \n Task-Duration:0 \n Task-Occupation:10.1 \n Task-id:10.1 \n");
        DC2CpuSelection d = new DC2CpuSelection(null, 5l);
        try {
            d.receiveTask(task);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void monitorTaskQueue_Valid() {

        System.out.println("TEST 5 \nInput  Test Parameters --> \n Input Received from the Tests run prior to this test in the Test Suite \n");

        DC2ComputingTask task = new DC2ComputingTask(10l, 10.1f, "123");

        DC2CpuSelection dc2CpuSelection = new DC2CpuSelection(null, 5l);
        dc2CpuSelection.monitorTaskQueue(task);

        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void monitorTaskQueue_cpuRankingListTaskSize_passed1()
    {
        System.out.println("TEST 6  \nInput  Test Parameters --> \n Ranking List: 43F 49F 54F 58F 60F\n Size:-3 \n");
        DC2CpuSelection cs=new DC2CpuSelection(null, 5l);
        cs.monitorTaskQueue(RankingList,-3);
        System.out.println("\n *******End of Test******\n\n");
    }
    @Test
    public void monitorTaskQueue_cpuRankingListTaskSize_passed2()
    {
        System.out.println("TEST 7  \nInput  Test Parameters --> \n Ranking List: 43F 49F 54F 58F 60F\n Size:0 \n");
        DC2CpuSelection cs=new DC2CpuSelection(null, 5l);
        cs.monitorTaskQueue(RankingList,0);
        System.out.println("\n *******End of Test******\n\n");
    }
    @Test
    public void monitorTaskQueue_cpuRankingListTaskSize_passed3()
    {
        System.out.println("TEST 8  \nInput  Test Parameters --> \n Ranking List: 43F 49F 54F 58F 60F\n Size:-2 \n");
        DC2CpuSelection cs=new DC2CpuSelection(null, 5l);
        cs.monitorTaskQueue(RankingList,-2);
        System.out.println("\n *******End of Test******\n\n");
    }
    @Test
    public void monitorTaskQueue_cpuRankingListTaskSize_passed4()
    {
        System.out.println("TEST 9  \nInput  Test Parameters --> \n Ranking List: 43F 49F 54F 58F 60F\n Size:-1\n");
        DC2CpuSelection cs=new DC2CpuSelection(null, 5l);
        cs.monitorTaskQueue(RankingList,-1);
        System.out.println("\n *******End of Test******\n\n");
    }
    @Test (expected = NullPointerException.class)
    public void monitorTaskQueue_cpuRankingListTaskSize_passed5()
    {
        System.out.println("TEST 10  \nInput  Test Parameters --> \n Ranking List: 43F 49F 54F 58F 60F\n Size:1 \n");
        DC2CpuSelection cs=new DC2CpuSelection(null, 5l);
        cs.monitorTaskQueue(RankingList,1);
        System.out.println("\n *******End of Test******\n\n");
    }
    @Test (expected = NullPointerException.class)
    public void monitorTaskQueue_cpuRankingListTaskSize_passed6()
    {
        System.out.println("TEST 11  \nInput  Test Parameters --> \n Ranking List: 43F 49F 54F 58F 60F\n Size:2\n");
        DC2CpuSelection cs=new DC2CpuSelection(null, 5l);
        cs.monitorTaskQueue(RankingList,2);
        System.out.println("\n *******End of Test******\n\n");
    }
    @Test (expected = NullPointerException.class)
    public void monitorTaskQueue_cpuRankingListTaskSize_passed7()
    {
        System.out.println("TEST 12  \nInput  Test Parameters --> \n Ranking List: 43F 49F 54F 58F 60F\n Size:3 \n");
        DC2CpuSelection cs=new DC2CpuSelection(null, 5l);
        cs.monitorTaskQueue(RankingList,3);
        System.out.println("\n *******End of Test******\n\n");
    }  @Test(expected = NullPointerException.class)
    public void monitorTaskQueue_cpuRankingListTaskSize_passed8()
    {
        System.out.println("TEST 13  \nInput  Test Parameters --> \n Ranking List: 43F 49F 54F 58F 60F\n Size:4 \n");
        DC2CpuSelection cs=new DC2CpuSelection(null, 5l);
        cs.monitorTaskQueue(RankingList,4);
        System.out.println("\n *******End of Test******\n\n");
    }


}
