<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
    <title>Converter</title>
</head>
<body>
 
<div align="center">
    <h2>Rates</h2>
  
<!-- make a table of rates -->
    
<c:if test="${!empty listGetRate}">
	<table class="tg">
	<tr>
		<th width="120">Id</th>
		<th width="120">Currency</th>
		<th width="120">Sell</th>
		<th width="120">Buy</th>

	</tr>
	<c:forEach items="${listGetRate}" var="getRate">
		<tr>
			<td>${getRate.id}</td>
			<td>${getRate.currency}</td>
			<td>${getRate.sell}</td>
			<td>${getRate.buy}</td>

		</tr>
	</c:forEach>
	</table>
</c:if>

<!-- form for convert money: textfield for amount and two dropdown menus to choose currencies  -->

<div align="center">
    <h2>Conversion</h2>
    <form action="result.jsp" method="post">
            <tr> 
          <td width="48%">Amount</td>
          <td width="52%">
            <input type="text" name="amount" />
          </td>
        </tr>

        Convert from:&nbsp;
        <select name="convertFrom">
            <c:forEach items="${listGetRate}" var="getRate">
                <option value="${getRate.id}">
                    ${getRate.currency}
                </option>
            </c:forEach>
        </select>
        
    <!--  form action="list" method="post"-->
        Convert to:&nbsp;
        <select name="convertTo">
            <c:forEach items="${listGetRate}" var="getRate">
                <option value="${getRate.id}">
                    ${getRate.currency}
                </option>
            </c:forEach>
        </select>
        <br/><br/>
               
               <input TYPE="submit" value="Calculate">
            
        </FORM>
</div>


   
</body>
</html>