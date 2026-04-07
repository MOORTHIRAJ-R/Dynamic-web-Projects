package dao;

import java.sql.*;
import java.util.*;
import util.DBConnection;
import model.Transaction;

public class TransactionDAO {

    // INSERT
    public void addTransaction(int accNo, String type, double amount) {

        String query = "INSERT INTO transactions(account_no, type, amount) VALUES(?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, accNo);
            ps.setString(2, type);
            ps.setDouble(3, amount);

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // FETCH
    public List<Transaction> getTransactions(int accNo) {

        List<Transaction> list = new ArrayList<>();

        String query = "SELECT * FROM transactions WHERE account_no=? ORDER BY date DESC";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Transaction t = new Transaction();
                t.setTxnId(rs.getInt("txn_id"));
                t.setAccountNo(rs.getInt("account_no"));
                t.setType(rs.getString("type"));
                t.setAmount(rs.getDouble("amount"));
                t.setDate(rs.getString("date"));

                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}