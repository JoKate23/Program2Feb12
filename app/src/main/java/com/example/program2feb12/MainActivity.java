package com.example.program2feb12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
