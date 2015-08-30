package com.example.sathya.anroidcontrol;

import android.app.Activity;
import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        String url= "http://10.67.102.213/andriod/getstatus.php";
        //String url= "http://www.remoteelectric.t15.org/getstatus.php";
        HttpURLConnection conn = null;
        String res="";
        try {

            URL call = new URL(url);
            conn = (HttpURLConnection) call.openConnection();
            conn.setConnectTimeout(10000);
            BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String  s="";
            while((s=bf.readLine())!= null){
                res+=s;
            }
            Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
            String[] resp=res.split("`");
            if(resp[0].equals("success")){
                if(resp[1].equals("1")){
                    findViewById(R.id.button).setBackgroundColor(Color.GREEN);
                }else{
                    findViewById(R.id.button).setBackgroundColor(Color.RED);
                }
                if(resp[2].equals("1")){
                    findViewById(R.id.button2).setBackgroundColor(Color.GREEN);
                }else{
                    findViewById(R.id.button2).setBackgroundColor(Color.RED);
                }
                if(resp[3].equals("1")){
                    findViewById(R.id.button3).setBackgroundColor(Color.GREEN);
                }else{
                    findViewById(R.id.button3).setBackgroundColor(Color.RED);
                }
                if(resp[4].equals("1")){
                    findViewById(R.id.button4).setBackgroundColor(Color.GREEN);
                }else{
                    findViewById(R.id.button4).setBackgroundColor(Color.RED);
                }
            }
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "NOT connected :"+e,Toast.LENGTH_LONG).show();
            findViewById(R.id.button).setBackgroundColor(Color.BLUE);
            findViewById(R.id.button2).setBackgroundColor(Color.BLUE);
            findViewById(R.id.button3).setBackgroundColor(Color.BLUE);
            findViewById(R.id.button4).setBackgroundColor(Color.BLUE);
        }
        Button b= (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  URL call=new URL()
            }
        });



     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
