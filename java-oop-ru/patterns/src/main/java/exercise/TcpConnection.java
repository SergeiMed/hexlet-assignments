package exercise;

import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class TcpConnection implements Connection{

    private Connection connection;
    private String ip;
    private Integer port;
    private List<String> data;

    public TcpConnection(String ip, Integer port) {
        this.connection = new Disconnected(this);
        this.ip = ip;
        this.port = port;
        this.data = new ArrayList<>();
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void setData(String string) {
        this.data.add(string);
    }

    @Override
    public String getCurrentState() {
        return connection.getCurrentState();
    }

    @Override
    public void connect() {
        connection.connect();
    }

    @Override
    public void disconnect() {
        connection.disconnect();
    }

    @Override
    public void write(String string) {
        connection.write(string);
    }
}
// END
