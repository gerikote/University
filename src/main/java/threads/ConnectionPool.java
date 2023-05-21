package threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private BlockingQueue<Connection> connections;
    private int poolSize;

    private ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        connections = new ArrayBlockingQueue<>(poolSize);
        initializeConnections();
    }

    public static ConnectionPool getInstance(int poolSize) {
        return ConnectionPoolHolder.INSTANCE;
    }

    public Connection getConnection() throws InterruptedException {
        return connections.take();
    }

    public void releaseConnection(Connection connection) {
        connections.offer(connection);
    }

    private void initializeConnections() {
        for (int i = 0; i < poolSize; i++) {
            Connection connection = new Connection();
            connections.offer(connection);
        }
    }

    private static class ConnectionPoolHolder {
        private static final ConnectionPool INSTANCE = new ConnectionPool(5);
    }
}


