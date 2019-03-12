package com.example.program2feb12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditCreditCardActivity extends AppCompatActivity
{
    private EditText newCardNameET, newCardStartDateET, newCardMinimumSpendET, newCardRewardPointsET;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_credit_card);


        //Core.currentSelectedCard.displayNewCard();

        this.newCardNameET = (EditText)this.findViewById(R.id.newCardNameET);
        this.newCardStartDateET = (EditText)this.findViewById(R.id.startDateET);
        this.newCardMinimumSpendET = (EditText)this.findViewById(R.id.minimumSpendET);
        this.newCardRewardPointsET = (EditText)this.findViewById(R.id.rewardPointsET);


        this.newCardNameET.setText(Core.currentSelectedCard.newCardName);
        this.newCardStartDateET.setText(Core.currentSelectedCard.startDate);
        //adding empty string to end will produce string answer
        this.newCardMinimumSpendET.setText(Core.currentSelectedCard.minimumSpend + "");
        this.newCardRewardPointsET.setText(Core.currentSelectedCard.rewardPoints + "");


    }

    public void onDeleteButtonPressed(View v)
    {
        Core.currentSelectedCard.delete();
        this.finish();
    }

    public void onUpdateButtonPressed(View v)
    {

        //Core.currentSelectedCard.delete();

        String newCardName = this.newCardNameET.getText().toString();
        String newCardStartDate = this.newCardStartDateET.getText().toString();
        int newCardMinimumSpend = Integer.parseInt(this.newCardMinimumSpendET.getText().toString());
        int newCardRewardPoints = Integer.parseInt(this.newCardRewardPointsET.getText().toString());

        //NewCard ucc = new NewCard(newCardName, newCardStartDate, newCardMinimumSpend, newCardRewardPoints);
        //Core.addCreditCardToFirebase(ucc);
        //this.finish();

    }

   // NewCard cc = new NewCard(newCardName, startDate, minimumSpend, rewardPoints);
    //cc.displayNewCard();


}
