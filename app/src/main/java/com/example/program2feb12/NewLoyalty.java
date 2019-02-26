package com.example.program2feb12;

public class NewLoyalty
{
    private String loyaltyName;
    private String bankAffiliation;
    private int currentBalance;

    public NewLoyalty(String loyaltyName, String bankAffiliation)
    {
        this.loyaltyName = loyaltyName;
        this.bankAffiliation = bankAffiliation;
        this.currentBalance = 0;
    }

    public NewLoyalty(String loyaltyName, String bankAffiliation, int currentBalance)
    {
        this(loyaltyName, bankAffiliation);
        this.currentBalance = currentBalance;
    }


    public String getLoyaltyName()
    {
        return loyaltyName;
    }

    public String getBankAffiliation()
    {
        return bankAffiliation;
    }

    public int getCurrentBalance()
    {
        return currentBalance;
    }

    public String toString()
    {
        return this.loyaltyName + " " + this.bankAffiliation + " " + this.currentBalance + " ";
    }

    public void displayLoyalty()
    {
        System.out.println(this.loyaltyName + " " + this.bankAffiliation + " " + this.currentBalance + " ");
    }


}
