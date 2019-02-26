package com.example.program2feb12;

public class NewCard
{
    private String newCardName;
    private String startDate;
    private int minimumSpend;
    private int rewardPoints;

    public NewCard(String newCardName, String startDate, int minimumSpend, int rewardPoints)
    {
        this.newCardName = newCardName;
        this.startDate = startDate;
        this.minimumSpend = minimumSpend;
        this.rewardPoints = rewardPoints;
    }

    public NewCard()
    {
        this.newCardName = "Name";
        this.startDate = "Start Date";
        this.minimumSpend = -1;
        this.rewardPoints = -1;

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
