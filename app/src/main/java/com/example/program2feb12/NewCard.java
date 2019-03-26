package com.example.program2feb12;

import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;

public class NewCard implements Serializable
{
    public String newCardName;
    public String startDate;
    public int minimumSpend;
    public int rewardPoints;
    private String key;
    private DatabaseReference ref;

    public NewCard(String newCardName, String startDate, int minimumSpend, int rewardPoints)
    {
        this.newCardName = newCardName;
        this.startDate = startDate;
        this.minimumSpend = minimumSpend;
        this.rewardPoints = rewardPoints;
    }

    //no argument constructor required for de-serialization
    public NewCard()
    {
        //this.newCardName = "Name";
        //this.startDate = "Start Date";
        //this.minimumSpend = -1;
        //this.rewardPoints = -1;

    }

    public void setKey(String key)
    {
        this.key = key;
        this.ref = Core.creditCardRef.child(this.key);
    }

    public void save()
    {
        this.ref.setValue(this);
    }

    public void delete()
    {
        this.ref.removeValue();
    }


    //no longer need "getters"


    public String toString()
    {
        return this.newCardName + " " + this.startDate + " " + this.minimumSpend + " " + this.rewardPoints + " ";
    }

    public void displayNewCard()
    {
        System.out.println(this.newCardName + " " + this.startDate + " " + this.minimumSpend + " " + this.rewardPoints + " ");
    }
}
