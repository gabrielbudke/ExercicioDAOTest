package dao;

import com.sun.javafx.fxml.BeanAdapter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gabriel Budke
 */
class Conexao {

    public static Connection conexao;

    static Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/cinema", "root", "");
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    static void desconectar() {
        if (conexao != null) {
            try {
                conexao.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
