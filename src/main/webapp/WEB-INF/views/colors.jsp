<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TEST TASK 1</title>

<link href="<c:url value="/resource/css/style.css"/>" rel="stylesheet" type="text/css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="<c:url value="/resource/js/create_table.js"/>" ></script>
<script type="text/javascript">
$(document).ready(function() {
	readJSON(${colors});
});
</script> 
</head>
<body>
<div align="center">   
	<div id="rowColor"> color not select
	</div>
    <table id="table" border="1" cellpadding="5">
	  <thead>
	    <tr>
	      <th>Color number</th>
	      <th>Name</th>
	    </tr>
	  </thead>
	  <tbody></tbody>
	</table>
</div>   
 
</body>
</html>