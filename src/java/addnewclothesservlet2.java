/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import controller.DBConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import static java.lang.System.out;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import model.addclothes;
/**
 *
 * @author Siric
 */
@WebServlet(urlPatterns = {"/addnewclothesservlet2"})
public class addnewclothesservlet2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String clothesname = request.getParameter("clothesname");
        String clothes = request.getParameter("clothes");
        String site = request.getParameter("site");
        String colori = request.getParameter("colori");
        String clothespriceStr = request.getParameter("clothesprice");

        if (clothespriceStr == null || clothespriceStr.trim().isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("/addnewclothes.html");
            rd.forward(request, response);
            return;
        }

        try {
            int clothesprice = Integer.parseInt(clothespriceStr.trim());

            addclothes newclothes = new addclothes();
            newclothes.setclothesname(clothesname);
            newclothes.setclothes(clothes);
            newclothes.setsite(site);
            newclothes.setcolori(colori);
            newclothes.setclothesprice(clothesprice);

            HttpSession session = request.getSession();
            session.setAttribute("addclothes", newclothes);

            DBConnection dbConnection = new DBConnection();
            if (!dbConnection.insertNewclothes(newclothes)) {
                System.out.println(">>> AddNewclothesMySQL ERROR");
            }
           
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/addnewclothesuccess.jsp");
            rd.forward(request, response);
 

        } catch (NumberFormatException e) {
            RequestDispatcher rd = request.getRequestDispatcher("/addnewclothes.html");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
