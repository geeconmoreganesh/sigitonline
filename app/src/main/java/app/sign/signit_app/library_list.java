package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import app.sign.signit_app.Constant.AppConfig;
import app.sign.signit_app.adapter.inprogress;
import app.sign.signit_app.model.Dashboard;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;

import static app.sign.signit_app.utils.Common.profile_image;

public class library_list extends AppCompatActivity {
    RecyclerView recview;
    inprogress inprogressAdapter;
    SharedPreferences sharedpreferences;
    ImageView back_img;
    DatePickerDialog picker;
    StringBuilder Start_date, End_date;
    private ArrayList<Dashboard> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_list);
        recview=findViewById(R.id.rv_library_list);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        get_dashboard_data();
        inprogressAdapter = new inprogress(arrayList, this);

        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(library_list.this, home_screen.class);
                startActivity(intent);
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recview.setLayoutManager(mLayoutManager);

        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(library_list.this);
        Common.USER_ID = sharedpreferences.getString("USER_ID", "");
        Common.USER_NAME = sharedpreferences.getString("USER_NAME", "");
        Common.REG_EMAIL_ID = sharedpreferences.getString("REG_EMAIL_ID", "");
        Common.FULL_NAME = sharedpreferences.getString("FULL_NAME", "");
        profile_image = sharedpreferences.getString("data", "");
        Common.Cancelled = sharedpreferences.getString("Cancelled", "");
        Common.Draft = sharedpreferences.getString("Draft", "");
        Common.Expired = sharedpreferences.getString("Expired", "");
        Common.InProgress = sharedpreferences.getString("InProgress", "");
        Common.Rejected = sharedpreferences.getString("Rejected", "");
        Common.Signed = sharedpreferences.getString("Signed", "");
        //  Log.d("test_image","check imag"+Cancelled);

    }

    private void get_dashboard_data() {
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_DEV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject JsonObject = new JSONObject(response);
                    String scucess = JsonObject.getString("success");
                    String data = JsonObject.getString("data");
                    JSONObject jsonObject = new JSONObject(data);
                    String Dashboard = jsonObject.getString("dashboard");
                    JSONArray Jsonarry = new JSONArray(Dashboard);


                    for (int i = 0; i < Jsonarry.length(); i++) {
                        JSONObject dashboard_list = Jsonarry.getJSONObject(i);
                        String DS_ID = dashboard_list.getString("DS_ID");
                        String NAME = dashboard_list.getString("NAME");
                        String PARTIES = dashboard_list.getString("PARTIES");
                        String PATH = dashboard_list.getString("PATH");
                        String IMG_PATH = dashboard_list.getString("IMG_PATH");
                        String IMG_COUNT = dashboard_list.getString("IMG_COUNT");
                        String EXPIERY_DATE = dashboard_list.getString("EXPIERY_DATE");
                        String USER_ID = dashboard_list.getString("USER_ID");
                        String CREATED_ON = dashboard_list.getString("CREATED_ON");
                        Log.d("creat_date", "date" + CREATED_ON);
                        app.sign.signit_app.model.Dashboard dashboard = new Dashboard(DS_ID, NAME, PARTIES, PATH, IMG_PATH, IMG_COUNT, EXPIERY_DATE, USER_ID, CREATED_ON);
                        arrayList.add(dashboard);
                        //  adapterClaim = new AdapterClaim(ClaimBusiness.this, list_claim);
                        recview.setAdapter(inprogressAdapter);
                    }
                    inprogressAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override

            public void onErrorResponse(VolleyError error) {
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("user_id", Common.USER_ID);
                hashMap.put("status", "inprogress");
                hashMap.put("view", "getDashboardList");
                return hashMap;
            }
        };

        mysingletons.getmInstance(library_list.this).addToRequestque(strReq);
    }
}