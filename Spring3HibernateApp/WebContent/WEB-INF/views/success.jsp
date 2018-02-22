<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://jsptags.com/tags/navigation/pager" prefix="p"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Added successfully</title>
</head>
<body>
<%-- <c:out value="${user.uName}"/> Added successfully

<form:form method="GET" action="search.html">
      <table bgcolor="red" border="10px">
       <tr>
           <td><form:label path="uId">Search User</form:label></td>
           <td><form:input path="uId" value="${user.uId}"/></td>
           <td><input type="submit" value="Submit"></td>
       </tr>
       </table>
</form:form> --%>
<%-- <table bgcolor="green" border="10px">
<tr>
 <td><c:out value="${user.uId}"/></td>
    <td><c:out value="${user.uName}"/></td>
    </tr>
</table> --%>
<a href="allusers.html">All Users</a>



<c:if test="${!empty users}">
 <table align="left" border="1">
  <tr>
   <th>Usr ID</th>
   <th>User Name</th>
  </tr>

  <c:forEach items="${users}" var="user1">
   <tr>
   <p:pager start=0 range=5 results=users/>
    <td><c:out value=s"${user1.uId}"/></td>
    <td><c:out value="${user1.uName}"/></td>
   </tr>
  </c:forEach>
 </table>
</c:if>
</body>
</html>