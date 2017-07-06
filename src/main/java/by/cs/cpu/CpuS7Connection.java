package by.cs.cpu;

import by.cs.cpu.s7.S7Client;

/**
 * @author Dmitriy V.Yefremov
 */
public class CpuS7Connection implements CpuConnection<Cpu> {

    private Cpu cpu;
    private S7Client s7Client;

    public CpuS7Connection() {
       this(new CpuS7(0, 2, "127.0.0.1"));
    }

    public CpuS7Connection(Cpu cpu) {
        this.cpu = cpu;
        s7Client = new S7Client(cpu);
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(CpuS7 cpu) {
        this.cpu = cpu;
    }

    @Override
    public void connect() {
        s7Client.connect();
    }

    @Override
    public void connect(Cpu cpu) {
        this.cpu = cpu;
        s7Client.setCpu(cpu);
        connect();
    }

    @Override
    public void disconnect() {
        s7Client.disconnect();
    }

    @Override
    public boolean isConnected() {
        return s7Client.isConnected();
    }

    @Override
    public Cpu getCurrentCpu() {
        return cpu;
    }

    @Override
    public Object getInfo() {
        return s7Client.getCpInfo();
    }

    @Override
    public void writeData(Data data) {

    }

    @Override
    public Data getData() {
        return null;
    }
}
