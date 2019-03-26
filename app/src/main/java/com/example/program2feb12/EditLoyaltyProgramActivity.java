package com.example.program2feb12;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditLoyaltyProgramActivity extends AppCompatActivity
{

    private EditText loyaltyProgramNameET, loyaltyProgramBankAffiliationET, loyaltyProgramCurrentBalanceET;
    private EditLoyaltyProgramActivity myself;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_loyalty_program);

        this.myself = this;

        this.loyaltyProgramNameET = (EditText)this.findViewById(R.id.loyaltyNameET);
        this.loyaltyProgramBankAffiliationET = (EditText)this.findViewById(R.id.bankAffiliationET);
        this.loyaltyProgramCurrentBalanceET = (EditText)this.findViewById(R.id.currentBalanceET);

        this.loyaltyProgramNameET.setText(Core.currentSelectedLoyalty.loyaltyName);
        this.loyaltyProgramBankAffiliationET.setText(Core.currentSelectedLoyalty.bankAffiliation);
        this.loyaltyProgramCurrentBalanceET.setText(Core.currentSelectedLoyalty.currentBalance + "");


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
                Core.currentSelectedLoyalty.delete();
                myself.finish();

            }
        });

        dialog.setNeutralButton("Huh?", null);
        dialog.setNegativeButton("No", null);
        dialog.show();

        Core.currentSelectedLoyalty.delete();
        this.finish();
    }

    public void onUpdateButtonPressed(View v)
    {

        //Core.currentSelectedLoyalty.delete();

        String loyaltyName = this.loyaltyProgramNameET.getText().toString();
        String loyaltyBankAffiliation = this.loyaltyProgramBankAffiliationET.getText().toString();
        int loyaltyCurrentBalance = Integer.parseInt(this.loyaltyProgramCurrentBalanceET.getText().toString());

        //NewLoyalty ulp = new NewLoyalty(loyaltyName, loyaltyBankAffiliation, loyaltyCurrentBalance);
        //Core.addLoyaltyProgramToFirebase(ulp);
        //this.finish();

        Core.currentSelectedLoyalty.loyaltyName = loyaltyName;
        Core.currentSelectedLoyalty.bankAffiliation = loyaltyBankAffiliation;
        Core.currentSelectedLoyalty.currentBalance =  loyaltyCurrentBalance;
        Core.currentSelectedLoyalty.save();
        this.finish();


    }

   // NewLoyalty lp = new NewLoyalty(loyaltyName, bankAffiliation, currentBalance);
    //lp.displayLoyalty();


}
