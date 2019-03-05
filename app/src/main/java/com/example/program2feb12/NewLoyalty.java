package com.example.program2feb12;

import java.io.Serializable;

public class NewLoyalty implements Serializable
{
    public String loyaltyName;
    public String bankAffiliation;
    public int currentBalance;

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

    //no argument constructor required for de-serialization
    public NewLoyalty()
    {

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
