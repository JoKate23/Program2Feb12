package com.example.program2feb12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView cardListView, loyaltyListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinkedList ll = new LinkedList();
        for(int i = 0; i < 10; i++)
        {
            ll.addEnd(i);
        }

        for(int i = 0; i < ll.length(); i++)
        {
            System.out.println("LL: " + ll.getAtIndex(i));
        }

        for(int i = 0; i < 1000; i++)
        {
            Core.theLoyaltiesStrings[i] = "N/A";
            Core.theCardsStrings[i] = "N/A";
            Core.theCards[i] = new NewCard();
        }

        this.cardListView = (ListView)this.findViewById(R.id.cardListView);
        this.loyaltyListView = (ListView)this.findViewById(R.id.loyaltyListView);
        Core.ccCustomAdapter = new CreditCardArrayAdapterForLinkedLists(this, R.layout.custom_credit_card_row, Core.theCardsLL);
        Core.lpAdapter = new ArrayAdapter(this, R.layout.loyalty_listview_row, Core.theLoyaltiesStrings);

        this.cardListView.setAdapter(Core.ccCustomAdapter);
        this.loyaltyListView.setAdapter(Core.lpAdapter);


    }


    public void onAddCardButtonPressed(View v)
    {
        Intent i = new Intent(this, NewCardPageActivity.class);
        this.startActivity(i);
    }

    public void onAddLoyaltyButtonPressed(View v)
    {
        Intent j = new Intent(this, NewLoyaltyPageActivity.class);
        this.startActivity(j);
    }




}