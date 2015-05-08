import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Anton_Shkliarov on 5/7/2015.
 */
public class CreatingDB {
    private final static String createDBQ = "CREATE DATABASE bookstore CHARACTER SET utf8 COLLATE utf8_general_ci";
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {
            //��������� �������
            Class.forName("com.mysql.jdbc.Driver");
            //����� ������� ����������� � ��. � MySQL ����������� ���� ��������� ����,
            //� ��� � ����� ��������� ����������.
            String url = "jdbc:mysql://localhost/mysql";
            //�� ��������� ������������ - root, ������ - � ��� ���!
            connection = DriverManager.getConnection(url, "root", "");
            statement = connection.createStatement();
            //�������� ��������, ��� ������� ���� � ������� executeUpdate(). �� ���� �� ��������� ������� �����.
            statement.executeUpdate(createDBQ);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //����������� ������ ���
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


