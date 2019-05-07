package com.example.program2feb12.Yelp;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.program2feb12.AirportDestinationThread;
import com.example.program2feb12.Core;
import com.example.program2feb12.ItineraryStackNode;
import com.example.program2feb12.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

public class YelpAPI extends Thread
{

    private String name;
    private String url;
    private String rating;
    private String review_count;
    private String display_address;
    private String display_phone;
    private String airportCode;

    private YelpAPI myself;

    public YelpAPI()
    {
        this.name = name;
        this.url = url;
        this.rating = rating;
        this.review_count = review_count;
        this.display_address = display_address;
        this.display_phone = display_phone;
    }

    public YelpAPI(String airportCode)
    {
        this.airportCode = airportCode;
        this.myself = this;
    }
    public void run()
    {

        try
        {

            //hardcoded for MKE airport
            //URL airportURL = new URL("https://api.yelp.com/v3/businesses/search?location=Milwaukee, WI&categories=restaurants");

            //for general airports
            URL airportURL = new URL("https://api.yelp.com/v3/businesses/search?location=" + this.airportCode + "&categories=restaurants");

            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            conn.setRequestProperty("Authorization", "kJRamlc1X41h_jk4aRoYXqYoCtc7Jyn0lMslxdalgad3rniHhn20oYOPBAUKvHWwIFz6uCBTYr9Cs5KVcXu3j3yQb6m5Lw7_4ARNsMv11WEsnzWzNYq-zFDBSIrQXHYx");
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            input.close();
            System.out.println("*** DATA: " + data);
            JSONObject obj = new JSONObject(data);
            JSONArray businesses = obj.getJSONArray("businesses");
            for(int i = 0; i < businesses.length(); i++)
            {
                String name = businesses.getJSONObject(i).getString("name");
                System.out.println("*** " + name);
            }

        }
        catch(Exception e)
        {
            System.out.println("*** " + e.toString());
        }




    }

    public String toString()
    {
        return this.name + " | " + this.url + " | " + this.rating + " | " + this.review_count + " | " + this.display_address + " | " + this.display_phone;
    }



    public void display()
    {
        System.out.println("*** " + this.name + "\t" + this.url + "\t" + this.rating + "\t" + this.review_count + "\t" + this.display_address + "\t" + this.display_phone);
    }


}
