package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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
import app.sign.signit_app.adapter.adapter_cancelled;
import app.sign.signit_app.adapter.adapter_contact_list;
import app.sign.signit_app.model.Dashboard;
import app.sign.signit_app.model.contact_list;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;

public class contacts extends AppCompatActivity {
    ImageView back_img;
    RecyclerView recview;
    adapter_contact_list Adapter_contact_list;
    private ArrayList<contact_list> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        get_contact_data();
        recview=findViewById(R.id.rv_contact);
        Adapter_contact_list=new adapter_contact_list(arrayList,this);
        back_img=findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(contacts.this,home_screen.class);
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recview.setLayoutManager(mLayoutManager);
    }

    private void get_contact_data() {
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_DEV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject JsonObject=new JSONObject(response);
                    String scucess=JsonObject.getString("success");
                    String data=JsonObject.getString("data");
                    JSONObject jsonObject=new JSONObject(data);

                    String contactlists=jsonObject.getString("contactlist");
                    JSONArray Jsonarry=new JSONArray(contactlists);
                    for (int i = 0; i <Jsonarry.length(); i++)

                    {
                        JSONObject contactlist=Jsonarry.getJSONObject(i);
                        String cONTACT_ID=contactlist.getString("CONTACT_ID");
                        String cONTACT_PERSON=contactlist.getString("CONTACT_PERSON");
                        String eMAIL=contactlist.getString("EMAIL");

                        String oA_ID=contactlist.getString("OA_ID");
                        String oA_BRAND_ID=contactlist.getString("OA_BRAND_ID");
                        String oA_CD=contactlist.getString("OA_CD");
                        String tELEPHONE=contactlist.getString("TELEPHONE");
                        String uSER_ID=contactlist.getString("USER_ID");

                        contact_list contact_lists=new contact_list(cONTACT_ID,cONTACT_PERSON,eMAIL,tELEPHONE,oA_ID,oA_BRAND_ID,oA_CD,uSER_ID);
                        arrayList.add(contact_lists);

                        //  adapterClaim = new AdapterClaim(ClaimBusiness.this, list_claim);
                        recview.setAdapter(Adapter_contact_list);

                    }
                    Adapter_contact_list.notifyDataSetChanged();

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
                hashMap.put("view","getContactList");
                return hashMap; }
        };
        mysingletons.getmInstance(contacts.this).addToRequestque(strReq);
    }
}