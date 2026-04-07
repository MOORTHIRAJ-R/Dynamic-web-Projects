package dao;

import java.sql.*;
import util.DBConnection;

public class AccountDAO {

	TransactionDAO tdao = new TransactionDAO();

	public boolean deposit(int accNo, double amount) {
	    String query = "UPDATE account SET balance = balance + ? WHERE account_no = ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {

	        ps.setDouble(1, amount);
	        ps.setInt(2, accNo);

	        if (ps.executeUpdate() > 0) {
	            tdao.addTransaction(accNo, "DEPOSIT", amount);
	            return true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

	public boolean withdraw(int accNo, double amount) {
	    String query = "UPDATE account SET balance = balance - ? WHERE account_no = ? AND balance >= ?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(query)) {

	        ps.setDouble(1, amount);
	        ps.setInt(2, accNo);
	        ps.setDouble(3, amount);

	        if (ps.executeUpdate() > 0) {
	            tdao.addTransaction(accNo, "WITHDRAW", amount);
	            return true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}

    public boolean transfer(int fromAcc, int toAcc, double amount) {

        String withdrawQuery = "UPDATE account SET balance = balance - ? WHERE account_no = ? AND balance >= ?";
        String depositQuery = "UPDATE account SET balance = balance + ? WHERE account_no = ?";

        try (Connection con = DBConnection.getConnection()) {

            // 🔥 Start transaction
            con.setAutoCommit(false);

            // Withdraw
            try (PreparedStatement ps1 = con.prepareStatement(withdrawQuery)) {
                ps1.setDouble(1, amount);
                ps1.setInt(2, fromAcc);
                ps1.setDouble(3, amount);

                int rows1 = ps1.executeUpdate();

                if (rows1 == 0) {
                    con.rollback();
                    return false;
                }
            }

            // Deposit
            try (PreparedStatement ps2 = con.prepareStatement(depositQuery)) {
                ps2.setDouble(1, amount);
                ps2.setInt(2, toAcc);

                int rows2 = ps2.executeUpdate();

                if (rows2 == 0) {
                    con.rollback();
                    return false;
                }
            }

            // ✅ Success
            con.commit();
            tdao.addTransaction(fromAcc, "TRANSFER_OUT", amount);
            tdao.addTransaction(toAcc, "TRANSFER_IN", amount);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
	}

