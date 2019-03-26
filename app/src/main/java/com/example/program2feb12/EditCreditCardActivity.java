package com.example.program2feb12;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditCreditCardActivity extends AppCompatActivity
{
    private EditText newCardNameET, newCardStartDateET, newCardMinimumSpendET, newCardRewardPointsET;

    private EditCreditCardActivity myself;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_credit_card);


        this.myself = this;


        //Core.currentSelectedCard.displayNewCard();

        this.newCardNameET = (EditText)this.findViewById(R.id.newCardNameET);
        this.newCardStartDateET = (EditText)this.findViewById(R.id.startDateET);
        this.newCardMinimumSpendET = (EditText)this.findViewById(R.id.minimumSpendET);
        this.newCardRewardPointsET = (EditText)this.findViewById(R.id.rewardPointsET);


        this.newCardNameET.setText(Core.currentSelectedCard.newCardName);
        this.newCardStartDateET.setText(Core.currentSelectedCard.startDate);
        //this.newCardStartDateET.setText(Core.currentSelectedCard.startDate + "");
        //adding empty string to end will produce string answer
        this.newCardMinimumSpendET.setText(Core.currentSelectedCard.minimumSpend + "");
        this.newCardRewardPointsET.setText(Core.currentSelectedCard.rewardPoints + "");


    }

    public void onDeleteButtonPressed(View v)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Are you sure?");
        dialog.setTitle("Warning!!!!");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                    Core.currentSelectedCard.delete();
                    myself.finish();

            }
        });

        dialog.setNeutralButton("Huh?", null);
        dialog.setNegativeButton("No", null);
        dialog.show();

        Core.currentSelectedCard.delete();
        this.finish();
    }

    public void onUpdateButtonPressed(View v)
    {
        //Core.currentSelectedCard.delete();


        //technically don't need lines; BUT "Core.currentSelectedCard" lines after = go red when taken out
        String newCardName = this.newCardNameET.getText().toString();
        String newCardStartDate = this.newCardStartDateET.getText().toString();
        //int newCardStartDate = Integer.parseInt(this.newCardStartDateET.getText().toString());
        int newCardMinimumSpend = Integer.parseInt(this.newCardMinimumSpendET.getText().toString());
        int newCardRewardPoints = Integer.parseInt(this.newCardRewardPointsET.getText().toString());

        //NewCard ucc = new NewCard(newCardName, newCardStartDate, newCardMinimumSpend, newCardRewardPoints);
        //Core.addCreditCardToFirebase(ucc);
        //this.finish();


        //can write as one line - "Core.currentSelectedCard.save(this.
        //example in Litman code for EDIT LP
        Core.currentSelectedCard.newCardName = newCardName;
        Core.currentSelectedCard.startDate = newCardStartDate;
        Core.currentSelectedCard.minimumSpend =  newCardMinimumSpend;
        Core.currentSelectedCard.rewardPoints = newCardRewardPoints;
        Core.currentSelectedCard.save();
        this.finish();


    }

   // NewCard cc = new NewCard(newCardName, startDate, minimumSpend, rewardPoints);
    //cc.displayNewCard();


}
