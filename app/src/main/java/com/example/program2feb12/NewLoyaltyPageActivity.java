package com.example.program2feb12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewLoyaltyPageActivity extends AppCompatActivity
{
    private EditText loyaltyNameET, bankAffiliationET, currentBalanceET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_loyalty_page);

        this.loyaltyNameET = (EditText)this.findViewById(R.id.loyaltyNameET);
        this.bankAffiliationET = (EditText)this.findViewById(R.id.bankAffiliationET);
        this.currentBalanceET = (EditText)this.findViewById(R.id.currentBalanceET);
    }

    public void onSubmitNewLoyaltyButtonPressed(View v)
    {
        String loyaltyName = this.loyaltyNameET.getText().toString();
        String bankAffiliation = this.bankAffiliationET.getText().toString();
        int currentBalance = Integer.parseInt(this.currentBalanceET.getText().toString());

        NewLoyalty lp = new NewLoyalty(loyaltyName, bankAffiliation, currentBalance);
        lp.displayLoyalty();

        Core.addLoyaltyProgram(lp);
        this.finish();

        //my attempt at Program#3
        //Core.currLoyalty = lp;
        //Core.loyaltyList.add(lp);
        //Core.stringLoyaltyList.add(loyaltyName + " " + bankAffiliation + " " + currentBalance);
        //Core.listAdapter.notifyDataSetChanged();

        //takes back to main activity page after submission
        //takes back without displaying
        //finish();

        //displays and takes to main activity - MY ATTEMPT
        //Intent i = new Intent(this, MainActivity.class);
        //this.startActivity(i);


    }
}
