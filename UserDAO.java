package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public boolean validate(String uname, String pass) {

        String sql =
                "SELECT 1 FROM userdetails WHERE uname = ? AND pass = ?";

        try (
            Connection con = DriverConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {

            ps.setString(1, uname);
            ps.setString(2, pass);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
