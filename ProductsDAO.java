package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

public class ProductsDAO {

    public Collection<Product> getProducts() {

        ArrayList<Product> products = new ArrayList<>();

        String sql = "SELECT code, name, qty FROM products";

        try (
            Connection con = DriverConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Product p = new Product();

                p.setCode(rs.getString("code"));
                p.setName(rs.getString("name"));
                p.setQty(rs.getDouble("qty"));

                products.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
}
