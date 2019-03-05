package com.example.program2feb12;

import java.io.Serializable;

public class NewCard implements Serializable
{
    public String newCardName;
    public String startDate;
    public int minimumSpend;
    public int rewardPoints;

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

    public String getNewCardName()
    {
        return newCardName;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public int getMinimumSpend()
    {
        return minimumSpend;
    }

    public int getRewardPoints()
    {
        return rewardPoints;
    }


    public String toString()
    {
        return this.newCardName + " " + this.startDate + " " + this.minimumSpend + " " + this.rewardPoints + " ";
    }

    public void displayNewCard()
    {
        System.out.println(this.newCardName + " " + this.startDate + " " + this.minimumSpend + " " + this.rewardPoints + " ");
    }
}
