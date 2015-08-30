package com.example.sathya.anroidcontrol;

import android.app.Activity;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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


        String url= "http://10.130.95.109/andriod/getstatus.php";
        //String url= "http://www.remoteelectric.t15.org/getstatus.php";
        String resp="";
        HttpURLConnection conn = null;
        try {

            URL call = new URL(url);
            conn = (HttpURLConnection) call.openConnection();

            conn.setConnectTimeout(5000);
            Toast.makeText(getApplicationContext(), "connected", Toast.LENGTH_SHORT).show();
            BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
           String  s;
            while((s=bf.readLine())!= null){
                resp+=s;
            }
            Toast.makeText(getApplicationContext(),resp,Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "NOT connected :"+e,Toast.LENGTH_LONG).show();
        }




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
