<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>

<h3>Get Stock Price</h3>
	
	<form method="get" action="getTotalCost">
		<table>
			<tr>
				<td>CompanyName</td>
				<td>
					<input type='text' name='companyName'/>
				</td>
			</tr>
			
			<tr>
				<td>Quantity</td>
				<td>
					<input type='text' name='quantity'/>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input type='submit' value='Get Cost'/>
				</td>
			</tr>
		</table>
	</form>
	${msg }
</body>
</html>