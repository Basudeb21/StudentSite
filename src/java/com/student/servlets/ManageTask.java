package com.student.servlets;

import com.student.dao.StudentDao;
import com.student.entities.Student;
import com.student.helper.ConnectionProvider;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nil
 */
@WebServlet(name = "manage-task", urlPatterns = {"/manage-task"})
public class ManageTask extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            String action = req.getParameter("action");
            StudentDao call = new StudentDao(ConnectionProvider.getConnection());

            if("addStudent".equals(action)){
                int roll = Integer.parseInt(req.getParameter("roll"));
                String name = req.getParameter("name");
                String stream = req.getParameter("stream");
                LocalDate ld = LocalDate.now();
                String year = Integer.toString(ld.getYear());
                String month = Integer.toString(ld.getMonthValue());
                String date = Integer.toString(ld.getDayOfMonth());
                String reg = year+month+date+roll;
                
                if(call.isStudentExists(roll)){
                    HttpSession ses = req.getSession();
                    ses.setAttribute("msg", "The roll you entered is already present in database.");
                    res.sendRedirect("index.jsp");
                }
                else{
                    Student st = new Student(roll, name, stream, reg);
                    if(call.addNewStudent(st)){
                        HttpSession ses = req.getSession();
                        ses.setAttribute("msg", "Data added to database.");
                        res.sendRedirect("index.jsp");
                    }
                    else{
                        HttpSession ses = req.getSession();                
                        ses.setAttribute("msg", "Error to add data.");
                        res.sendRedirect("index.jsp");
                    }
                }        
            }
            else if("refreshPage".equals(action)){
                HttpSession ses = req.getSession();
                ses.removeAttribute("msg");
                ses.removeAttribute("studentList");
                res.sendRedirect("index.jsp");
            }
            else if("searchStudent".equals(action)){
                String roll = req.getParameter("roll");
                String name = req.getParameter("name");
                String stream = req.getParameter("stream");

                boolean isRollProvided = (roll != null && !roll.isBlank());
                boolean isNameProvided = (name != null && !name.isBlank());
                boolean isStreamSelected = (stream != null && !stream.equals("none"));

                HttpSession ses = req.getSession();

                if(isRollProvided && !isNameProvided && !isStreamSelected){
                    int s_roll = Integer.parseInt(roll);
                    List<Student> stu = call.searchStudentByRoll(s_roll);

                    if(stu == null || stu.isEmpty()){
                        ses.removeAttribute("studentList");
                        ses.setAttribute("msg", "No students are for this roll.");
                        res.sendRedirect("index.jsp");
                    } else {
                        ses.setAttribute("studentList", stu);
                        ses.removeAttribute("msg");
                        res.sendRedirect("index.jsp");
                    }
                }
                else if(!isRollProvided && isNameProvided && !isStreamSelected){
                    List<Student> stu = call.searchStudentByName(name);

                    if(stu == null || stu.isEmpty()){
                        ses.removeAttribute("studentList");
                        ses.setAttribute("msg", "No students are for this name.");
                        res.sendRedirect("index.jsp");
                    } else {
                        ses.removeAttribute("msg");
                        ses.setAttribute("studentList", stu);
                        res.sendRedirect("index.jsp");
                    }
                }
                else if(!isRollProvided && !isNameProvided && isStreamSelected){
                    List<Student> stu = call.searchStudentByStream(stream);

                    if(stu == null || stu.isEmpty()){
                        ses.removeAttribute("studentList");
                        ses.setAttribute("msg", "No students are for this stream.");
                        res.sendRedirect("index.jsp");
                    } else {
                        ses.setAttribute("studentList", stu);
                        ses.removeAttribute("msg");                        
                        res.sendRedirect("index.jsp");
                    }
                }
                else{
                    ses.setAttribute("msg", "At least one item should be selected.");
                    ses.removeAttribute("studentList");
                    res.sendRedirect("index.jsp");
                }
            }
            else if("searchAll".equals(action)){
                List<Student> stu = call.searchAllStudent();
                HttpSession ses = req.getSession();
                if(stu == null || stu.isEmpty()){
                    ses.removeAttribute("studentList");
                    ses.setAttribute("msg", "No students are registered yet.");
                    res.sendRedirect("index.jsp");
                } else {
                    ses.setAttribute("studentList", stu);
                    ses.removeAttribute("msg");
                    res.sendRedirect("index.jsp");
                }
            }
            else if("updateStudent".equals(action)){
                 int roll = Integer.parseInt(req.getParameter("roll"));
                String name = req.getParameter("name");
                String stream = req.getParameter("stream");
                HttpSession ses = req.getSession();
                if(call.updateStudentByNameOrRoll(roll, name, stream)){
                    ses.removeAttribute("studentList");
                    ses.setAttribute("msg", "Student data successfully updated.");
                    res.sendRedirect("index.jsp");
                } else {
                    ses.removeAttribute("studentList");
                    ses.setAttribute("msg", "Student data not updated.");
                    res.sendRedirect("index.jsp");
                }
            }
            else if("deleteStudent".equals(action)){
                int roll = Integer.parseInt(req.getParameter("roll"));
                HttpSession ses = req.getSession();
                if(call.deleteStudent(roll)){
                    ses.removeAttribute("studentList");
                    ses.setAttribute("msg", "Student data successfully deleted.");
                    res.sendRedirect("index.jsp");
                } else {
                    ses.removeAttribute("studentList");
                    ses.setAttribute("msg", "No roll selected to delete.");
                    res.sendRedirect("index.jsp");
                }
            }
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
