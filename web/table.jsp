<%@page import="java.util.List"%>
<%@page import="com.student.entities.Student"%>
<%@page import="com.student.dao.StudentDao"%>
<%@page import="com.student.helper.ConnectionProvider"%>
<%
    List<Student> studentList = (List<Student>) session.getAttribute("studentList");
%>

<% if(studentList == null || studentList.isEmpty()){ 
        session.setAttribute("msg", "No student found");
    } 
    else{ %>
    <table class="table">
    <thead>
        <tr>
            <th scope="col">Roll</th>
            <th scope="col">Name</th>
            <th scope="col">Stream</th>
            <th scope="col">Reg. No</th>
        </tr>
    </thead>
    <tbody>
        <% 
            for (Student stu : studentList) {
                int roll = stu.getS_roll();
                String name = stu.getS_name();
                String stream = stu.getS_stream();
                String reg = stu.getS_reg();
        %>
        <tr>
            <td><%= roll %></td>
            <td><%= name %></td>
            <td><%= stream %></td>
            <td><%= reg %></td>
        </tr>
        <% 
            }
        %>
    </tbody>
</table>
    
<%
    }
%>
        
