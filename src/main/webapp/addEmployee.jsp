<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        <springForm:form method="POST" action="addEmployee" modelAttribute="employee">
             <table>
             	
                <tr>
                    <td><springForm:label path="eid">Id</springForm:label></td>
                    <td><springForm:input path="eid"/></td>
                </tr>
                <tr>
                    <td><springForm:label path="ename">Name</springForm:label></td>
                    <td><springForm:input path="ename"/></td>
                </tr>
                <tr>
                    <td><springForm:label path="email">Email Id</springForm:label></td>
                    <td><springForm:input path="email"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </springForm:form>
    </body>
</html>