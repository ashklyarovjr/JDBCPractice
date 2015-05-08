package jdbc;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Anton_Shkliarov on 5/7/2015.
 */
public class SimpleJDBCRunner {
    public static void main(String[] args) throws SQLException {
        Connection connection = ConnectorDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from phonebook");

        ArrayList<Abonent> lst= new ArrayList<>();
        while(resultSet.next()){
            int id=resultSet.getInt(1);
            String name=resultSet.getString(2);
            int phone=resultSet.getInt(3);
            lst.add(new Abonent(id,phone,name));
        }
        if(lst.size()>0){
            System.out.println(lst);
        }else {
            System.out.println("Not found");
    }
    }
}
