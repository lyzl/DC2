package DC2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DC2DatabaseTest {
    DC2CpuMatrix[] cm=new DC2CpuMatrix[5];
    ArrayList<DC2CpuMatrix> RankingList= new ArrayList<DC2CpuMatrix>();
    String oRankingList;
    @Before
    public void before()
    {
        for(int i=0;i<5;i++) {
            cm[i] =new DC2CpuMatrix(null);
            cm[i].workload=0F;
        }
        cm[0].score=23F;
        cm[1].score=43F;
        cm[2].score=13F;
        cm[3].score=3F;
        cm[4].score=33F;
    }
    @Test
    public void rankCpuList_cpuRankingList_ListSorted() {
        System.out.println("TEST 1\nInput  Test Parameters --> \n cpuRankingList:23F 43F 13F 3F 33F\n");
        DC2Database db= new DC2Database(null, 5l);
        oRankingList=db.rankCpuList(RankingList);
        assertEquals("CPU Rank list sorted",oRankingList);
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTopRankingList_nonePositiveValue_raiseException(){
        DC2Database db = new DC2Database(null, 3l);
        db.getTopRankingList(-1);
    }
}