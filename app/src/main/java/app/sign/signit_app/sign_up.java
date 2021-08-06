package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import app.sign.signit_app.Constant.AppConfig;
import app.sign.signit_app.R;
import app.sign.signit_app.utils.mysingletons;
import es.dmoral.toasty.Toasty;

public class sign_up extends AppCompatActivity {
    private TextView signUp;
    private TextView dicr;
    private TextInputEditText edUserName;
    private TextInputEditText edOrg;
    private TextInputEditText edOrgEmail;
    private ImageView ivSignupButton;
    private TextView tvLogin;
    String successd;

     String demop="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        signUp = (TextView) findViewById(R.id.sign_up);
        dicr = (TextView) findViewById(R.id.dicr);
        edUserName = (TextInputEditText) findViewById(R.id.ed_user_name);
        edOrg = (TextInputEditText) findViewById(R.id.ed_org);
        edOrgEmail = (TextInputEditText) findViewById(R.id.ed_org_email);
        ivSignupButton = (ImageView) findViewById(R.id.iv_Signup_button);
        tvLogin = (TextView) findViewById(R.id.tv_login);

        ivSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_full_name = edUserName.getText().toString().trim();
                String org_name = edOrg.getText().toString().trim();
                String org_email = edOrgEmail.getText().toString().trim();
                if (validateControls()) {
                   sign_up_user(user_full_name, org_name,org_email);
                } else {
                    Toasty.error(sign_up.this, "Please Fill All Details", Toasty.LENGTH_SHORT, true).show();
                }
            }
        });

    }

    private void sign_up_user(final String user_full_name, final String org_name, final String org_email) {

        StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_DEV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject JsonObject= new JSONObject(response);
                    successd=JsonObject.getString("success");
                    if (successd.equals("true")){
                        String gvn_userType=JsonObject.getString("gvn_userType");
                        String getOrgID=JsonObject.getString("getOrgID");
                        String getOAbrandID=JsonObject.getString("getOAbrandID");
                        String getUserID=JsonObject.getString("getUserID");
                        String gvn_subscriptionLevel=JsonObject.getString("gvn_subscriptionLevel");
                        String activation_stats=JsonObject.getString("activation_stats");
                        Toast.makeText(sign_up.this, "Login done", Toast.LENGTH_SHORT).show();
                    }else
                    {
                        String messaged=JsonObject.getString("message");
                        Toast.makeText(sign_up.this, ""+messaged, Toast.LENGTH_SHORT).show();
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(sign_up.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("org_contact_prsn",user_full_name);
                hashMap.put("org_name",org_name);
                hashMap.put("org_email",org_email);
                hashMap.put("view","signinApi");
                return hashMap;
            }
        };
        mysingletons.getmInstance(sign_up.this).addToRequestque(request);
    }

    public boolean validateControls() {
        boolean success = true;
        if (edUserName.getText().toString().isEmpty() || edOrg.getText().toString().isEmpty() || edOrgEmail.getText().toString().isEmpty()) {
            success = false;
        }
        return success;
    }
}
