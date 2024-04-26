package test;
import java.io.*;

import javax.servlet.*;

import javax.servlet.http.*;

import java.util.*;

public class GetProductsServlet extends HttpServlet
{
public void init() throws ServletException
{
productsdao = new ProductsDAO();
}
public void doGet(HttpServletRequest request, HttpServletResponse response)

throws ServletException, IOException
{
HttpSession hs = request.getSession(false);
if(hs==null)
{
RequestDispatcher rd = request.getRequestDispatcher("Login.html"); 
rd.forward(request,response);

return;

}

String uname = (String)hs.getAttribute("UserName");

response.setContentType("text/html");

PrintWriter out = response.getWriter();

out.println("<html><head>");

out.println("<title>MY SHOPPING CART</title>");

out.println("</head><body>");

out.println("<table width='100%' height='90%' border='1'>");

out.println("<tr align='center'>");

out.println("<td height='39' colspan='2'><strong><font size='5'>MY SHOPPING CART</font></strong></td>");
out.println("</tr>");

out.println("<tr>");

out.println("<td width='18%' height='500' valign='top'><p>&nbsp;</p>");

out.println("<blockquote><p>");

out.println("<a href='"+response.encodeURL("getProducts")+"'>");

out.println("View Products</a></p><p>");

out.println("<a href='"+response.encodeURL("getCart")+"'>");

out.println("View Cart Details</a></p>");

out.println("<a href='"+response.encodeURL("logout")+"'>");

out.println("Logout</a></p>");

out.println("</blockquote></td>");

out.println("<td width='82%' align='left' valign='top'><p>");

out.println("<font size='6'>Welcome, "+uname+"</font></p>");

out.println("<form method='post' action='"+response.encodeURL("addProducts")+"'>");

out.println("<table width='100%' border='1'>");

out.println("<tr>");

out.println("<th width='8%'>check</th>");

out.println("<th width='24%'>product Code</th>");

out.println("<th width='28%'>product Name</th>");

out.println("<th width='20%''>Available Quantity</th>");

out.println("<th width='20%'>Required Quantity</th>");

out.println("</tr>");

Collection products = productsdao.getProducts();

if(products==null)
{
out.println("<tr><td colspan='5' align='center'>");

out.println("No Products Available"); out.println("</td></tr>");
}
else
{
Iterator i=products.iterator();
while(i.hasNext())
{
Product p = (Product)i.next();

out.println("<tr>");

out.println("<td align='center'>");

out.println("<input type='checkbox' name='products' value='"+p.getCode()+"'/>");

out.println("<input type='hidden' name='"+p.getCode()+"'Name'value='"+p.getName()+"'/></td>");

out.println("<td>"+p.getCode()+"</td>");

out.println("<td>"+p.getName()+"</td>");

out.println("<td>"+p.getQty()+"</td>");

out.println("<td>");

out.println("<input type='text' name='"+p.getCode()+"'/>");

out.println("</td></tr>");
}
}
out.println("</table>");

out.println("<br/><center>");

out.println("<input type='submit' value='Add Products to Cart'/>");

out.println("</center>");

out.println("</form>");

out.println("</td></tr>");

out.println("<tr align='center'>");

out.println("td colspan='2'>");

out.println("<em>&copy:CopyRights 2016-2017</em></td>");

out.println("</tr>");

out.println("</table>");

out.println("</body></html>");

out.flush();

out.close();

}

ProductsDAO productsdao;

}