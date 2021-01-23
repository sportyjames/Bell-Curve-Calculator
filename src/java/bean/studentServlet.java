/*
    Jiayu Wu
    3/8/19
    This is servlet
 */
package bean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wujiayu
 */
@WebServlet(name = "studentServlet", urlPatterns = {"/registerSuccess",
    "/inputGrade", "/rawGradeDisplay","/inputGrade2","/curveGradeDisplay"})
public class studentServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet studentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet studentServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        //processRequest(request, response);
        HttpSession session = request.getSession();
        String userPath = request.getServletPath();

        if (userPath.equals("/registerSuccess"))
        {
            try {
                String fName1 = request.getParameter("username1");
                String fName2 = request.getParameter("password1");

                javaSqlDb obj = new javaSqlDb("LoginDb");
                obj.insertData(fName1, fName2);
            
            
            
            String myUrl = "/WEB-INF" + userPath + ".jsp";
            
            try{
                request.getRequestDispatcher(myUrl).forward(request,response);
                
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            
            }
            catch (Exception e) {
                System.out.println("do not insert");
            }

        }
        
        else if (userPath.equals("/inputGrade")) {
            try {
                String fName3 = request.getParameter("username2");
                String fName4 = request.getParameter("password2");
                boolean status;
                
                javaSqlDb obj = new javaSqlDb("LoginDb");
                
                status = obj.validate(fName3, fName4);
                
                String myUrl;

                if (status) {
                    myUrl = "/WEB-INF"+ userPath +".jsp";

                } else {
                    myUrl =  "/loginFail" + ".jsp";
                }
                    
                    try {
                        request.getRequestDispatcher(myUrl).forward(request, response);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                

            } catch (Exception e2) {
                System.out.println("do not insert");
            }
        }
        
        else if(userPath.equals("/rawGradeDisplay"))
        {
            try{
                String dbName="studentDb";
                String tableName="studentInfo";
                String[] tableHeaders = {"IDnumber","grade"};
                javaSqlDb dbObj = new javaSqlDb(dbName);
                
                
                String fName5 = request.getParameter("ID");
                String fName6 = request.getParameter("grade");
                Integer f5 = Integer.parseInt(fName5);
                Integer f6 = Integer.parseInt(fName6);
                
                String myUrl;
                
                dbObj.insertStudentData(f5,f6);
                ArrayList<ArrayList<String>> data = dbObj.getData(tableName,tableHeaders);
                session.setAttribute("dbData",data);
                
                        
                myUrl = "/WEB-INF" + userPath + ".jsp"; 
                

            try{
                request.getRequestDispatcher(myUrl).forward(request, response);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
                
                 
            }
            catch (Exception e2) {
            
            String myUrl =  "/errorPage" + ".jsp";
            try{
                request.getRequestDispatcher(myUrl).forward(request,response);
                
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
                
            }
        }
        
        
         else if (userPath.equals("/inputGrade2")) {
             try{
             String myUrl = "/WEB-INF" + "/inputGrade" + ".jsp";
                try{
                request.getRequestDispatcher(myUrl).forward(request, response);
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
             }
            catch (Exception e) {
                System.out.println("do not insert");
         
         }
         }
         
         
         else if(userPath.equals("/curveGradeDisplay"))
         {
             try{
                 javaSqlDb obj = new javaSqlDb("studentDb");
                 int studentNum =obj.getNumberOfStudent();
                 
                session.setAttribute("STUDENTNUM",studentNum);
                 
                int a2 = obj.getA2(studentNum);
                int b1 = obj.getB1(a2);
                int b2 = obj.getB2(studentNum,b1);
                int c1 = obj.getC1(b2);
                int c2 = obj.getC2(studentNum,c1);
                int d1 = obj.getD1(c2);
                int d2 = obj.getD2(studentNum,d1);
                int f1 = obj.getF1(d2);
                int f2 = obj.getF2(studentNum,f1);
                
                
//                double a2double = studentNum*0.07;
//                int a2 = (int)Math.round(a2double);
//                
//                int b1 = a2 + 1;
//                
//                double b2double = studentNum*0.24-1;
//                int b2 = b1+(int)Math.round(b2double);
////                
//                int c1 = b2 + 1;
////                
//                double c2double = studentNum*0.38-1;
//                int c2 = c1 +(int)Math.round(c2double);
////                
//                int d1 = c2 + 1;
////                
//               double d2double = studentNum*0.24-1;
//                int d2 = d1 +(int)Math.round(d2double);
////                
//                int f1 = d2 + 1;
////                
//                double f2double = studentNum*0.07-1;
//                int f2 = f1 +(int)Math.round(f2double);
                
                
                
                session.setAttribute("a2",a2);
                
                session.setAttribute("b1",b1);
                
                session.setAttribute("b2",b2);
                
                session.setAttribute("c1",c1);
                
                session.setAttribute("c2",c2);
                
                session.setAttribute("d1",d1);
                
                session.setAttribute("d2",d2);
                
                session.setAttribute("f1",f1);
                
                session.setAttribute("f2",f2);
                
                
     
                ArrayList<Integer> order = obj.orderGrade();
                
                session.setAttribute("ORDER",order);
                
                 
                 String myUrl = "/WEB-INF" + userPath + ".jsp";
                 
                try{
                request.getRequestDispatcher(myUrl).forward(request,response);
                }
                catch(Exception ex){
                ex.printStackTrace();
            }
                
          }
             catch (Exception e2) {
                System.out.println("do not insert");
            }
             
         }
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
