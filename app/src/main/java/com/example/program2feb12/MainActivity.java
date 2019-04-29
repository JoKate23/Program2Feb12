package com.example.program2feb12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import static com.example.program2feb12.Core.database;

public class MainActivity extends AppCompatActivity
{
    private ListView cardListView, loyaltyListView;
    private MainActivity myCurrentActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BinaryTree bt = new BinaryTree();
        bt.addValue(5);
        bt.addValue(2);
        bt.addValue(1);
        bt.addValue(7);
        bt.addValue(8);
        bt.addValue(3);
        bt.visitInOrder();;
        bt.visitPostOrder();
        bt.visitPreOrder();

        this.myCurrentActivity = this;

        Core.database = FirebaseDatabase.getInstance();
        Core.creditCardRef = database.getReference("creditCards");
        Core.loyaltyProgramRef = database.getReference("loyaltyPrograms");

        this.cardListView = (ListView)this.findViewById(R.id.cardListView);
        this.loyaltyListView = (ListView)this.findViewById(R.id.loyaltyListView);

        Core.ccCustomAdapter = new CreditCardArrayAdapterForLinkedLists(this, R.layout.custom_credit_card_row, Core.theCardsLL);
        Core.lpCustomAdapter = new LoyaltyProgramArrayAdapterForLinkedLists(this, R.layout.custom_loyalty_program_row, Core.theLoyaltiesLL);

        this.cardListView.setAdapter(Core.ccCustomAdapter);
        this.loyaltyListView.setAdapter(Core.lpCustomAdapter);




        this.cardListView.setClickable(true);
        this.cardListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                NewCard selectedCard = Core.theCardsLL.getAtIndex(position);
                Intent i = new Intent(myCurrentActivity, EditCreditCardActivity.class);
                Core.currentSelectedCard = selectedCard;
                myCurrentActivity.startActivity(i);

            }

        });

        this.loyaltyListView.setClickable(true);
        this.loyaltyListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                NewLoyalty selectedLoyalty = Core.theLoyaltiesLL.getAtIndex(position);
                Intent i = new Intent(myCurrentActivity, EditLoyaltyProgramActivity.class);
                Core.currentSelectedLoyalty = selectedLoyalty;
                myCurrentActivity.startActivity(i);

            }

        });


        //set up listeners for cc and lp

        //asynchronous call (non-blocking call) - Observer Design Pattern
        Core.creditCardRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                System.out.println("****** " + dataSnapshot.toString());
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                //System.out.println("********" + value);
                Core.theCardsLL.removeAll();


                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    //System.out.println("******** " + ds.toString());

                    //de-serialize the card
                    System.out.println("*** Adding value");
                    NewCard tempCC = ds.getValue(NewCard.class);
                    tempCC.setKey(ds.getKey());
                    Core.addCreditCardLocally(tempCC);
                }
                Core.ccCustomAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError error)
            {
                // Failed to read value
                System.out.println("*** " + error.toString());

            }
        });

        // Read from the database
        Core.loyaltyProgramRef.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                System.out.println("****** " + dataSnapshot.toString());
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //String value = dataSnapshot.getValue(String.class);
                Core.theLoyaltiesLL.removeAll();

                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    //tried to insert initial set of loyalty programs
                    //Core.initialLoyaltyPrograms(lp);
                    //de=serialize the card
                    System.out.println("*** Adding value");
                    NewLoyalty tempLP = ds.getValue(NewLoyalty.class);
                    tempLP.setKey(ds.getKey());
                    Core.addLoyaltyProgramLocally(tempLP);
                }
                Core.lpCustomAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error)
            {
                // Failed to read value
                System.out.println("*** " + error.toString());

            }
        });


    }


    public void onAirportListButtonPressed(View v)
    {
        Intent i = new Intent(this, AirportListActivity.class);
        this.startActivity(i);
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