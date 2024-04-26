package test;

import java.sql.*;

import java.util.*;

public class ProductsDAO
{
public Collection getProducts()
{
try
{
Connection con = DriverConnection.getConnection();

Statement st = con.createStatement();

ResultSet rs = st.executeQuery("select * from products");

ArrayList products = new ArrayList();

while(rs.next())
{
Product p = new Product();

p.code = rs.getString(1);

p.name = rs.getString(2);

p.qty=rs.getDouble(3);

products.add(p);

return products;
}
}//end of try

catch (Exception e)
{
e.printStackTrace();
}
return null; 
}
}
