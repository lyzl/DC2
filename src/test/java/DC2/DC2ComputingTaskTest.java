package DC2;

import org.junit.Test;

import static org.junit.Assert.*;

public class DC2ComputingTaskTest {

    @Test
    public void checkId_Id_IdCannotBeLessThanZero() {
        DC2ComputingTask ct= new DC2ComputingTask(89L,10.0f,"-1");
        System.out.println("TEST 1  \nInput  Test Parameters --> \n Duration:89L \n Occupation:10.0F \n Id: -1");
        assertEquals("Error: Task Id cannot be less than 0",ct.checkId("-1"));
        System.out.println("\n *******End of Test******\n\n");
    }
}