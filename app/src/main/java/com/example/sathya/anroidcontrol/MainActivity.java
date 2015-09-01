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
    String res="",pin="",state="",url="";
    String ip="http://www.remoteelectric.t15.org/";
    int value1=1,value2=1,value3=1,value4=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        //url= "http://10.67.102.213/andriod/getstatus.php";
        url= "http://www.remoteelectric.t15.org/getstatus.php";
        HttpURLConnection conn = null;

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
                if(resp[1].equals("1")){value1=1;
                    findViewById(R.id.button).setBackgroundColor(Color.GREEN);
                }else{value1=0;
                    findViewById(R.id.button).setBackgroundColor(Color.RED);
                }
                if(resp[2].equals("1")){value2=1;
                    findViewById(R.id.button2).setBackgroundColor(Color.GREEN);
                }else{value2=0;
                    findViewById(R.id.button2).setBackgroundColor(Color.RED);
                }
                if(resp[3].equals("1")){value3=1;
                    findViewById(R.id.button3).setBackgroundColor(Color.GREEN);
                }else{value3=0;
                    findViewById(R.id.button3).setBackgroundColor(Color.RED);
                }
                if(resp[4].equals("1")){value4=1;
                    findViewById(R.id.button4).setBackgroundColor(Color.GREEN);
                }else{value4=0;
                    findViewById(R.id.button4).setBackgroundColor(Color.RED);
                }
            }else{
                Toast.makeText(getApplicationContext(),"Data NOT Received",Toast.LENGTH_SHORT).show();
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
                if(value1 ==1){
                    pin="1";state="0";
                    url=ip+"updatefromandroid.php?pin="+pin+"&state="+state;
                    String response="";
                    try {
                        URL call = new URL(url);
                        HttpURLConnection conn =(HttpURLConnection) call.openConnection();
                        conn.setConnectTimeout(10000);
                        BufferedReader bf=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String s="";
                        while((s=bf.readLine())!=null){
                            response+=s;
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(response.equals("updated")){
                        findViewById(R.id.button).setBackgroundColor(Color.RED);
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
                        value1=0;
                    }else {
                        Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                        findViewById(R.id.button).setBackgroundColor(Color.BLUE);
                    }

                }else{
                    pin="1";state="1";
                    url=ip+"updatefromandroid.php?pin="+pin+"&state="+state;
                    String response="";
                    try {
                        URL call = new URL(url);
                        HttpURLConnection conn =(HttpURLConnection) call.openConnection();
                        conn.setConnectTimeout(10000);
                        BufferedReader bf=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String s="";
                        while((s=bf.readLine())!=null){
                            response+=s;
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(response.equals("updated")){
                        findViewById(R.id.button).setBackgroundColor(Color.GREEN);
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
                        value1=1;
                    }else {
                        Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                        findViewById(R.id.button).setBackgroundColor(Color.BLUE);
                    }
                }
            }
        });

        Button b2= (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value2 ==1){
                    pin="2";state="0";
                    url=ip+"updatefromandroid.php?pin="+pin+"&state="+state;
                    String response="";
                    try {
                        URL call = new URL(url);
                        HttpURLConnection conn =(HttpURLConnection) call.openConnection();
                        conn.setConnectTimeout(10000);
                        BufferedReader bf=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String s="";
                        while((s=bf.readLine())!=null){
                            response+=s;
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(response.equals("updated")){
                        findViewById(R.id.button2).setBackgroundColor(Color.RED);
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
                        value2=0;
                    }else {
                        Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                        findViewById(R.id.button2).setBackgroundColor(Color.BLUE);
                    }

                }else{
                    pin="2";state="1";
                    url=ip+"updatefromandroid.php?pin="+pin+"&state="+state;
                    String response="";
                    try {
                        URL call = new URL(url);
                        HttpURLConnection conn =(HttpURLConnection) call.openConnection();
                        conn.setConnectTimeout(10000);
                        BufferedReader bf=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String s="";
                        while((s=bf.readLine())!=null){
                            response+=s;
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(response.equals("updated")){
                        findViewById(R.id.button2).setBackgroundColor(Color.GREEN);
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
                        value2=1;
                    }else {
                        Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                        findViewById(R.id.button2).setBackgroundColor(Color.BLUE);
                    }
                }
            }
        });

        Button b3= (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value3 ==1){
                    pin="3";state="0";
                    url=ip+"updatefromandroid.php?pin="+pin+"&state="+state;
                    String response="";
                    try {
                        URL call = new URL(url);
                        HttpURLConnection conn =(HttpURLConnection) call.openConnection();
                        conn.setConnectTimeout(10000);
                        BufferedReader bf=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String s="";
                        while((s=bf.readLine())!=null){
                            response+=s;
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(response.equals("updated")){
                        findViewById(R.id.button3).setBackgroundColor(Color.RED);
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
                        value3=0;
                    }else {
                        Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                        findViewById(R.id.button3).setBackgroundColor(Color.BLUE);
                    }

                }else{
                    pin="3";state="1";
                    url=ip+"updatefromandroid.php?pin="+pin+"&state="+state;
                    String response="";
                    try {
                        URL call = new URL(url);
                        HttpURLConnection conn =(HttpURLConnection) call.openConnection();
                        conn.setConnectTimeout(10000);
                        BufferedReader bf=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String s="";
                        while((s=bf.readLine())!=null){
                            response+=s;
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(response.equals("updated")){
                        findViewById(R.id.button3).setBackgroundColor(Color.GREEN);
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
                        value3=1;
                    }else {
                        Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                        findViewById(R.id.button3).setBackgroundColor(Color.BLUE);
                    }
                }
            }
        });

        Button b4= (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value4 ==1){
                    pin="4";state="0";
                    url=ip+"updatefromandroid.php?pin="+pin+"&state="+state;
                    String response="";
                    try {
                        URL call = new URL(url);
                        HttpURLConnection conn =(HttpURLConnection) call.openConnection();
                        conn.setConnectTimeout(10000);
                        BufferedReader bf=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String s="";
                        while((s=bf.readLine())!=null){
                            response+=s;
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(response.equals("updated")){
                        findViewById(R.id.button4).setBackgroundColor(Color.RED);
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
                        value4=0;
                    }else {
                        Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                        findViewById(R.id.button4).setBackgroundColor(Color.BLUE);
                    }

                }else{
                    pin="4";state="1";
                    url=ip+"updatefromandroid.php?pin="+pin+"&state="+state;
                    String response="";
                    try {
                        URL call = new URL(url);
                        HttpURLConnection conn =(HttpURLConnection) call.openConnection();
                        conn.setConnectTimeout(10000);
                        BufferedReader bf=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String s="";
                        while((s=bf.readLine())!=null){
                            response+=s;
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    if(response.equals("updated")){
                        findViewById(R.id.button4).setBackgroundColor(Color.GREEN);
                        Toast.makeText(getApplicationContext(),"Updated",Toast.LENGTH_SHORT).show();
                        value4=1;
                    }else {
                        Toast.makeText(getApplicationContext(), "Not Updated", Toast.LENGTH_SHORT).show();
                        findViewById(R.id.button4).setBackgroundColor(Color.BLUE);
                    }
                }
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
