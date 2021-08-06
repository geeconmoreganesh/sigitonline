package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
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
import app.sign.signit_app.adapter.TransactionHis;
import app.sign.signit_app.adapter.adapter_Transaction_history;
import app.sign.signit_app.adapter.adapter_contact_list;
import app.sign.signit_app.model.contact_list;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;

public class transaction_history extends AppCompatActivity {
    ImageView back_img;
    RecyclerView recview;
    EditText editTextSearch;
    adapter_Transaction_history Adapter_Transaction_history;
    private ArrayList<TransactionHis> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);
        editTextSearch = (EditText) findViewById(R.id.editTextSearch);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        back_img=findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(transaction_history.this,home_screen.class);
                startActivity(intent);
            }
        });

        Adapter_Transaction_history=new adapter_Transaction_history(arrayList,this);
        recview=findViewById(R.id.rv_transaction_history);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recview.setLayoutManager(mLayoutManager);

        get_trasaction_data();

        //adding a TextChangedListener
        //to call a method whenever there is some change on the EditText
        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });
    }

    private void filter(String text) {
        ArrayList<TransactionHis> filteredList = new ArrayList<>();
        for (TransactionHis item : arrayList) {
            if (item.getTransactionDescription().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        Adapter_Transaction_history.filterList(filteredList);
    }

    private void get_trasaction_data() {
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_DEV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject JsonObject = new JSONObject(response);
                    String scucess = JsonObject.getString("success");
                    String data = JsonObject.getString("data");
                    JSONObject jsonObject = new JSONObject(data);
                    String transData = jsonObject.getString("transData");
                    JSONArray Jsonarry = new JSONArray(transData);
                    for (int i = 0; i < Jsonarry.length(); i++) {
                        JSONObject contactlist = Jsonarry.getJSONObject(i);
                        String transactionHistoryId = contactlist.getString("TRANSACTION_HISTORY_ID");
                        String date = contactlist.getString("DATE");
                        String transactionDescription = contactlist.getString("TRANSACTION_DESCRIPTION");
                        String method = contactlist.getString("METHOD");
                        String amount = contactlist.getString("AMOUNT");
                        String credits = contactlist.getString("CREDITS");
                        String balanceCredits = contactlist.getString("BALANCE_CREDITS");
                        String status = contactlist.getString("STATUS");
                        String isDeleted = contactlist.getString("IS_DELETED");
                        String oaId = contactlist.getString("OA_ID");
                        String oaBrandId = contactlist.getString("OA_BRAND_ID");
                        String userId = contactlist.getString("USER_ID");
                        String createdOn = contactlist.getString("CREATED_ON");
                        String createdBy = contactlist.getString("CREATED_BY");
                        String updatedOn = contactlist.getString("UPDATED_ON");
                        String updatedBy = contactlist.getString("UPDATED_BY");


                        TransactionHis transactionHis = new TransactionHis(transactionHistoryId,date,transactionDescription,method,amount,
                                credits,balanceCredits,status,isDeleted,oaId,oaBrandId,userId,createdOn,createdBy,updatedOn,updatedBy);

                            arrayList.add(transactionHis);

                        recview.setAdapter(Adapter_Transaction_history);

                    }
                    Adapter_Transaction_history.notifyDataSetChanged();

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
                hashMap.put("view", "getTransactionList");
                return hashMap;
            }
        };

        mysingletons.getmInstance(transaction_history.this).addToRequestque(strReq);

    }

}
