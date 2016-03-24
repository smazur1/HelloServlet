


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet2")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Preprocess request: we actually don't need to do any business stuff, so just display JSP.
	        request.getRequestDispatcher("/Hello.jsp").forward(request, response);
	    }

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Postprocess request: gather and validate submitted data and display the result in the same JSP.

	        // Prepare messages.
	        Map<String, String> messages = new HashMap<String, String>();
	        request.setAttribute("messages", messages);

	        // Get and validate name.
	        String name = request.getParameter("name");
	        if (name == null || name.trim().isEmpty()) {
	            messages.put("name", "Please enter name");
	        } else if (!name.matches("\\p{Alnum}+")) {
	            messages.put("name", "Please enter alphanumeric characters only");
	        }

	        // Get and validate age.
	        String age = request.getParameter("age");
	        if (age == null || age.trim().isEmpty()) {
	            messages.put("age", "Please enter age");
	        } else if (!age.matches("\\d+")) {
	            messages.put("age", "Please enter digits only");
	        }

	        // Get and validate color.
	        String color = request.getParameter("color");
	        if (color == null || color.trim().isEmpty()) {
	            messages.put("color", "Please enter color");
	        } else if (!color.matches("\\p{Alnum}+")) {
	            messages.put("color", "Please enter alpha characters only");
	        }
	        
	        // No validation errors? Do the business job!
	        if (messages.isEmpty()) {
	            messages.put("success", String.format("Hello, your name is %s and your age is %s and your "
	            		+ "favorite color is %s!" , name, age, color));
	        }

	        request.getRequestDispatcher("/output.jsp").forward(request, response);
	    }
}

