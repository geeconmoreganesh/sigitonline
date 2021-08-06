package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

import app.sign.signit_app.Constant.AppConfig;
import app.sign.signit_app.model.contact_list;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;

public class edit_contact extends AppCompatActivity {
    private ImageView userImg;
    private EditText etUserName;
    private EditText etEmail;
    private EditText edContact;
    private EditText edPostion;
    private EditText edOrg;
    private TextView tvSave;
    private TextView tvDelete;
    String User_name,email,contact,postion,orgs;
    String oa_id,oA_BRAND_ID,oA_CD,cONTACT_ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        userImg = (ImageView) findViewById(R.id.user_img);
        etUserName = (EditText) findViewById(R.id.et_user_name);
        etEmail = (EditText) findViewById(R.id.et_email);
        edContact = (EditText) findViewById(R.id.ed_contact);
        edPostion = (EditText) findViewById(R.id.ed_postion);
        edOrg = (EditText) findViewById(R.id.ed_org);
        tvSave = (TextView) findViewById(R.id.tv_save);
        tvDelete = (TextView) findViewById(R.id.tv_delete);

        oa_id=getIntent().getStringExtra("oa_id");
        oA_BRAND_ID=getIntent().getStringExtra("oA_BRAND_ID");
        oA_CD=getIntent().getStringExtra("oA_CD");
        cONTACT_ID=getIntent().getStringExtra("cONTACT_ID");

        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User_name=etUserName.getText().toString().trim();
                email=etEmail.getText().toString().trim();
                contact=edContact.getText().toString().trim();

                get_contact_data(User_name,email,contact);
            }
        });


    }
    private void get_contact_data(final String user_name, final String email, final String contact) {
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_DEV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject JsonObject=new JSONObject(response);
                    String scucess=JsonObject.getString("success");
                    String data=JsonObject.getString("data");
                    JSONObject jsonObject=new JSONObject(data);

                    String contactlists=jsonObject.getString("message");


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
                hashMap.put("view","editContactList");
                hashMap.put("contact_person",user_name);
                hashMap.put("email",email);
                hashMap.put("telephone",contact);
                hashMap.put("oa_id",oa_id);
                hashMap.put("oa_brand_id",oA_BRAND_ID);
                hashMap.put("oa_cd",oA_CD);
                hashMap.put("contact_id",cONTACT_ID);
                return hashMap;
            }
        };

        mysingletons.getmInstance(edit_contact.this).addToRequestque(strReq);
    }

}