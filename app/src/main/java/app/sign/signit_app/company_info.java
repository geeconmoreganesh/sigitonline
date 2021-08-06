package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import app.sign.signit_app.Constant.AppConfig;
import app.sign.signit_app.model.Dashboard;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;

public class company_info extends AppCompatActivity {
ImageView pro_pic;
    private RelativeLayout tab;
    private ImageView backImg;
    private NestedScrollView nestedScrollView;
    private ImageView proPic;
    private TextView brandName;
    private TextView tvLocation;
    private TextView tvVersionCode;
    private TextView tvEmail;
    private TextView tvMobile;
    private TextView tv_contact_name;
    private TextView tvCampanyLocation;
    private TextView tvContry;
    TextView tv_Update_Company;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_info);
        pro_pic=findViewById(R.id.pro_pic);


        tab = (RelativeLayout) findViewById(R.id.tab);
        backImg = (ImageView) findViewById(R.id.back_img);
        nestedScrollView = (NestedScrollView) findViewById(R.id.nested_scroll_view);
        proPic = (ImageView) findViewById(R.id.pro_pic);
        brandName = (TextView) findViewById(R.id.brand_name);
        tvLocation = (TextView) findViewById(R.id.tv_location);
        tvVersionCode = (TextView) findViewById(R.id.tv_version_code);
        tvEmail = (TextView) findViewById(R.id.tv_email);
        tvMobile = (TextView) findViewById(R.id.tv_mobile);
        tv_contact_name = (TextView) findViewById(R.id.tv_contact_name);
        tvCampanyLocation = (TextView) findViewById(R.id.tv_campany_location);
        tvContry = (TextView) findViewById(R.id.tv_contry);
        tv_Update_Company = (TextView) findViewById(R.id.tv_Update_Company);

        tv_Update_Company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(company_info.this,update_company_profile.class);
                startActivity(intent);
            }
        });

        Glide.with(getApplicationContext()).load(Common.profile_image).into(pro_pic);
        Dashbordcount();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
    private void Dashbordcount() {
        {
            StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_DEV, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONObject JsonObject=new JSONObject(response);
                        String scucess=JsonObject.getString("success");
                        String data=JsonObject.getString("data");
                        JSONArray Jsonarry=new JSONArray(data);
                        for (int i = 0; i <Jsonarry.length(); i++)
                        {
                            JSONObject dashboard_list=Jsonarry.getJSONObject(i);
                            String TELEPHONE=dashboard_list.getString("TELEPHONE");
                            String EMAIL=dashboard_list.getString("EMAIL");
                            String CONTACT_NAME=dashboard_list.getString("CONTACT_NAME");
                            String ADDRESS=dashboard_list.getString("ADDRESS");
                            String OA_BRAND_COLOR=dashboard_list.getString("OA_BRAND_COLOR");
                            tvMobile.setText(TELEPHONE);
                            tvEmail.setText(EMAIL);
                            tv_contact_name.setText(CONTACT_NAME);
                            tv_contact_name.setText(ADDRESS);
                            tvContry.setText(ADDRESS);
                            tvLocation.setText(ADDRESS);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(company_info.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("brand_id", "1288");
                    hashMap.put("view", "getCompanyInfo");
                    return hashMap;
                }
            };
            mysingletons.getmInstance(company_info.this).addToRequestque(request);
        }
    }}