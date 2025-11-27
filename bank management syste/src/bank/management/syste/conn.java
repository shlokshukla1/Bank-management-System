package bank.management.syste;
import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn() {
        try {
            // Correct URL format
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsyste", "root", "shlok");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace(); // better for debugging
        }
    }
}
