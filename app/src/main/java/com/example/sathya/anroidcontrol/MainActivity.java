package com.example.sathya.anroidcontrol;

import android.app.Activity;
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

        //String url= "http://localhost/andriod/getstatus.php";
        String url= "http://www.remoteelectric.t15.org/getstatus.php";
        String resp="";
        try {

            URL call = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) call.openConnection();
            conn.setConnectTimeout(10000);
            System.out.println("executing request...");
            Toast.makeText(getApplicationContext(),"connected",Toast.LENGTH_SHORT).show();
            BufferedReader bf=null;
            InputStreamReader ips=null;
            ips=new InputStreamReader(conn.getInputStream());
            Toast.makeText(getApplicationContext(),"Stream  connected",Toast.LENGTH_SHORT).show();
            bf=new BufferedReader(ips);
            Toast.makeText(getApplicationContext(),"bf connected....",Toast.LENGTH_SHORT).show();
            String s="";
            while((s=bf.readLine()) != null){
                resp=resp+s;
            }


        }

        catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(),"NOT connected : ",Toast.LENGTH_LONG).show();
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
