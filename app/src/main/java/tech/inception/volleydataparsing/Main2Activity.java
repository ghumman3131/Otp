package tech.inception.volleydataparsing;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {

    EditText name_et , mobile_et , password_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name_et = (EditText) findViewById(R.id.name_et);
        mobile_et = (EditText) findViewById(R.id.mobile_et);
        password_et = (EditText) findViewById(R.id.password_et);

        get_values();


    }

    public  void get_values()
    {
        JSONObject jobj = new JSONObject();

        try {
            jobj.put("name_key" , "charan");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://192.168.0.15/get_data.php", jobj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jarr =  response.getJSONArray("result");

                     JSONObject job_box = (JSONObject) jarr.get(0);
                   name_et.setText(  job_box.getString("name") );
                   password_et.setText(  job_box.getString("password") );
                   mobile_et.setText( job_box.getString("mobile"));


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 ,  2 , 2));
        AppController app = new AppController(Main2Activity.this);
        app.addToRequestQueue(jobreq);
    }


}
