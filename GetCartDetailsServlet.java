package test;

import java.io.*;

import java.util.*;

import javax.servlet.*;

import javax.servlet.http.*;

public class GetCartDetailsServlet extends HttpServlet
{
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

		out.println("<title>Shopping Cart</title>");

		out.println("</head><body>");

		out.println("<table width='100%' height='90%' border='1'>");

		out.println("<tr align='center'>");

		out.println("<td height='39' colspan='2'><strong><font size='5'>Online Vegetable Merketing System</font></strong></td>");

		out.println("</tr>");

		out.println("<tr>");

		out.println("<td width='18%' height='500' valign='top'><p>&nbsp;</p>");

		out.println("<blockquote>");

		out.println("<p><a href='"+response.encodeURL("getProducts")+"'>View Products</a></p>");
		out.println("<p><a href="+response.encodeURL("getCart")+">View Cart Details</a></p>");

		out.println("<p><a href='"+response.encodeURL("logout")+"'>Logout</a></p>"); out.println("</blockquote></td>");

		out.println("<td width='82%' align='left' valign='top'><p><font size='6'>Welcome, "+uname+"</font></p>");

		out.println("<center>Your Cart cotains the following products");

		out.println("<table width='80%' border='1'>");

		out.println("<tr>");

		out.println("<th width='24%'>Product Code</th>");

		out.println("<th width='28%'>Product Name</th>");

		out.println("<th width='20%'>Quantity</th>");

		out.println("</tr>");

		Collection products=(Collection)hs.getAttribute("products");

		if(products==null)
		{
		out.println("<tr><td colspan='3' align='center'>");

		out.println("You Have Not added any products into cart");
		out.println("</td></tr>");
		}
		else
		{
		Iterator i = products.iterator();

		while(i.hasNext())
		{

		Product p = (Product)i.next(); out.println("<tr>");
		out.println("<td>"+p.getCode()+"</td>");

		out.println("<td>"+p.getName()+"</td>");

		out.println("<td>"+p.getQty()+"</td>");

		out.println("</tr>");

		}
		}

		out.println("</table></center>");

		out.println("</td></tr>");

		out.println("<tr align='center'>");

		out.println("<td colspan='2'><em>&copy;Copyrights 2016-17</em></td>");

		out.println("</tr>");

		out.println("</table>");

		out.println("</body></html>");

		out.flush();

		out.close();

		}
}