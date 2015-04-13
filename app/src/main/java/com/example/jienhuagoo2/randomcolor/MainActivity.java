package com.example.jienhuagoo2.randomcolor;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends Activity implements OnClickListener,OnLongClickListener {
    public TextView textR;
    public Button btn;
    public TextView textG;
    public TextView textB;
    public TextView rgb;
    public View colorBlock;
    public Vibrator vb;
    @Override
    public void onClick(View v) {
        change(v);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgb = (TextView)findViewById(R.id.textView);
        textR = (TextView)findViewById(R.id.textR);
        textG = (TextView)findViewById(R.id.textG);
        textB = (TextView)findViewById(R.id.textB);
        colorBlock = (View)findViewById(R.id.color);
        btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(this);
        colorBlock.setOnLongClickListener(this);
        vb = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
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

    int r,g,b;
    public void change(View v){

        Random ran = new Random();
        r = ran.nextInt(256);
        g = ran.nextInt(256);
        b = ran.nextInt(256);
        textR.setText(String.format("%s%d", "R : " ,r));
        textG.setText(String.format("%s%d", "G : " ,g));
        textB.setText(String.format("%s%d", "B : " ,b));
        colorBlock.setBackgroundColor(Color.rgb(r,g,b));
    }

    @Override
    public boolean onLongClick(View v) {
        vb.vibrate(500);
        rgb.setTextSize(30);
        rgb.setText(String.format("%s%x%x%x","#",r,g,b));
        return false;
    }
}
