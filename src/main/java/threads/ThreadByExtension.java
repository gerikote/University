package threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadByExtension extends Thread {
    private static final Logger LOGGER = LogManager.getLogger(ThreadByExtension.class);

    public void run() {
        LOGGER.info("Thread created by extending Thread class : " + Thread.currentThread().threadId());
    }
}
