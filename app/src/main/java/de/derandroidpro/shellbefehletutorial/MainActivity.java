package de.derandroidpro.shellbefehletutorial;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button btn1, btn2;

    Process shellprocess;

    String lauterbefehl = "input keyevent 24";
    String[] shutdownbefehl = {"su", "-c", "reboot -p"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(this);
        btn2 =  (Button ) findViewById(R.id.button2);
        btn2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button:{

                try {
                    shellprocess = Runtime.getRuntime().exec(lauterbefehl);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Fehler!", Toast.LENGTH_SHORT).show();
                }


                break;
            }


            case R.id.button2:{

                try {
                    shellprocess = Runtime.getRuntime().exec(shutdownbefehl);
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Fehler!", Toast.LENGTH_SHORT).show();
                }

                break;
            }


        }


    }
}
