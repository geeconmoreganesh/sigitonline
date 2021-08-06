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
import app.sign.signit_app.adapter.Adapter_archive_list;
import app.sign.signit_app.adapter.inprogress;
import app.sign.signit_app.model.ArchiveList;
import app.sign.signit_app.model.Dashboard;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;

import static app.sign.signit_app.utils.Common.profile_image;

public class Archive_list extends AppCompatActivity {

    RecyclerView recview;
    Adapter_archive_list adapter_archive_list;
    SharedPreferences sharedpreferences;
    ImageView back_img;
    DatePickerDialog picker;
    StringBuilder Start_date, End_date;
    private ArrayList<ArchiveList> arrayList = new ArrayList<>();
    String partyName;
    String partyStatusNm;
    String signedOn;
    String partyEmail;
    String partyRole;
    String rejectedOn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_list);
        recview=findViewById(R.id.rv_Archive_List);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //get_dashboard_data();
        adapter_archive_list = new Adapter_archive_list(arrayList, this);

        back_img = findViewById(R.id.back_img);

        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Archive_list.this, home_screen.class);
                startActivity(intent);
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recview.setLayoutManager(mLayoutManager);
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(Archive_list.this);
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

//    private void get_dashboard_data() {
//        StringRequest strReq = new StringRequest(Request.Method.POST,
//                AppConfig.URL_DEV, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    Log.d("subject_log","test response");
//
//                    JSONObject JsonObject= new JSONObject(response);
//                    String scucess=JsonObject.getString("success");
//                    String data=JsonObject.getString("data");
//                    // JSONObject jsonObject1= new JSONObject(data);
//
//                    JSONArray Jsonarry=new JSONArray(data);
//                    for (int i = 0; i <Jsonarry.length(); i++) {
//                        JSONObject content_list=Jsonarry.getJSONObject(i); }
//                    adapter_archive_list=new adapter_archive_list(getContext(),Jsonarry);
//                    recview.setAdapter(Adapter_syllabus);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }

//                try {
//                    JSONObject JsonObject = new JSONObject(response);
//                    String scucess = JsonObject.getString("success");
//                    String data = JsonObject.getString("data");
//                    JSONObject jsonObject = new JSONObject(data);
//                    String Dashboard = jsonObject.getString("archiveList");
//                    JSONArray Jsonarry = new JSONArray(Dashboard);
//
//                    for (int i = 0; i < Jsonarry.length(); i++) {
//                        JSONObject dashboard_list = Jsonarry.getJSONObject(i);
//                        String dsId = dashboard_list.getString("DS_ID");
//                        String name = dashboard_list.getString("NAME");
//                        String subject = dashboard_list.getString("SUBJECT");
//                        String parties = dashboard_list.getString("PARTIES");
//                        String partiesEmail = dashboard_list.getString("PARTIES_EMAIL");
//                        String path = dashboard_list.getString("PATH");
//                        String imgPath = dashboard_list.getString("IMG_PATH");
//                        String imgCount = dashboard_list.getString("IMG_COUNT");
//                        String type = dashboard_list.getString("TYPE");
//                        String status = dashboard_list.getString("STATUS");
//                        String statusNm = dashboard_list.getString("STATUS_NM");
//                        String fpId = dashboard_list.getString("FP_ID");
//                        String expieryDate = dashboard_list.getString("EXPIERY_DATE");
//                        String noOfDays = dashboard_list.getString("NO_OF_DAYS");
//                        String lastReminderDate = dashboard_list.getString("LAST_REMINDER_DATE");
//                        String cancelationReason = dashboard_list.getString("CANCELATION_REASON");
//                        String isArchived = dashboard_list.getString("IS_ARCHIVED");
//                        String isDeleted = dashboard_list.getString("IS_DELETED");
//                        String oaId = dashboard_list.getString("OA_ID");
//                        String oaBrandId = dashboard_list.getString("OA_BRAND_ID");
//                        String userId = dashboard_list.getString("USER_ID");
//                        String userNm = dashboard_list.getString("USER_NM");
//                        String createdOn = dashboard_list.getString("CREATED_ON");
//                        String createdBy = dashboard_list.getString("CREATED_BY");
//                        String sentOn = dashboard_list.getString("SENT_ON");
//                        String completedOn = dashboard_list.getString("COMPLETED_ON");
//                        String updatedOn = dashboard_list.getString("UPDATED_ON");
//                        String updatedBy = dashboard_list.getString("UPDATED_BY");
//                        String party_detailss = dashboard_list.getString("party_details");
//
//                        JSONArray Jsonary = new JSONArray(party_detailss);
//
//                        for (int j = 0; j < Jsonary.length(); j++) {
//                            JSONObject dashboard_listt = Jsonary.getJSONObject(i);
//                             partyName = dashboard_listt.getString("PARTY_NAME");
//                             partyStatusNm = dashboard_listt.getString("PARTY_STATUS_NM");
//                             signedOn  = dashboard_listt.getString("SIGNED_ON");
//                             partyEmail = dashboard_listt.getString("PARTY_EMAIL");
//                             partyRole = dashboard_listt.getString("PARTY_ROLE");
//                             rejectedOn= dashboard_listt.getString("REJECTED_ON");
//                        }
//
//                        ArchiveList archiveList =new ArchiveList(dsId,name,subject,parties,partiesEmail,path,imgPath,
//                                 imgCount,type,status,statusNm,fpId,expieryDate,noOfDays,lastReminderDate,
//                                 cancelationReason,isArchived,isDeleted,oaId,oaBrandId,userId,userNm,createdOn,
//                                createdBy,sentOn,completedOn,updatedOn,updatedBy,partyName,partyStatusNm,
//                                signedOn,partyEmail,partyRole,rejectedOn);
//
//                        arrayList.add(archiveList);
//                        recview.setAdapter(adapter_archive_list);
//                    }
//                    adapter_archive_list.notifyDataSetChanged();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//
//            public void onErrorResponse(VolleyError error) {
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String, String> hashMap = new HashMap<>();
//           //     hashMap.put("user_id", Common.USER_ID);
//                hashMap.put("user_id", "3784");
//                hashMap.put("view", "getArchivedList");
//                return hashMap;
//            }
//        };
//
//        mysingletons.getmInstance(Archive_list.this).addToRequestque(strReq);
//
//    }

}