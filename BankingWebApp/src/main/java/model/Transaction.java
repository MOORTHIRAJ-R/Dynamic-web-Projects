package model;

public class Transaction {

    private int txnId;
    private int accountNo;
    private String type;
    private double amount;
    private String date;

    // ✅ GETTERS

    public int getTxnId() {
        return txnId;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    // ✅ SETTERS

    public void setTxnId(int txnId) {
        this.txnId = txnId;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }
}