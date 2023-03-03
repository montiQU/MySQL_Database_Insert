import java.sql.*;

public class DBConnection {
    private final String url = "jdbc:mysql://localhost:3306/example/";
    private String user = "root";
    private String password = "";
    private String db = "example";
    private String command;

    public class Main {

        public static void main(String[] args) {

            String dbURL = "jdbc:mysql://localhost:3306/testbank";
            String user = "root";
            String password = "";

            try (Connection conn = DriverManager.getConnection(dbURL, user, password)) {

                if (conn != null) {
                    System.out.println("Verbindung zur Datenbank hergestellt!");


                    String sql = "INSERT INTO tbl_benutzer (id, name) VALUES (?, ?)";

                    try (PreparedStatement statement = conn.prepareStatement(sql)) {

                        statement.setString(1, "1");
                        statement.setString(2, "benni");

                        int rowsInserted = statement.executeUpdate();
                        if (rowsInserted > 0) {
                            System.out.println("Ein neuer Datensatz wurde erfolgreich hinzugefügt.");
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }


                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }


        }
    }
}

/*
    public static void main(String[] args) {

        final String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "";

        try {
            // Verbindung aufbauen
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Verbindung erfolgreich hergestellt");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

*/
/*    public DBConnection (String text) throws SQLException {
        this.setCommand("SELECT * FROM mainexamples WHERE Name LIKE '%"+text+"%'");

        try {
            // Verbindung aufbauen
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Verbindung erfolgreich hergestellt");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    *//*


    public String getCommand() {
        return command;
    }
    public void setCommand(String command) {
        this.command = command;
    }
    public String getUrl() {
        return url;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDb() {
        return db;
    }
    public void setDb(String db) {
        this.db = db;
    }
}*/
