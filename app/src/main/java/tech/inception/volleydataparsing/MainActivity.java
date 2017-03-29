package tech.inception.volleydataparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void verify(View v)
    {
        EditText mobile_et = (EditText) findViewById(R.id.mobile_et);

        String mobile =  mobile_et.getText().toString();

        if(mobile.length() < 10)
        {
            Toast.makeText(MainActivity.this , "please enter valid mobile number" , Toast.LENGTH_SHORT).show();

            return;
        }

        int randomPIN = (int)(Math.random()*9000)+1000;

        Intent i = new Intent(MainActivity.this , Verify.class);

        i.putExtra("mobile" , mobile);

        i.putExtra("pin" , randomPIN);

        startActivity(i);
    }

}


