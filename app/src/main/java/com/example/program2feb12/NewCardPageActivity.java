package com.example.program2feb12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewCardPageActivity extends AppCompatActivity
{

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
        //cc.displayNewCard();

        Core.addCreditCardToFirebase(cc);
        this.finish();



    }




}