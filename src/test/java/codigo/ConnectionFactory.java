package codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection(String database) {


        String url = "jdbc:postgresql://11.22.202.51:5432/" + database;
        String usuario = "automacao";
        String senha = "tst@automacao";


        try {

            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url,usuario, senha);
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
        catch (Exception e) {
            System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
            return null;
        }
    }





}