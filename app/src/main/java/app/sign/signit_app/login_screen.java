package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.google.android.material.textfield.TextInputEditText;

import app.sign.signit_app.Constant.AppConfig;
import app.sign.signit_app.R;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class login_screen extends AppCompatActivity {
    TextView forgot_password;
    ImageView image_login;
    AlertDialog alertDialog;
    String TAG = "login";
    String id, title, location, user_id;
    // GlobalClass globalClass;
    String Url = "http://geecon.co.uk/dev/signIt/rest/SIGNITServices.php";
    ProgressDialog pd;
    // Shared_Preference prefrence;
    TextView login_tv, signup_tv, skip, forget_pass, sign_up;
    EditText email_edt, password_edt;
    ImageView back_img;
    private String mActivity;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        findview_byme();
        on_click();

    }

    private void on_click() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login_screen.this, forget_password.class);
                startActivity(i);
            }
        });
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), sign_up.class));
            }
        });
        image_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_new = email_edt.getText().toString().trim();
                String password_new = password_edt.getText().toString().trim();
                if (!email_edt.getText().toString().isEmpty()) {
                    if (!password_edt.getText().toString().isEmpty()) {
                        checkLogin(email_new, password_new);
                    } else {
                        Toasty.warning(login_screen.this, "enter_password", Toast.LENGTH_SHORT, true).show();
                    }

                } else {
                    Toasty.warning(login_screen.this, "enter_email", Toast.LENGTH_SHORT, true).show();
                }
            }
        });
    }

    private void findview_byme() {
        forgot_password = findViewById(R.id.forgot_password);
        image_login = findViewById(R.id.image_login);
        email_edt = findViewById(R.id.email_edt);
        sign_up = findViewById(R.id.sign_up);
        password_edt = findViewById(R.id.password_edt);
    }
    private void Dashbordcount() {
        {
            StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_DEV, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject JsonObject = new JSONObject(response);
                        String profile_image = JsonObject.getString("data");
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(login_screen.this);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("data", profile_image);
                        editor.apply();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(login_screen.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("user_id", Common.USER_ID);
                    Log.d("test", "check" + Common.USER_ID);
                    hashMap.put("view", "getuserprofile");
                    return hashMap;
                }
            };
            mysingletons.getmInstance(login_screen.this).addToRequestque(request);
        }
    }
    private void checkLogin(final String email_new, final String password_new) {
        StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_DEV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject JsonObject = new JSONObject(response);
                    String scucess = JsonObject.getString("success");
                    String message = JsonObject.getString("message");
                    if (scucess.equals("1")){
                        String flag = JsonObject.getString("flag");
                        String data = JsonObject.getString("data");
                        JSONObject jsonObject1 = new JSONObject(data);
                        String USER_ID = jsonObject1.getString("USER_ID");
                        String USER_NAME = jsonObject1.getString("USER_NAME");
                        String REG_EMAIL_ID = jsonObject1.getString("REG_EMAIL_ID");
                        String FULL_NAME = jsonObject1.getString("FULL_NAME");

                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(login_screen.this);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("USER_ID", USER_ID);
                        editor.putString("USER_NAME", USER_NAME);
                        editor.putString("REG_EMAIL_ID", REG_EMAIL_ID);
                        editor.putString("FULL_NAME", FULL_NAME);
                        editor.putString("flag", flag);
                        editor.apply();
                        Dashbordcount();
                        Intent intent = new Intent(login_screen.this, home_screen.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(login_screen.this, ""+message, Toast.LENGTH_SHORT).show();
                    }
      
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(login_screen.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("username", email_new);
                hashMap.put("password", password_new);
                hashMap.put("view", "loginApi");
                return hashMap;
            }
        };
        mysingletons.getmInstance(login_screen.this).addToRequestque(request);
    }
}