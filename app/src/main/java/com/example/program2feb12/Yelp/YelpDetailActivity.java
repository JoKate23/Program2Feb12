package com.example.program2feb12.Yelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.program2feb12.Airport;
import com.example.program2feb12.AirportCodeCache;
import com.example.program2feb12.AirportDetailActivity;
import com.example.program2feb12.AirportListActivity;
import com.example.program2feb12.Core;
import com.example.program2feb12.EditCreditCardActivity;
import com.example.program2feb12.NewCard;
import com.example.program2feb12.R;

import java.util.LinkedList;

public class YelpDetailActivity extends AppCompatActivity {

    private ListView yelpLV;
    private TextView yelpCityTV;
    private LinkedList<String> yelpStrings = new LinkedList<String>();
    private LinkedList<String> ll;
    private ArrayAdapter<String> aa;
    private YelpDetailActivity myself;

    private String name;
    private String url;
    private String rating;
    private String review_count;
    private String display_address;
    private String display_phone;

    private String airportCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yelp_detail);

        this.myself = this;
        this.yelpCityTV = this.findViewById(R.id.yelpCityTV);
        String location = Core.currTree.payload.city;
        this.yelpLV = this.findViewById(R.id.yelpLV);

        this.ll = new LinkedList<String>();
        this.aa = new ArrayAdapter<String>(this, R.layout.another_row, ll);
        this.yelpLV.setAdapter(aa);

        this.yelpLV.setClickable(true);
        this.yelpLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id) {

                Intent i = new Intent(myself, YelpDetailActivity.class);
                i.putExtra("name", name);
                i.putExtra("url", url);
                i.putExtra("rating", rating);
                i.putExtra("review_count", review_count);
                i.putExtra("display_address", display_address);
                i.putExtra("display_phone", display_phone);
                myself.startActivity(i);

            }

        });

        name = this.getIntent().getStringExtra("name");
        url = this.getIntent().getStringExtra("url");
        rating = this.getIntent().getStringExtra("rating");
        review_count = this.getIntent().getStringExtra("review_ount");
        display_address = this.getIntent().getStringExtra("display_address");
        display_phone = this.getIntent().getStringExtra("display_phone");


        YelpAPI yy = new YelpAPI(airportCode);
        yy.setPriority(Thread.MAX_PRIORITY);
        yy.start();

    }
}
