package com.example.program2feb12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //private ListView cardListView;
    //private ArrayAdapter<String> listAdapter;

    //private ListView loyaltyListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this.cardListView = (ListView)this.findViewById(R.id.cardListView);
        Core.cardListView = (ListView)this.findViewById(R.id.cardListView);
        Core.loyaltyListView = (ListView)this.findViewById(R.id.loyaltyListView);


        //for(int i = 0; i < Core.theCardStrings.length; i++)
        //{
        //    Core.theCardStrings[i] = "Unknown Card";
        //}
        //for(int i = 0; i < 2; i++)
        //{
          //  NewCard cc = new NewCard("newCardName" + i,"startDate" + i, i, i);
          //  Core.theCards[Core.numNewCard] = cc;
          //  Core.theCardStrings[Core.numNewCard] = cc.toString();
          //  Core.numNewCard++;
        //}

        //example in class uses "Core.theCardStrings" as last entry under this.listAdapter in ()
        //use "creditCards" string as last entry to hardcode cards in listview
        //String[] creditCards = {"Discover", "Chase"};
        //this.listAdapter = new ArrayAdapter<String>(this, R.layout.creditcard_listview_row2, Core.theCardStrings);
        //this.cardListView.setAdapter(this.listAdapter);

        Core.listAdapter = new ArrayAdapter<String>(this,R.layout.creditcard_listview_row2, Core.stringCardList);
        Core.cardListView.setAdapter(Core.listAdapter);



        //this.loyaltyListView = (ListView)this.findViewById(R.id.loyaltyListView);
        //for(int j = 0; j < Core.theLoyaltyStrings.length; j++)
        //{
         //   Core.theLoyaltyStrings[j] = "Unknown Loyalty";
        //}
        //for(int j = 0; j < 2; j++)
        //{
         //   NewLoyalty lc =  new NewLoyalty("loyaltyName" + j, "bankAffiliation" + j, j);
         //   Core.theLoyalties[Core.numNewLoyalty] = lc;
         //   Core.theLoyaltyStrings[Core.numNewLoyalty] = lc.toString();
         //   Core.numNewLoyalty++;
        //}


        //example in class uses "Core.theLoyaltyStrings" as last entry under this.listAdapter in ()
        //use "loyaltyCards" string as last entry to hardcode loyalties in listview
        //String[] loyaltyCards = {"CashBack", "ChaseRewards"};
        //this.listAdapter = new ArrayAdapter<String>(this, R.layout.loyalty_listview_row, Core.theLoyaltyStrings);
        //this.loyaltyListView.setAdapter(this.listAdapter);

        Core.listAdapter = new ArrayAdapter<String>(this, R.layout.loyalty_listview_row, Core.stringLoyaltyList);
        Core.loyaltyListView.setAdapter(Core.listAdapter);




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