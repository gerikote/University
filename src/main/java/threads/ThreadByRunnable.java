package threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadByRunnable implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger(ThreadByRunnable.class);

    @Override
    public void run() {
        LOGGER.info("Thread was created by implementing Runnable : " + Thread.currentThread().threadId());
    }
}
