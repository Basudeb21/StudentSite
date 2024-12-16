<%@page import="com.student.helper.ConnectionProvider"%>
<%@page import="com.student.dao.StreamDao"%>
<%@page import="com.student.entities.Stream"%>
<%@page import="java.util.List"%>

<%
    StreamDao streamDao = new StreamDao(ConnectionProvider.getConnection());
    List<Stream> streams = streamDao.getAllStreams();
%>



<label for="stream" class="form-label">Select Stream</label>

<select class="form-select" id="stream" name="stream">
    <% if (streams != null && !streams.isEmpty()) {%>
        <option value="" disabled selected>none</option>
        <%
        for (Stream stream : streams) { %>
            <option value="<%= stream.getName() %>"><%= stream.getName() %></option>
        <% }
    } 
    else { %>
        <option value="" disabled selected>not selected</option>
    <% } %>
</select>
