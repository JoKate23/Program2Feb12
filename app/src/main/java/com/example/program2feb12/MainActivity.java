package com.example.program2feb12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private ListView cardListView, loyaltyListView;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // For Firebase connection
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference creditCardRef = database.getReference("creditCards");
        DatabaseReference loyaltyProgramRef = database.getReference("loyaltyPrograms");






        //**create card and store in firebase (maybe move this to CORE hint hint)
        //final NewCard cc = new NewCard("Chase Sapphire", "1/1/19", 3000, 50000);
        //creditCardRef.push().setValue(cc);

        //myRef.setValue("Hello, World!");
        //myRef2.setValue("LOL");

        //final NewLoyalty lp = new NewLoyalty("Citi Rewards", "Bank", 10000);



        //initial sets of cards and loyalties
        //won't show up in logcat - tried making strings with *** to double check, did not show

        NewCard cc1 = new NewCard("Chase Sapphire", "1/1/19", 3000, 50000);
        NewCard cc2 = new NewCard("Citi Bank", "11/08/18", 4000, 30000);
        NewCard cc3 = new NewCard("Discover", "02/22/19", 5000, 80000);
        creditCardRef.push().setValue(cc1);
        creditCardRef.push().setValue(cc2);
        creditCardRef.push().setValue(cc3);

        NewLoyalty lp1 = new NewLoyalty("Chase Rewards", "Bank1", 10000);
        NewLoyalty lp2 = new NewLoyalty("Citi Rewards", "Bank2", 15000);
        NewLoyalty lp3 = new NewLoyalty("CashBack", "Bank3", 30000);
        loyaltyProgramRef.push().setValue(lp1);
        loyaltyProgramRef.push().setValue(lp2);
        loyaltyProgramRef.push().setValue(lp3);




        //set up listeners for cc and lp

        //asynchronous call (non-blocking call) - Observer Design Pattern
        creditCardRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                //System.out.println("********" + value);
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    //System.out.println("******** " + ds.toString());

                    //tried to insert initial set of credit cards
                    //Core.initialCreditCards(cc);
                    //de-serialize the card
                    NewCard tempCC = ds.getValue(NewCard.class);
                    Core.addCreditCard(tempCC);
                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

        // Read from the database
        loyaltyProgramRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);

                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    //tried to insert initial set of loyalty programs
                    //Core.initialLoyaltyPrograms(lp);
                    //de=serialize the card
                    NewLoyalty tempLP = ds.getValue(NewLoyalty.class);
                    Core.addLoyaltyProgram(tempLP);
                }
            }

            @Override
            public void onCancelled(DatabaseError error)
            {
                // Failed to read value

            }
        });

        this.cardListView = (ListView)this.findViewById(R.id.cardListView);
        this.loyaltyListView = (ListView)this.findViewById(R.id.loyaltyListView);

        Core.ccCustomAdapter = new CreditCardArrayAdapterForLinkedLists(this, R.layout.custom_credit_card_row, Core.theCardsLL);
        Core.lpCustomAdapter = new LoyaltyProgramArrayAdapterForLinkedLists(this, R.layout.loyalty_listview_row, Core.theLoyaltiesLL);

        this.cardListView.setAdapter(Core.ccCustomAdapter);
        this.loyaltyListView.setAdapter(Core.lpCustomAdapter);



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