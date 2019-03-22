package DC2;

import org.junit.Test;

import static org.junit.Assert.*;

public class DC2CpuMatrixTest {


    @Test
    public void checkScore_ValidScore() {
        DC2CpuMatrix cm= new DC2CpuMatrix(30F,null);
        System.out.println("TEST 1  \nInput  Test Parameters --> \n Score:30F \n Agent:null \n");
        assertEquals("Valid score",cm.checkScore());
        cm.checkScore();
        System.out.println("\n *******End of Test******\n\n");
    }

    @Test
    public void checkScore_ScoreLessThanZero() {
        DC2CpuMatrix cm= new DC2CpuMatrix(-2F,null);
        System.out.println("TEST 2  \nInput  Test Parameters --> \n Score:-2F \n Agent:null \n");
        assertEquals("Score cannot be less than zero",cm.checkScore());
        System.out.println("\n *******End of Test******\n\n");
    }
    @Test
    public void checkScore_ScoreGreaterThanHundred() {
        DC2CpuMatrix cm= new DC2CpuMatrix(1000F,null);
        System.out.println("TEST 3  \nInput  Test Parameters --> \n Score:1000F \n Agent:null \n");
        assertEquals("Score cannot be greater than 50",cm.checkScore());
        System.out.println("\n *******End of Test******\n\n");
    }
}