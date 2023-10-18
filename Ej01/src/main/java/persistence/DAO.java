package persistence;
import java.sql.*;

public abstract class DAO {
    protected Connection connection = null;
    protected ResultSet result = null;
    protected Statement sentence = null;

    protected void connectDataBase() throws SQLException {
        String User = "root";
        String Password = "root";
        String Database = "tienda";

        try{
            String urlDataBase = "jdbc:mysql://localhost:3306/" + Database + "?useSSL=false";
            connection = DriverManager.getConnection(urlDataBase, User, Password);
        }
        catch(SQLException ex){
            throw ex;
        }
    }

    protected void disconnectDataBase() throws SQLException {
        try{
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        }
        catch(Exception e){
            throw e;
        }
    }

    protected void executeCommands(String sql) throws SQLException {
        System.out.println(sql);
        try{
            connectDataBase();
            sentence = connection.createStatement();
            sentence.executeUpdate(sql);
        }
        catch(Exception e){
            connection.rollback();
            throw e;
        }
        finally{
            disconnectDataBase();
        }
    }

    protected void executeQueries(String sql) throws SQLException {
        System.out.println(sql);
        try{
            connectDataBase();
            sentence = connection.createStatement();
            result = sentence.executeQuery(sql);
        }
        catch(Exception e){
            throw e;
        }
        finally{
            disconnectDataBase();
        }
    }



}