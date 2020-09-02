package collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PropertiesExample2 {
    public static void main(String[] args) {
        Properties p = new Properties();
        try {
            FileInputStream fis = new FileInputStream("dbProperties.prop");
            p.load(fis);
        } catch (Exception e) {
            System.out.println("Something went wrong." + e);
        }
        String url = p.getProperty("url");
        String usr = p.getProperty("user");
        String pwd = p.getProperty("password");
        try {
            Connection con = DriverManager.getConnection("url", usr, pwd);
        } catch (SQLException e) {
            System.out.println("db connection issue" + e);
        }
    }
}
