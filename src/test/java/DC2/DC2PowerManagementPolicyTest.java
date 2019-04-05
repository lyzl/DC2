package DC2;
import org.junit.Test;


public class DC2PowerManagementPolicyTest {
    @Test
    public void optimalCpuTest() {
        int i=1;
        DC2PowerManagementPolicy pmc = new DC2PowerManagementPolicy();
        pmc.checkOptimalCPUnumber(i);

    }
    @Test
    public void checkNegativeCpuTest() {
        int i=-1;
        DC2PowerManagementPolicy pmc = new DC2PowerManagementPolicy();
        pmc.checkOptimalCPUnumber(i);

    }
}