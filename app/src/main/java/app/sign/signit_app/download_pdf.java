package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

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

public class download_pdf extends AppCompatActivity {
    String Ds_id,IMG_PATH,IMG_COUNT;
    ImageView iv_download_img;
    Button download_pdf;
    String pdf_link;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_pdf);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Ds_id=getIntent().getStringExtra("Ds_ids");
        IMG_PATH=getIntent().getStringExtra("IMG_PATH");
        IMG_COUNT=getIntent().getStringExtra("IMG_COUNT");
        iv_download_img=findViewById(R.id.iv_download_img);
        download_pdf=findViewById(R.id.download_pdf);
        get_pdf();

        if(IMG_COUNT.length() > 1) {
            Glide.with(getApplicationContext()).load("http://geecon.co.uk/dev/signIt/uploads/signatures/images/"+IMG_PATH+"/page-0.png").into(iv_download_img);
        } else {
            Glide.with(getApplicationContext()).load("http://geecon.co.uk/dev/signIt/uploads/signatures/images/"+IMG_PATH+"/page.png").into(iv_download_img);
        }

        download_pdf.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse(pdf_link));
                startActivity(i);
            }
        });
    }

    private void get_pdf() {
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_DEV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject JsonObject=new JSONObject(response);
                    String scucess=JsonObject.getString("success");
                    String data=JsonObject.getString("data");
                    JSONObject jsonObject=new JSONObject(data);
                    pdf_link=jsonObject.getString("pdf_link");
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
                hashMap.put("ds_id", Ds_id);
                hashMap.put("view","downloadPdfByDsId");
                return hashMap;
            }
        };
        mysingletons.getmInstance(download_pdf.this).addToRequestque(strReq);
    }
}