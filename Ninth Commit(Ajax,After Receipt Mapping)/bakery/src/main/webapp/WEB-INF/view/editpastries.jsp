<%@ page language="java" import="com.model.Pastries" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Pastries</title>
</head>
<body>
<h1>Edit Cake</h1>  
       <form:form action="${pageContext.request.contextPath}/editsavepastries" modelAttribute="pastries" method="POST">    
        <table>    
        <tr>  
        <td>ID:</td>    
         <td><form:input path="ID" readonly="true" /></td>  
         </tr>   
         <tr>    
          <td>Name : </td>   
          <td><form:input path="NAME"/></td>  
         </tr>  
                              
         <tr>    
          <td>DESCRIPTION :</td>    
          <td><form:input path="DESCRIPTION"/></td>  
         </tr> 
          
         <tr>    
          <td>PRICE :</td>    
          <td><form:input path="PRICE"/></td>  
         </tr>  
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
</body>
</html>
