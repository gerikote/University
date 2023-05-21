package threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    private static final Logger LOGGER = LogManager.getLogger(Connection.class);
    private boolean isConnected;

    public Connection() {
        this.isConnected = false;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void connect(int threadId) {
        LOGGER.info("Thread " + threadId + " is connected");
        isConnected = true;
    }

    public void disconnect(int threadId) {
        LOGGER.info("Thread " + threadId + " is disconnected");
        isConnected = false;
    }
}
