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
	
	.odd {
		background-color: #fff;
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
	    background-color: #f2f2f2;
	}
	
	.block-container {
	    border: 1px solid #ccc;
	    word-wrap: break-word;
	    border-radius: 5px;
	    padding: 5px;
	    margin: 5px;
	}
	
	#itemToSort {
		margin-top: 15px;
	}
	
	.button {
		background-color: #4CAF50;
	    border: none;
	    color: white;
	    padding: 11px 32px;
	    text-align: center;
	    text-decoration: none;
	    font-size: 16px;
	    border-radius: 5px;
	    cursor: pointer;
	}
	
	.button:hover {
	    box-shadow: 0 10px 10px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
	}
	
	input[type=text] {
	    width: 27%;
	    padding: 12px 20px;
	    margin: 8px 0;
	    display: inline-block;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box;
	}
</style>
<script type="text/javascript">
	function validate(){
		var limit = document.getElementById("limit").value;
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
		<div class="content-container" align="center" style="border: none;">
			<form action="/generate" method="post" onsubmit="return validate();">
				<label class="bold"></label>
				<input autocomplete="off" placeholder="Enter the No. of Random Numbers to be generated" type="text" id="limit" name="limit"/> <br/>
				<input class="button" type="submit" value="Generate"/>
			</form>
		</div>
		<c:if test="${not empty randomNumbers}">
			<div id="itemToSort" align="center">
				<form action="/sort" method="post">
					<label style="font-size: 1.2em;" class="bold">Generated Random Numbers</label> <br/>
					<label>${randomNumbers}</label><br/>
					<input type="hidden" name="numbers" value="${randomNumbers}"/>
					<input class="button" type="submit" style="margin-left: 0; margin-top:10px;" value="Sort (Ascending)"/>
				</form>
			</div>
		</c:if>
		<c:if test="${not empty numbers}">
			<div class="content-container">
				<label class="bold" style="font-size: 1.2em;">
					Sorted Data from Database
				</label>
				<c:forEach items="${numbers}" var="number" varStatus="counter">
					<div class="block-container ${counter.index % 2 == 0 ? 'even' : 'odd'}">
						<div><span class="bold">Unsorted Number: </span>${number.unsortedNumbers}</div>
						<div><span class="bold">Sorted Number: </span>${number.sortedNumbers}</div>
						<div><span class="bold">No. of Position Changed: </span>${number.noOfPositionsChanged}</div>
						<div><span class="bold">Time Taken: </span>${number.sortTime}ms</div>
					</div>				
				</c:forEach>
			</div>
		</c:if>
	</div>
</body>
</html>