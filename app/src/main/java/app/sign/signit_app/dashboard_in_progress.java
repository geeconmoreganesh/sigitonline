package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import app.sign.signit_app.Constant.AppConfig;
import app.sign.signit_app.adapter.inprogress;
import app.sign.signit_app.model.Dashboard;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;

import static app.sign.signit_app.utils.Common.profile_image;

public class dashboard_in_progress extends AppCompatActivity {
   RecyclerView recview;
   inprogress inprogressAdapter;
    SharedPreferences sharedpreferences;
    TextView in_pro_count,tv_get_from_date,tv_from_date,tv_get_to_date,tv_to_date;
    ImageView back_img;
    DatePickerDialog picker;
    Button bt_view_data,bt_view_clear;
    String from_date="";
    String to_date="";
    StringBuilder Start_date;
    StringBuilder End_date;

    private ArrayList<Dashboard> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_in_progress);
        recview=findViewById(R.id.in_progress);
        in_pro_count=findViewById(R.id.in_pro_count);
        tv_get_from_date=findViewById(R.id.tv_get_from_date);
        tv_from_date=findViewById(R.id.tv_from_date);
        tv_get_to_date = (TextView) findViewById(R.id.tv_get_to_date);
        tv_to_date = (TextView) findViewById(R.id.tv_to_date);
        bt_view_data = (Button) findViewById(R.id.bt_view_data);
        bt_view_clear = (Button) findViewById(R.id.bt_view_clear);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        get_dashboard_data();
        inprogressAdapter=new inprogress(arrayList,this);

        back_img=findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dashboard_in_progress.this,home_screen.class);
                startActivity(intent);
            }
        });

          bt_view_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_get_from_date.setText("");
                tv_get_to_date.setText("");
                arrayList.clear();
                bt_view_data.setBackgroundColor(getResources().getColor(R.color.grey_40));
                tv_from_date.setBackgroundColor(getResources().getColor(R.color.grey_40));
                tv_to_date.setBackgroundColor(getResources().getColor(R.color.grey_40));

            }
        });


        tv_get_from_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                tv_get_from_date.setInputType(InputType.TYPE_NULL);
                tv_from_date.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                picker = new DatePickerDialog(dashboard_in_progress.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                //   tv_get_from_date.setText(String.valueOf((monthOfYear + 1)));
                                //    tv_get_from_date.setText(String.valueOf(year + "-" + (monthOfYear + 1) + "-" +dayOfMonth));
                                Start_date = new StringBuilder().append(year).append("-").append(monthOfYear + 1).append("-").append(dayOfMonth);
                                tv_get_from_date.setText(new StringBuilder().append(dayOfMonth).append(".").append(monthOfYear + 1).append(".").append(year));
                            }
                        }, year, month, day);
                picker.show();
            }

        });

        tv_get_to_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                tv_to_date.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                tv_get_to_date.setInputType(InputType.TYPE_NULL);
                // date picker dialog
                picker = new DatePickerDialog(dashboard_in_progress.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                End_date = new StringBuilder().append(year).append("-").append(monthOfYear + 1).append("-").append(dayOfMonth);
                                // tv_get_to_date.setText(new StringBuilder().append(dayOfMonth).append("/").append(monthOfYear+1).append("/").append(year));
                                tv_get_to_date.setText(new StringBuilder().append(dayOfMonth).append(".").append(monthOfYear + 1).append(".").append(year));
                            }
                        }, year, month, day);
                picker.show();
                if (tv_get_to_date.equals("") && tv_get_from_date.equals("")){
                }else {
                    bt_view_data.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                }
            }

        });


        bt_view_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tv_get_from_date.getText().toString().equals("")) {
                    Toast.makeText(dashboard_in_progress.this, "Please Select From Date", Toast.LENGTH_SHORT).show();
                } else if (tv_get_to_date.getText().toString().equals("")) {
                    Toast.makeText(dashboard_in_progress.this, "Please Select To Date", Toast.LENGTH_SHORT).show();
                } else {
                     from_date=tv_get_from_date.getText().toString();
                     to_date=tv_get_to_date.getText().toString();
                    getDashboardList(from_date,to_date);
                }
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recview.setLayoutManager(mLayoutManager);

        sharedpreferences= PreferenceManager.getDefaultSharedPreferences(dashboard_in_progress.this);
        Common.USER_ID =sharedpreferences.getString("USER_ID","");
        Common.USER_NAME =sharedpreferences.getString("USER_NAME","");
        Common.REG_EMAIL_ID =sharedpreferences.getString("REG_EMAIL_ID","");
        Common.FULL_NAME =sharedpreferences.getString("FULL_NAME","");
        profile_image =sharedpreferences.getString("data","");
        Common.Cancelled =sharedpreferences.getString("Cancelled","");
        Common.Draft =sharedpreferences.getString("Draft","");
        Common.Expired =sharedpreferences.getString("Expired","");
        Common.InProgress =sharedpreferences.getString("InProgress","");
        Common.Rejected =sharedpreferences.getString("Rejected","");
        Common.Signed =sharedpreferences.getString("Signed","");
      //  Log.d("test_image","check imag"+Cancelled);

        in_pro_count.setText(Common.InProgress);
    }

    private void get_dashboard_data() {
        arrayList.clear();
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_DEV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject JsonObject=new JSONObject(response);
                    String scucess=JsonObject.getString("success");
                    String data=JsonObject.getString("data");
                    JSONObject jsonObject=new JSONObject(data);
                    String Dashboard=jsonObject.getString("dashboard");
                    JSONArray Jsonarry=new JSONArray(Dashboard);
                    for (int i = 0; i <Jsonarry.length(); i++)

                    {
                        JSONObject dashboard_list=Jsonarry.getJSONObject(i);
                        String DS_ID=dashboard_list.getString("DS_ID");
                        String NAME=dashboard_list.getString("NAME");
                        String PARTIES=dashboard_list.getString("PARTIES");
                        String PATH=dashboard_list.getString("PATH");
                        String IMG_PATH=dashboard_list.getString("IMG_PATH");
                        String IMG_COUNT=dashboard_list.getString("IMG_COUNT");
                        String EXPIERY_DATE=dashboard_list.getString("EXPIERY_DATE");
                        String USER_ID=dashboard_list.getString("USER_ID");
                        String CREATED_ON=dashboard_list.getString("CREATED_ON");
                        Log.d("creat_date","date"+CREATED_ON);
                        Dashboard dashboard=new Dashboard(DS_ID,NAME,PARTIES,PATH,IMG_PATH,IMG_COUNT,EXPIERY_DATE,USER_ID,CREATED_ON);
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
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("user_id", Common.USER_ID);
                hashMap.put("status", "inprogress");
                hashMap.put("view","getDashboardList");
                return hashMap;
            }
        };

        mysingletons.getmInstance(dashboard_in_progress.this).addToRequestque(strReq);
    }

    private void getDashboardList(final String from_date, final String to_date) {
        arrayList.clear();
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_DEV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject JsonObject=new JSONObject(response);
                    String scucess=JsonObject.getString("success");
                    String data=JsonObject.getString("data");
                    JSONObject jsonObject=new JSONObject(data);

                    String Dashboard=jsonObject.getString("dashboard");
                    JSONArray Jsonarry=new JSONArray(Dashboard);


                    for (int i = 0; i <Jsonarry.length(); i++)

                    {
                        JSONObject dashboard_list=Jsonarry.getJSONObject(i);
                        String DS_ID=dashboard_list.getString("DS_ID");
                        String NAME=dashboard_list.getString("NAME");
                        String PARTIES=dashboard_list.getString("PARTIES");
                        String PATH=dashboard_list.getString("PATH");
                        String IMG_PATH=dashboard_list.getString("IMG_PATH");
                        String IMG_COUNT=dashboard_list.getString("IMG_COUNT");
                        String EXPIERY_DATE=dashboard_list.getString("EXPIERY_DATE");
                        String USER_ID=dashboard_list.getString("USER_ID");
                        String CREATED_ON=dashboard_list.getString("CREATED_ON");
                        Log.d("creat_date","date"+CREATED_ON);
                        Dashboard dashboard=new Dashboard(DS_ID,NAME,PARTIES,PATH,IMG_PATH,IMG_COUNT,EXPIERY_DATE,USER_ID,CREATED_ON);
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
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("user_id", Common.USER_ID);
                hashMap.put("status", "inprogress");
                hashMap.put("fromdate",from_date);
                hashMap.put("todate",to_date);
                hashMap.put("view","getDashboardList");
                return hashMap;
            }
        };

        mysingletons.getmInstance(dashboard_in_progress.this).addToRequestque(strReq);
    }

}