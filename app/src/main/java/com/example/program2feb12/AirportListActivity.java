package com.example.program2feb12;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class AirportListActivity extends AppCompatActivity
{
    private ListView airportLV;
    private LinkedList<String> theAirportStrings = new LinkedList<String>();
    private LinkedList<Airport> theAirports = new LinkedList<Airport>();
    private ArrayAdapter<String> aa;
    private EditText filterET;
    private AirportListActivity mycontext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_list);

        this.filterET = this.findViewById(R.id.filterET);
        this.airportLV = this.findViewById(R.id.airportsLV);
        //another row is textview for holding string - create from Litman code
        aa = new ArrayAdapter<String>(this, R.layout.another_row, this.theAirportStrings);
        this.airportLV.setAdapter(aa);
        this.mycontext = this;


        //trying to make it so when the item in the airport LV is clicked, user moves to another page with flight information
        //not sure what's going wrong here... may have mixed up LV and LL
        this.airportLV.setClickable(true);
        this.airportLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                String selectedAirport = (String)airportLV.getItemAtPosition(position);
                Intent i = new Intent(mycontext, FlightActivity.class);
                Core.currentSelectedAirport = selectedAirport;
                mycontext.startActivity(i);
            }
        });


        DatabaseReference ref = Core.database.getReference("world_airports");
        //single time does not do over and over again
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Airport temp;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    temp = ds.getValue(Airport.class);
                    theAirports.add(temp);
                    theAirportStrings.add(temp.toString());
                }
                aa.notifyDataSetChanged();
                //System.out.println("*** " + dataSnapshot.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void onFilterButtonPressed(View v)
    {
        String filterString = this.filterET.getText().toString();
        this.theAirportStrings.clear();
        for(Airport a : this.theAirports)
        {
            if(a.filterApplies(filterString))
            {
                this.theAirportStrings.add(a.toString());
            }
        }
        this.aa.notifyDataSetChanged();

    }





}
