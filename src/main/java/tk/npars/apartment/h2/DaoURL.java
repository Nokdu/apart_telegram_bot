package tk.npars.apartment.h2;

import tk.npars.apartment.helper.OlxAnnounce;

import java.sql.*;

public class DaoURL {

    private static Connection db;

    private static final String CREATE_QUERY =
            "CREATE TABLE IF NOT EXISTS PUBLIC.URL (id_url INT NOT NULL AUTO_INCREMENT, url VARCHAR, type VARCHAR, name VARCHAR, PRIMARY KEY (id_url))";
    private static final String DROP_QUERY =
            "DROP TABLE IF EXISTS PUBLIC.URL";
    public DaoURL() {
        try {
            db = DriverManager.getConnection(
                    "jdbc:h2:./telegramdb",
                    "user_telegram",
                    "user_telegram_password");
        } catch (SQLException e) {
            System.out.println("Database connection failure: "
                    + e.getMessage());
        }
    }

    public void execute(){
//        dropDB();
        createDB();
//        insertOlxDB();
    }

    private void dropDB(){
        try (Statement dataQuery = db.createStatement()) {
            dataQuery.execute(DROP_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createDB(){
        try (Statement dataQuery = db.createStatement()) {
            dataQuery.execute(CREATE_QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertOlxDB(String url, String type, String name){
        String query = "INSERT INTO PUBLIC.URL (URL, TYPE, NAME) VALUES(?,?,?)";
        try (PreparedStatement statement = db.prepareStatement(query)) {
            statement.setString(1, url );
            statement.setString(2, type );
            statement.setString(3, name );
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
