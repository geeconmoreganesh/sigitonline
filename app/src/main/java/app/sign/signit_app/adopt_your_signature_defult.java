package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

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
import app.sign.signit_app.adapter.Adapter_archive_list;
import app.sign.signit_app.adapter.Adapter_signature_list;
import app.sign.signit_app.model.ArchiveList;
import app.sign.signit_app.model.SignatureList;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;

import static app.sign.signit_app.utils.Common.profile_image;

public class adopt_your_signature_defult extends AppCompatActivity {
    TextView tv_Saved_Sign_as_Default,tv_Adopt_New_Sign;
    ImageView back_img;

    RecyclerView recview;
    Adapter_signature_list adapter_signature_list;
    private ArrayList<SignatureList> arrayList = new ArrayList<>();

    SharedPreferences sharedpreferences;
    String signatureId;
    String  signature;
    String  isDefault;
    String  isDeleted;
    String  oaId;
    String  oaBrandId;
    String  userId;
    String  createdOn;
    String  updatedOn;
    String  createdBy;
    String  updatedBy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_your_signature_defult);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tv_Saved_Sign_as_Default=findViewById(R.id.tv_Saved_Sign_as_Default);
        tv_Adopt_New_Sign=findViewById(R.id.tv_Adopt_New_Sign);
        back_img = findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(adopt_your_signature_defult.this, home_screen.class);
                startActivity(intent);
            }
        });

        get_signature_list();
        recview=findViewById(R.id.id_signature_list);
        adapter_signature_list = new Adapter_signature_list(arrayList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recview.setLayoutManager(mLayoutManager);

        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(adopt_your_signature_defult.this);
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

        tv_Adopt_New_Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(adopt_your_signature_defult.this,adopt_signature.class);
                startActivity(intent);
            }
        });

    }
    private void get_signature_list() {
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_DEV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject JsonObject = new JSONObject(response);
                    String scucess = JsonObject.getString("success");
                    String data = JsonObject.getString("data");
                    JSONObject jsonObject = new JSONObject(data);
                    String Dashboard = jsonObject.getString("signatures");
                    JSONArray Jsonarry = new JSONArray(Dashboard);

                    for (int j = 0; j < Jsonarry.length(); j++) {
                        JSONObject dashboard_listt = Jsonarry.getJSONObject(j);
                        signatureId = dashboard_listt.getString("SIGNATURE_ID");
                        signature = dashboard_listt.getString("SIGNATURE");
                        isDefault = dashboard_listt.getString("IS_DEFAULT");
                        isDeleted = dashboard_listt.getString("IS_DELETED");
                        oaId = dashboard_listt.getString("OA_ID");
                        oaBrandId = dashboard_listt.getString("OA_BRAND_ID");
                        userId = dashboard_listt.getString("USER_ID");
                        createdOn = dashboard_listt.getString("CREATED_ON");
                        updatedOn = dashboard_listt.getString("UPDATED_ON");
                        createdBy = dashboard_listt.getString("CREATED_BY");
                        updatedBy = dashboard_listt.getString("UPDATED_BY");

                    }

                    SignatureList signatureList = new SignatureList(signatureId, signature, isDefault, isDeleted, oaId, oaBrandId, userId, createdOn, updatedOn, createdBy, updatedBy);

                    arrayList.add(signatureList);
                    recview.setAdapter(adapter_signature_list);

                    adapter_signature_list.notifyDataSetChanged();
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
              //  hashMap.put("user_id","3784");
                hashMap.put("view", "getUserAllSignatures");
                return hashMap;
            }
        };
        mysingletons.getmInstance(adopt_your_signature_defult.this).addToRequestque(strReq);

    }
}