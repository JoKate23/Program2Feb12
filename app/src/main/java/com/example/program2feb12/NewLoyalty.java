package com.example.program2feb12;

public class NewLoyalty
{
    private String loyaltyName;
    private String bankAffiliation;
    private int currentBalance;

    public NewLoyalty(String loyaltyName, String bankAffiliation, int currentBalance)
    {
        this.loyaltyName = loyaltyName;
        this.bankAffiliation = bankAffiliation;
        this.currentBalance = currentBalance;
    }

    public void displayLoyalty()
    {
        System.out.println(this.loyaltyName + " " + this.bankAffiliation + " " + this.currentBalance + " ");
    }
}
