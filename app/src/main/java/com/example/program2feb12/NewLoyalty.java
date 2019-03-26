package com.example.program2feb12;

import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;

public class NewLoyalty implements Serializable
{
    public String loyaltyName;
    public String bankAffiliation;
    public int currentBalance;
    private String key;
    private DatabaseReference ref;


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

    public void save(String loyaltyName, String bankAffiliation, int currentBalance)
    {
        this.loyaltyName = loyaltyName;
        this.bankAffiliation = bankAffiliation;
        this.currentBalance = currentBalance;
        this.save();
    }

    public void save()
    {
        //save to the database the current state of this Loyalty Program
        this.ref.setValue(this);
    }

    public void delete()
    {
        this.ref.removeValue();
    }

    public void setKey(String key)
    {
        this.key = key;
        this.ref = Core.loyaltyProgramRef.child(this.key);
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
