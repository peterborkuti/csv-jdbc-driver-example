package org.usageexample;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        String resourceName = "test.csv";

        ClassLoader classLoader = new App().getClass().getClassLoader();
        String path = classLoader.getResource(resourceName).getPath();

        String parent = Paths.get(path).getParent().toAbsolutePath().toString();
        try (
        Connection conn = DriverManager.getConnection("jdbc:csv:" + parent);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM test.csv")
        ){
            while (rs.next()) System.out.println(rs.getString(1) + " - " + rs.getString(2));
        }
    }
}
