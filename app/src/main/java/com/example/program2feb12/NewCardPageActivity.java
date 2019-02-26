package com.example.program2feb12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class NewCardPageActivity extends AppCompatActivity {

    //tried adding these in order to add the // part at the bottom of this page of code
    //did not work but kept just in case

    //private ListView cardListView;
    //private ArrayAdapter<String> listAdapter;
    //private ListView loyaltyListView;
    //int clickCounter=0;

    private EditText newCardNameET, startDateET, minimumSpendET, rewardPointsET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_card_page);

        this.newCardNameET = (EditText)this.findViewById(R.id.newCardNameET);
        this.startDateET = (EditText)this.findViewById(R.id.startDateET);
        this.minimumSpendET = (EditText)this.findViewById(R.id.minimumSpendET);
        this.rewardPointsET = (EditText)this.findViewById(R.id.rewardPointsET);

    }

    public void onSubmitNewCardButtonPressed(View v)
    {
        String newCardName = this.newCardNameET.getText().toString();
        String startDate = this.startDateET.getText().toString();
        int minimumSpend = Integer.parseInt(this.minimumSpendET.getText().toString());
        int rewardPoints = Integer.parseInt(this.rewardPointsET.getText().toString());

        NewCard cc = new NewCard(newCardName, startDate, minimumSpend, rewardPoints);
        cc.displayNewCard();

        Core.addCreditCard(cc);
        this.finish();

        //my attempt at Program#3
        //Core.currCreditCard = cc;
        //Core.cardList.add(cc);
        //Core.stringCardList.add(newCardName + " " + startDate + " " + minimumSpend + " " + rewardPoints);
        //Core.listAdapter.notifyDataSetChanged();

        //takes back to main activity page after submission
        //does not display - just returns to main activity page
        //finish();


        //both displays information and returns to main activity page
        //my attempt at taking back to home screen
        //Intent i = new Intent(this, MainActivity.class);
        //this.startActivity(i);


        //tried applying this here - app crashed when submit button was pressed
        //listAdapter.notifyDataSetChanged();

    }




}