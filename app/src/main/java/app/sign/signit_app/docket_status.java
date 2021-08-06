package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
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
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import app.sign.signit_app.Constant.AppConfig;
import app.sign.signit_app.adapter.Adapter_Docket_fields;
import app.sign.signit_app.adapter.Adapter_docket_history;
import app.sign.signit_app.adapter.Adapter_signing_status;
import app.sign.signit_app.model.DocketFields;
import app.sign.signit_app.model.DocketHistory;
import app.sign.signit_app.model.SigningStatus;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;

public class docket_status extends AppCompatActivity {
    String Ds_id;
    String IMG_PATH,IMG_COUNT,doc_name;
    ImageView iv,download_pdf;
    String pdf_link;
    TextView docket_title;
    Adapter_Docket_fields adapter_Docket_fields;
    Adapter_signing_status adapter_signing_status;
    Adapter_docket_history adapter_docket_history;
    RecyclerView rv_signing_status,rv_Docket_fields,rv_docket_history;
    private ArrayList<SigningStatus> arrayList = new ArrayList<>();
    private ArrayList<DocketFields> arrayList1 = new ArrayList<>();
    private ArrayList<DocketHistory> arrayList2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docket_status);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
          getDocketStatus();
          getdocket_fields();
          getdocket_history();

        Ds_id=getIntent().getStringExtra("Ds_ids");
        IMG_PATH=getIntent().getStringExtra("IMG_PATH");
        IMG_COUNT=getIntent().getStringExtra("IMG_COUNT");
        doc_name=getIntent().getStringExtra("doc_name");
        docket_title=findViewById(R.id.docket_title);
        docket_title.setText(doc_name);

        rv_signing_status=findViewById(R.id.rv_signing_status);
        rv_Docket_fields=findViewById(R.id.rv_Docket_fields);
        rv_docket_history=findViewById(R.id.rv_docket_history);

        adapter_signing_status=new Adapter_signing_status(arrayList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_signing_status.setLayoutManager(mLayoutManager);

        adapter_Docket_fields=new Adapter_Docket_fields(arrayList1,this);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        rv_Docket_fields.setLayoutManager(mLayoutManager1);

        adapter_docket_history=new Adapter_docket_history(arrayList2,this);
        RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
        rv_docket_history.setLayoutManager(mLayoutManager2);


        iv=findViewById(R.id.iv);
        download_pdf=findViewById(R.id.download_pdf);

        get_pdf();
        if(IMG_COUNT.length() > 1) {
            Glide.with(getApplicationContext()).load("http://geecon.co.uk/dev/signIt/uploads/signatures/images/"+IMG_PATH+"/page-0.png").into(iv);
        } else {
            Glide.with(getApplicationContext()).load("http://geecon.co.uk/dev/signIt/uploads/signatures/images/"+IMG_PATH+"/page.png").into(iv);
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
        mysingletons.getmInstance(docket_status.this).addToRequestque(strReq);
    }

    private void getDocketStatus() {
        {
            StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_DEV, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONObject JsonObject=new JSONObject(response);
                        String data=JsonObject.getString("data");
                        JSONObject JsonObject1=new JSONObject(data);
                        String signing_status=JsonObject1.getString("signing_status");
                        JSONArray Jsonarry=new JSONArray(signing_status);
                        for (int i = 0; i <Jsonarry.length(); i++)
                        {
                            JSONObject content_list=Jsonarry.getJSONObject(i);
                            String pARTYID=content_list.getString("PARTY_ID");
                            String dSID=content_list.getString("DS_ID");
                            String pARTYNAME=content_list.getString("PARTY_NAME");
                            String pARTYEMAIL=content_list.getString("PARTY_EMAIL");
                            String pARTYROLE=content_list.getString("PARTY_ROLE");
                            String mESSAGE=content_list.getString("MESSAGE");
                            String pARTYSTATUS=content_list.getString("PARTY_STATUS");
                            String pARTYSTATUSNM=content_list.getString("PARTY_STATUS_NM");
                            String pARTYCOLOR=content_list.getString("PARTY_COLOR");
                            String sIGNINGORDER=content_list.getString("SIGNING_ORDER");
                            String sIGNEDON=content_list.getString("SIGNED_ON");
                            String rEJECTEDON=content_list.getString("REJECTED_ON");
                            String iSDELETED=content_list.getString("IS_DELETED");
                            String oAID=content_list.getString("OA_ID");
                            String oABRANDID=content_list.getString("OA_BRAND_ID");
                            String uSERID=content_list.getString("USER_ID");
                            String cREATEDON=content_list.getString("CREATED_ON");
                            String cREATEDBY=content_list.getString("CREATED_BY");
                            String uPDATEDON=content_list.getString("UPDATED_ON");
                            String uPDATEDBY=content_list.getString("UPDATED_BY");

                            SigningStatus signingStatus=new SigningStatus( pARTYID,  dSID,  pARTYNAME,  pARTYEMAIL,  pARTYROLE,  mESSAGE,  pARTYSTATUS,  pARTYSTATUSNM,  pARTYCOLOR,  sIGNINGORDER,  sIGNEDON,  rEJECTEDON,  iSDELETED,  oAID,
                                    oABRANDID,  uSERID,  cREATEDON,  cREATEDBY,  uPDATEDON, uPDATEDBY);
                            arrayList.add(signingStatus);
                            rv_signing_status.setAdapter(adapter_signing_status);

                        }
                        adapter_signing_status.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(docket_status.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("user_id", Common.USER_ID);
                    Log.d("test","check"+Common.USER_ID);
                    hashMap.put("view","getDocketStatus");
                    hashMap.put("ds_id",Ds_id);
                    return hashMap;
                }
            };
            mysingletons.getmInstance(docket_status.this).addToRequestque(request);
        }
    }

    private void getdocket_fields() {
        {
            StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_DEV, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONObject JsonObject=new JSONObject(response);
                        String data=JsonObject.getString("data");
                        JSONObject JsonObject1=new JSONObject(data);
                        String signing_status=JsonObject1.getString("docket_fields");
                        JSONArray Jsonarry=new JSONArray(signing_status);
                        for (int i = 0; i <Jsonarry.length(); i++)
                        {
                            JSONObject content_list=Jsonarry.getJSONObject(i);
                            String eLEMENTID=content_list.getString("ELEMENT_ID");
                            String dSID=content_list.getString("DS_ID");
                            String pARTYID=content_list.getString("PARTY_ID");
                            String pARTYNAME=content_list.getString("PARTY_NAME");
                            String pARTYCOLOR=content_list.getString("PARTY_COLOR");
                            String pAGENO=content_list.getString("PAGE_NO");
                            String eLEMENTTYPE=content_list.getString("ELEMENT_TYPE");
                            String eLEMENTNAME=content_list.getString("ELEMENT_NAME");
                            String rEQUIRED=content_list.getString("REQUIRED");
                            String rEADONLY=content_list.getString("READONLY");
                            String eLEMENTTXT=content_list.getString("ELEMENT_TXT");
                            String eLEMENTX=content_list.getString("ELEMENT_X");
                            String eLEMENTY=content_list.getString("ELEMENT_Y");
                            String pDFX=content_list.getString("PDF_X");
                            String pDFY=content_list.getString("PDF_Y");
                            String eLEMENTW=content_list.getString("ELEMENT_W");
                            String eLEMENTH=content_list.getString("ELEMENT_H");
                            String pDFW=content_list.getString("PDF_W");
                            String pDFH=content_list.getString("PDF_H");
                            String eLEMENTTITLE=content_list.getString("ELEMENT_TITLE");
                            String fONTFAMILY=content_list.getString("FONT_FAMILY");
                            String fONTSIZE=content_list.getString("FONT_SIZE");
                            String vALIDATION=content_list.getString("VALIDATION");
                            String pLACEHOLDER=content_list.getString("PLACEHOLDER");
                            String iSDELETED=content_list.getString("IS_DELETED");
                            String oAID=content_list.getString("OA_ID");
                            String oABRANDID=content_list.getString("OA_BRAND_ID");
                            String uSERID=content_list.getString("USER_ID");
                            String cREATEDON=content_list.getString("CREATED_ON");


                            DocketFields docketFields=new DocketFields(eLEMENTID, dSID, pARTYID, pARTYNAME, pARTYCOLOR, pAGENO, eLEMENTTYPE,
                                    eLEMENTNAME, rEQUIRED,  rEADONLY,  eLEMENTTXT,  eLEMENTX,  eLEMENTY,  pDFX,  pDFY,  eLEMENTW,  eLEMENTH,  pDFW,
                                    pDFH,  eLEMENTTITLE,  fONTFAMILY,  fONTSIZE,  vALIDATION,
                                     pLACEHOLDER,  iSDELETED,  oAID,  oABRANDID,  uSERID,  cREATEDON);
                            arrayList1.add(docketFields);
                            rv_Docket_fields.setAdapter(adapter_Docket_fields);

                        }
                        adapter_signing_status.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(docket_status.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("user_id", Common.USER_ID);
                    Log.d("test","check"+Common.USER_ID);
                    hashMap.put("view","getDocketStatus");
                    hashMap.put("ds_id",Ds_id);
                    return hashMap;
                }
            };
            mysingletons.getmInstance(docket_status.this).addToRequestque(request);
        }
    }

    private void getdocket_history() {
        {
            StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_DEV, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    try {
                        JSONObject JsonObject=new JSONObject(response);
                        String data=JsonObject.getString("data");
                        JSONObject JsonObject1=new JSONObject(data);
                        String signing_status=JsonObject1.getString("docket_history");
                        JSONArray Jsonarry=new JSONArray(signing_status);
                        for (int i = 0; i <Jsonarry.length(); i++)
                        {
                            JSONObject content_list=Jsonarry.getJSONObject(i);
                            String dSHID=content_list.getString("DSH_ID");
                            String dSID=content_list.getString("DS_ID");
                            String mSG=content_list.getString("MSG");
                            String iSDELELTED=content_list.getString("IS_DELELTED");
                            String oAID=content_list.getString("OA_ID");
                            String oABRANDID=content_list.getString("OA_BRAND_ID");
                            String uSERID=content_list.getString("USER_ID");
                            String cREATEDBY=content_list.getString("CREATED_BY");
                            String cREATEDON=content_list.getString("CREATED_ON");
                            String uPDATEDBY=content_list.getString("UPDATED_BY");
                            String uPDATEDON=content_list.getString("UPDATED_ON");



                            DocketHistory docketHistory=new DocketHistory(dSHID,dSID,mSG,iSDELELTED,
                                    oAID, oABRANDID, uSERID, cREATEDBY, cREATEDON, uPDATEDBY, uPDATEDON);
                            arrayList2.add(docketHistory);
                            rv_docket_history.setAdapter(adapter_docket_history);

                        }
                        adapter_docket_history.notifyDataSetChanged();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(docket_status.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("user_id", Common.USER_ID);
                    Log.d("test","check"+Common.USER_ID);
                    hashMap.put("view","getDocketStatus");
                    hashMap.put("ds_id",Ds_id);
                    return hashMap;
                }
            };
            mysingletons.getmInstance(docket_status.this).addToRequestque(request);
        }
    }
}