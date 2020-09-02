package collections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) {
        Properties p = new Properties();
        try {
            FileInputStream fis = new FileInputStream("C://Users//mamilla.revathi//IdeaProjects//git//Spark-scala//src//test//resources//propertiesExample.prop");
            p.load(fis);
        } catch (IOException e) {
            System.out.println("Something went wrong." + e);
        }
        System.out.println(p);
        System.out.println(p.getProperty("abc"));
        System.out.println(p.setProperty("xyz", "345"));
        try {
            FileOutputStream fos = new FileOutputStream("C://Users//mamilla.revathi//IdeaProjects//git//Spark-scala//src//test//resources//propertiesExample.prop");
            p.store(fos, "to check store property");
        } catch (IOException e) {
            System.out.println("Something went wrong." + e);
        }
    }
}
