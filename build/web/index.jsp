<%-- 
    Document   : index
    Created on : 16-Dec-2024, 1:12:46 pm
    Author     : Nil
--%>
<%@page import="com.student.entities.Student"%>
<%
    String msg = (String)session.getAttribute("msg");
    List<Student> studentList = (List<Student>) session.getAttribute("studentList");
    if(msg == null || msg.isBlank() || msg.isEmpty()){
        msg = "No message for now";
    }
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</head>

<body>
    <div class="container-fluid bg-custom pt-5 pb-5">
        <div class="container">
            <div class="row text-primary">
                <div class="col-md-12">
                    <form method="post" action="manage-task">
                        <div class="row">
                            <div class="col-md-4">
                                <div class="mb-3">
                                    <label for="roll" class="form-label">Roll</label>
                                    <input type="number" name="roll" class="form-control" id="roll"
                                        placeholder="Enter your roll here">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="mb-3">
                                    <label for="name" class="form-label">Name</label>
                                    <input type="text" class="form-control" id="name" name="name">
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="col-5">
                                    <%@include file="dropdown.jsp" %>
                                </div>
                            </div>
                        </div>
                        
                        <button type="submit" name="action" value="addStudent" class="btn btn-success">ADD</button>
                        <button type="submit" name="action" value="searchStudent" class="btn btn-info text-white">SEARCH</button>
                        <button type="submit" name="action" value="searchAll" class="btn btn-primary">SEARCH ALL</button>
                        <button type="submit" name="action" value="refreshPage" class="btn btn-secondary">REFRESH</button>
                        <button type="submit" name="action" value="updateStudent" class="btn btn-warning text-white">UPDATE</button>
                        <button type="submit" name="action" value="deleteStudent" class="btn btn-danger ">DELETE</button>

                    </form>
                            <div class="mt-3 text-success"><strong>Message : <%= msg %></strong></div>
                </div>
            </div>
        </div>
        <div class="container pt-5">
            <div class="mt-3 text-success mb-3"><strong>This area is for display the student details</strong></div>
            <% if (studentList != null) { %>
                <jsp:include page="table.jsp" />
            <% } else { %>
                <div class="mt-3 text-danger mb-3"><strong>No table is for now</strong></div>
            <% } %>
</div>
    </div>
</body>

</html>