package service;

import dao.AccountDAO;

public class AccountService {

    AccountDAO dao = new AccountDAO();

    public boolean deposit(int accNo, double amount) {
        if (amount <= 0) return false;
        return dao.deposit(accNo, amount);
    }

    public boolean withdraw(int accNo, double amount) {
        if (amount <= 0) return false;
        return dao.withdraw(accNo, amount);
    }

	public boolean transfer(int fromAcc, int toAcc, double amount) {
	    if (fromAcc == toAcc || amount <= 0) {
	        return false;
	    }

	    return dao.transfer(fromAcc, toAcc, amount);

	}
}