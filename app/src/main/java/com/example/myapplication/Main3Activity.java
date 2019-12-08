package com.example.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main3Activity extends AppCompatActivity{
    TextView out1, out2, out3, out4,out5;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);

        out1 = (TextView) findViewById(R.id.textView);
        //  out2 = (TextView) findViewById(R.id.textView2);
        //out3 = (TextView) findViewById(R.id.textView3);
        //out4 = (TextView) findViewById(R.id.textView4);
        //out5 = (TextView) findViewById(R.id.textView5);
        //out6 = (TextView) findViewById(R.id.textView6);
        //out7 = (TextView) findViewById(R.id.textView7);
        new MyTask().execute();
    }
    private class MyTask extends AsyncTask<Void, Void, Void>{
        String o1;//o2,o3,o4,o5,o6,o7;

        protected Void doInBackground(Void... params){

            URL url = null;

            Intent myNewIntent = getIntent();

            int InfoReceivedId = myNewIntent.getIntExtra("ID",99);
           // int InfoReceivedid = myNewIntent.getIntExtra("id");
            String InfoReceivedfname = myNewIntent.getStringExtra("fname");
            String InfoReceivedlname = myNewIntent.getStringExtra("lname");
            int InfoReceivedphone = myNewIntent.getIntExtra("phone",99);
            String InfoReceivedaddress = myNewIntent.getStringExtra("address");



            try{

                url = new URL("http://192.168.5.15:8080/Teacher_evaluation/cegepgim/mobile/Studentregisteration&" +InfoReceivedId +"&" +InfoReceivedfname +"&" +InfoReceivedlname +"&" +InfoReceivedphone +"&" + InfoReceivedaddress);
                // url = new URL("http://192.168.56.1:8080/New_project/webresources/mobile/Allcategories" +InfoReceivedId);

                HttpURLConnection client = null;

                client = (HttpURLConnection) url.openConnection();

                client.setRequestMethod("GET");

                int responseCode = client.getResponseCode();

                System.out.println("\n sending 'GET' request to URL : " + url);

                System.out.println("Response code : " + responseCode);

                InputStreamReader myInput = new InputStreamReader(client.getInputStream());

                BufferedReader in = new BufferedReader(myInput);
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null){
                    response.append(inputLine);
                }
                in.close();

                System.out.println(response.toString());

                JSONObject obj = new JSONObject(response.toString());
                o1 = ""+obj.getString("message");
                //  o2 = ""+obj.getString("TYPE_C");
                // o3 = ""+obj.getInt("net_wt");
                //o4 = ""+obj.getString("TYPE_C");
                //o5 = ""+obj.getInt("i_name");
                //o6 = ""+obj.getString("quantity");
                // o7= ""+obj.getString("N_NAME");

                //  o7 = ""+obj.getInt("quantity");

            }
            catch (MalformedURLException e){
                e.printStackTrace();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            catch(JSONException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            out1.setText(o1);
            // out2.setText(o2);
            // out3.setText(o3);
            //out4.setText(o4);
            //out5.setText(o5);
            //out6.setText(o6);
            //out7.setText(o7);

            super.onPostExecute(result);
        }
    }
}