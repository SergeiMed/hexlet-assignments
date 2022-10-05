package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {

    private TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        TcpConnection con = this.tcpConnection;
        con.setConnection(new Connected(con));
    }

    @Override
    public void disconnect() {
        System.out.println("Error. Connection already disconnect");
    }

    @Override
    public void write(String string) {
        System.out.println("Error. Connection disconnect");
    }
}
// END
