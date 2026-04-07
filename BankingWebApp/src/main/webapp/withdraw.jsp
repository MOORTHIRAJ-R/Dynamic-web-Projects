<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Withdraw</title>
</head>
<body>

<h2>Withdraw Money</h2>

<form action="withdraw" method="post">
    Account No: <input type="number" name="accNo" required><br><br>
    Amount: <input type="number" name="amount" required><br><br>

    <button type="submit">Withdraw</button>
</form>

<a href="dashboard.jsp">Back</a>

</body>
</html>