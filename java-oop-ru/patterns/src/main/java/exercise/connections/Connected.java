package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection{

    TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error. The connection is already installed");
    }

    @Override
    public void disconnect() {
        this.tcpConnection.setConnection(new Disconnected(this.tcpConnection));
    }

    @Override
    public void write(String string) {
        this.tcpConnection.setData(string);
    }
}
// END
