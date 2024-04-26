package test;

import java.io.*;
import javax.servlet.*;

import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
HttpSession hs = request.getSession(false);

if(hs!=null)
{
hs.invalidate();

RequestDispatcher rd = request.getRequestDispatcher("Login.html");
rd.forward(request,response);
}
}
}

