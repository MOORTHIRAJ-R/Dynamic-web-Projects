<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Transfer</title>
</head>
<body>

<h2>Transfer Money</h2>

<form action="transfer" method="post">
    From Account: <input type="number" name="fromAcc" required><br><br>
    To Account: <input type="number" name="toAcc" required><br><br>
    Amount: <input type="number" name="amount" required><br><br>

    <button type="submit">Transfer</button>
</form>

<a href="dashboard.jsp">Back</a>

</body>
</html>