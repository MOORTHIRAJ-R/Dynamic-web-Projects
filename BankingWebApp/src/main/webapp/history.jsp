<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.Transaction" %>

<%@ page import="java.util.*, model.Transaction" %>

<h2>Transaction History</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Type</th>
    <th>Amount</th>
    <th>Date</th>
</tr>

<%

List<Transaction> list = (List<Transaction>) request.getAttribute("transactions");

if(list != null){
    for(Transaction t : list){
%>
<tr>
    <td><%= t.getTxnId() %></td>
    <td><%= t.getType() %></td>
    <td><%= t.getAmount() %></td>
    <td><%= t.getDate() %></td>
</tr>
<%
    }
} else {
%>
<tr>
    <td colspan="4">No Transactions Found</td>
</tr>
<%
}
%>

</table>


