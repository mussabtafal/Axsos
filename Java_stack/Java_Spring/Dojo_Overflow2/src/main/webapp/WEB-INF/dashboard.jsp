<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div class = "container-md-fluid m-5 p-5">
        <div class = "row justify-content-center">
            <div class = "col-7 ">
                <h1>Questions Dashboard</h1>
            </div>
        </div>
        <div class = "row justify-content-center">
	       <div class = "col-9 ">
	               <table class="table border col-5  ">
	             <thead>
	               <tr>
                     <th scope="col">Questions</th>
                     <th scope="col">Tags</th>
	               </tr>
	             </thead>
	             <tbody>
	               <c:forEach var="question" items="${allQuestions}">
	               <tr>
	                   <td><a href="/questions/${question.id}"><c:out value="${question.name}"></c:out></a></td>
	                   <td>
	                   <c:forEach var="tag" items="${question.questionTags}">
	                    	<c:out value="${tag.subject}"></c:out>,  
	                    </c:forEach>  
	                    </td>                 
	               </tr>
	               </c:forEach>
	             </tbody>
	           </table>
	       </div>
        </div>
    </div>          
</body>
</html>