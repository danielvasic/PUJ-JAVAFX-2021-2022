package ba.sum.fsre.puj.pujjavafx20212022.model;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RepetedEntity.class)
@interface Entity {
    String type();
    int size() default 0;
    boolean primary() default false;
    boolean isnull() default true;
}

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RepetedForeignKey.class)
@interface ForeignKey {
    String table();
    String attribute();
}

@Retention(RetentionPolicy.RUNTIME)
@interface RepetedEntity{
    Entity[] value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface RepetedForeignKey{
    ForeignKey[] value();
}

public class Database{

    private static String hostname = "212.39.115.102";
    private static String user = "fsre-pjava";
    private static String password = "v8XZRY7z0Cnmht7R";
    private static String database = "fsre_restoran";

    public static Connection CONNECTION = null;

    static {
        try {
            CONNECTION = DriverManager.getConnection(
                    "jdbc:mysql://"+hostname+":3306/"+database, user, password
            );
        } catch (SQLException e) {
            System.out.println("Nisam se uspio spojiti na bazu podataka: " + e.getMessage());
        }
    }
}
