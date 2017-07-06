import by.cs.cpu.Cpu;
import by.cs.cpu.CpuConnection;
import by.cs.cpu.CpuS7;
import by.cs.cpu.CpuS7Connection;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Dmitriy V.Yefremov
 */
public class CpuConnectionTest {

    @Test
    public void test() {

        Cpu cpu = new CpuS7(0, 2, "127.0.0.1");
        CpuConnection<Cpu> connection = new CpuS7Connection(cpu);
        connection.connect();
        Assert.assertTrue(connection.isConnected());

        connection.disconnect();

    }
}
