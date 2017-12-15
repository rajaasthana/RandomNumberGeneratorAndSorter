<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Random Number Generator & Sorter</title>
<style type="text/css">

	.bold{
		font-weight: bold;
	}
	#header {
		width: 100%;
	    height: 50px;
	    text-align: center;
	    font-size: 30px;
	    font-weight: bold;
	    border-bottom: 1px solid #ccc;
	    margin-bottom: 10px
	}

	#container {
	    width: 98%;
	    margin: 0 auto;
	    border-radius: 5px;
	    padding: 10px;
	}
	
	.content-container {
	    border: 1px solid #ccc;
	    margin: 10px 10px 25px 10px;
	    padding: 5px;
	    border-radius: 5px;
	}
	
	.block-container {
	    border: 1px solid #ccc;
	    word-wrap: break-word;
	    border-radius: 5px;
	    padding: 5px;
	    margin: 5px;
	}
	
	#itemToSort {
		margin-top: 5px;
	}
</style>
<script type="text/javascript">
	function validate(){
		var limit = document.getElementById("limit").value);
		if(isNaN(parseFloat(limit))){
			alert("Enter valid number!");
			return false;
		}
		return true;
	}

</script>
</head>
<body>
	<div id="header">Welcome to Random Number Generator and Sorter</div>
	<div id="container">
		<div class="content-container" style="border: none">
			<form action="/generate" method="post">
				<label>No. of Random Numbers</label>
				<input type="text" size="5" id="limit" name="limit"/>
				<input type="submit" value="Generate" onclick="validate()"/>
			</form>
			<c:if test="${not empty randomNumbers}">
				<div id="itemToSort">
					<form action="/sort" method="post">
						<label>${randomNumbers}</label>
						<input type="hidden" name="numbers" value="${randomNumbers}"/>
						<input type="submit" value="Sort"/>
					</form>
				</div>
			</c:if>
			
		</div>
		<div class="content-container">
			<c:forEach items="${numbers}" var="number">
				<div class="block-container">
					<div><span class="bold">Unsorted Number: </span>${number.unsortedNumber}</div>
					<div><span class="bold">Sorted Number: </span>${number.sortedNumber}</div>
					<div><span class="bold">No. of Position Changed: </span>${number.noOfPositionChanged}</div>
					<div><span class="bold">Time Taken: </span>${number.sortTime}ms</div>
				</div>				
			</c:forEach>
		</div>
	</div>
</body>
</html>