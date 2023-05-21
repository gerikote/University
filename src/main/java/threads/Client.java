package threads;

public class Client {
    public static void connect() {
        ConnectionPool connectionPool = ConnectionPool.getInstance(5);

        // Create and start multiple threads to simulate clients
        for (int i = 0; i < 7; i++) {
            Thread thread = new Thread(() -> {
                try {
                    // Obtain a connection from the connection pool
                    Connection connection = connectionPool.getConnection();
                    System.out.println("Thread " + Thread.currentThread().getName() +
                            " obtained a connection");

                    // Simulate performing some actions with the connection
                    Thread.sleep(2000);

                    // Release the connection back to the connection pool
                    connectionPool.releaseConnection(connection);
                    System.out.println("Thread " + Thread.currentThread().getName() +
                            " released the connection");
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            });
            thread.start();
        }
    }
}

