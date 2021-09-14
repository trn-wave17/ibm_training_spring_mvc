<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Student Details</h3>
        <springForm:form method="POST" action="addStudent" modelAttribute="student">
             <table>
             	
                <tr>
                    <td><springForm:label path="firstName">First Name</springForm:label></td>
                    <td><springForm:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><springForm:label path="lastName">Last Name</springForm:label></td>
                    <td><springForm:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><springForm:label path="email">Email Id</springForm:label></td>
                    <td><springForm:input path="email"/></td>
                </tr>
                <tr>
                    <td><springForm:label path="gender">Gender</springForm:label></td>
                    <td><springForm:input path="gender"/></td>
                </tr>
                 <tr>
                    <td><springForm:label path="totalSpentInBooks">Amount Spent</springForm:label></td>
                    <td><springForm:input path="totalSpentInBooks"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </springForm:form>
    </body>
</html>