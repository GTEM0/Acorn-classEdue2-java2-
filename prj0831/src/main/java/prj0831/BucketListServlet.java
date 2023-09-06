// BucketListServlet.java
package prj0831;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bucketList")
public class BucketListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceBucketList service = new ServiceBucketList();
        ArrayList<String> list = service.getBucketList();

        request.setAttribute("bucketList", list);
        request.getRequestDispatcher("WEB-INF/views/bucketList.jsp").forward(request, response);
    }
}
