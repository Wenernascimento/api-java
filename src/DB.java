import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    static {
        try {
            // Registrar explicitamente o driver
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver SQLite não encontrado", e);
        }
    }

    public static Connection connection() throws Exception {
        // Corrigir a URL (remover espaços)
        String url = "jdbc:sqlite:users.db";
        return DriverManager.getConnection(url);
    }
}