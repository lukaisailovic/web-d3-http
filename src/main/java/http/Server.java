package http;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final Router router;

    public Server(){
        this.router = new Router();
    }

    public void start(int port) {

        try {
            System.out.println("Server accepting connections on port "+ port);
            ServerSocket ss = new ServerSocket(port);
            while (true) {
                Socket sock = ss.accept();
                new Thread(new ServerThread(sock, router)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Router getRouter() {
        return router;
    }
}
