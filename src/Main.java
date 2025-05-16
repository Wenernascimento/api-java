import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        UserDAO.init(); // Cria a tabela se não existir

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/users", new UserHandler());
        server.setExecutor(null); // Configura um executor padrão
        server.start();

        System.out.println("Servidor rodando em http://localhost:8000");

        // Adiciona hook para desligar o servidor graciosamente
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nDesligando servidor...");
            server.stop(0);
        }));
    }
}