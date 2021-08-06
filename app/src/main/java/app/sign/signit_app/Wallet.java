package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import app.sign.signit_app.adapter.TransactionHis;
import app.sign.signit_app.adapter.adapter_Transaction_history;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;

public class Wallet extends AppCompatActivity {
TextView tv_balance;
TextView card_name;
LinearLayout add_wallet,Ll_Transaction_history;
    ImageView back_img;
    RecyclerView recview;
    adapter_Transaction_history Adapter_Transaction_history;
    private ArrayList<TransactionHis> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tv_balance=findViewById(R.id.tv_balance);
        add_wallet=findViewById(R.id.add_wallet);
        Ll_Transaction_history=findViewById(R.id.Ll_Transaction_history);
        card_name=findViewById(R.id.card_name);
        card_name.setText(Common.FULL_NAME);

        Adapter_Transaction_history=new adapter_Transaction_history(arrayList,this);
        recview=findViewById(R.id.rv_transaction_history);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recview.setLayoutManager(mLayoutManager);

        get_trasaction_data();
        tv_balance.setText("$"+Common.OA_BUSINESS_CREDIT_DEPOSIT);

        add_wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Wallet.this,add_credits.class);
                startActivity(i);
            }
        });


        back_img=findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Wallet.this,home_screen.class);
                startActivity(intent);
            }
        });

        Ll_Transaction_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Wallet.this, transaction_history.class);
                startActivity(i);
            }

        });
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

        mysingletons.getmInstance(Wallet.this).addToRequestque(strReq);

    }
}