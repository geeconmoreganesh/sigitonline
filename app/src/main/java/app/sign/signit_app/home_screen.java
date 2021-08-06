package app.sign.signit_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import app.sign.signit_app.Constant.AppConfig;
import app.sign.signit_app.R;
import app.sign.signit_app.model.Dashboard;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import app.sign.signit_app.utils.Tools;
import es.dmoral.toasty.Toasty;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static app.sign.signit_app.utils.Common.profile_image;

public class home_screen extends AppCompatActivity {

    private ActionBar actionBar;
    SharedPreferences sharedpreferences;
    ImageButton logout,adopt_signature;
    ImageView signature;
    LinearLayout inprogress,drafts,Ll_expired,Ll_Rejected,Ll_cancelled,Ll_Signed;
    LinearLayout home,Templat,notifi;
    LinearLayout librarys;
    TextView profilea;
    CircularImageView user_profile;
    TextView email,tv_inprogress,tv_draft,tv_explntion,tv_rejected,tv_cancelled,tv_sign;
            private Toolbar toolbar;
            ImageView Profile;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_home_screen);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                Profile =  findViewById(R.id.Profile);

                home =  findViewById(R.id.home);
                librarys =  findViewById(R.id.Ll_labrary);
                Templat =  findViewById(R.id.Templat);
                notifi =  findViewById(R.id.notifi);
                if (Common.flag.contains("1")){
                    showDialogChampion();
                }
                tv_explntion=findViewById(R.id.tv_explntion);
                tv_rejected=findViewById(R.id.tv_rejected);
                tv_cancelled=findViewById(R.id.tv_cancelled);
                tv_sign=findViewById(R.id.tv_sign);
                toolbar=findViewById(R.id.toolbar);
                inprogress=findViewById(R.id.inprogress);
                signature=findViewById(R.id.signature);
                adopt_signature=findViewById(R.id.adopt_signature);
                drafts=findViewById(R.id.drafts);
                tv_inprogress=findViewById(R.id.tv_inprogress);
                tv_draft=findViewById(R.id.tv_draft);
                Ll_expired=findViewById(R.id.Ll_expired);
                Ll_Rejected=findViewById(R.id.Ll_Rejected);
                Ll_cancelled=findViewById(R.id.Ll_cancelled);
                Ll_Signed=findViewById(R.id.Ll_Signed);

                adopt_signature.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(home_screen.this,adopt_your_signature_defult.class);
                        startActivity(intent);
                        finish();
                    }
                });

                Templat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(home_screen.this,templat_list.class);
                        startActivity(intent);
                        finish();
                    }
                });
                librarys.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(home_screen.this,library_list.class);
                        startActivity(intent);
                        finish();
                    }
                });
               //toolbar.setTitle("HI,"+ Common.FULL_NAME);

                sharedpreferences= PreferenceManager.getDefaultSharedPreferences(home_screen.this);
                Common.USER_ID =sharedpreferences.getString("USER_ID","");
                Common.flag =sharedpreferences.getString("flag","");
                Common.USER_NAME =sharedpreferences.getString("USER_NAME","");
                Common.REG_EMAIL_ID =sharedpreferences.getString("REG_EMAIL_ID","");
                Common.FULL_NAME =sharedpreferences.getString("FULL_NAME","");
                Common.profile_image =sharedpreferences.getString("data","");
                Common.Cancelled =sharedpreferences.getString("Cancelled","");
                Common.Draft =sharedpreferences.getString("Draft","");
                Common.Expired =sharedpreferences.getString("Expired","");
                Common.InProgress =sharedpreferences.getString("InProgress","");
                Common.Rejected =sharedpreferences.getString("Rejected","");
                Common.Signed =sharedpreferences.getString("Signed","");
                Common.OA_BUSINESS_CREDIT_DEPOSIT =sharedpreferences.getString("OA_BUSINESS_CREDIT_DEPOSIT","");
                toolbar.setTitle("HI,"+ Common.FULL_NAME);
                Dashbordcount();
//                Toast.makeText(this, Common.USER_ID, Toast.LENGTH_SHORT).show();
                initToolbar();
                initNavigationMenu();
                get_signature();
                getWalletBalance();

//                logout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(home_screen.this);
//                        SharedPreferences.Editor editor=sharedPreferences.edit();
//                        editor.putString("USER_ID","");
//                        editor.apply();
//                        Intent intent = new Intent(home_screen.this, login_screen.class);
//                        startActivity(intent);
//                        finish();
//                    }
//                });

                Ll_Signed.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(home_screen.this, Signed.class);
                        startActivity(intent);
                    }
                });

                Ll_Rejected.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(home_screen.this, Rejected.class);
                        startActivity(intent);
                    }
                });


                Ll_cancelled.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(home_screen.this,Cancelled.class);
                        startActivity(intent);
                    }
                });

                Ll_expired.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(home_screen.this, Expired.class);
                        startActivity(intent);
                    }
                });

                drafts.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(home_screen.this, drafts.class);
                        startActivity(intent);
                    }
                });

                Profile.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(home_screen.this, profile.class);
                        startActivity(intent);
                    }
                });

                inprogress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(home_screen.this, dashboard_in_progress.class);
                        startActivity(intent);
                    }
                });
     }

    private void showDialogChampion() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.password_change);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setCancelable(true);
        final EditText oldPassword = (EditText) dialog.findViewById(R.id.oldPassword);
        final EditText newPassword = (EditText) dialog.findViewById(R.id.newPassword);
        final EditText confirmPassword = (EditText) dialog.findViewById(R.id.confirmPassword);

        (dialog.findViewById(R.id.bt_save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String old_pass=oldPassword.getText().toString().trim();
               String new_pass=newPassword.getText().toString().trim();
               String confirm_pass=confirmPassword.getText().toString().trim();

               if (!old_pass.isEmpty() || !new_pass.isEmpty() || !confirm_pass.isEmpty()){
                   password_change(old_pass,new_pass,confirm_pass);
               }else{
                   Toast.makeText(home_screen.this, "Please fild all the Details", Toast.LENGTH_SHORT).show();
               }
            }

            private void password_change(final String old_pass, final String new_pass, final String confirm_pass) {
                StringRequest strReq = new StringRequest(Request.Method.POST,
                        AppConfig.URL_DEV, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject JsonObject=new JSONObject(response);
                            String scucess=JsonObject.getString("success");
                            String message=JsonObject.getString("message");
                            Toast.makeText(home_screen.this, ""+message, Toast.LENGTH_SHORT).show();
                             oldPassword.setText("");
                             newPassword.setText("");
                             confirmPassword.setText("");

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
                        hashMap.put("view","updateUserPassword");
                        hashMap.put("username",Common.USER_NAME);
                        hashMap.put("oldPassword",old_pass);
                        hashMap.put("newPassword",new_pass);
                        hashMap.put("confirmPassword",confirm_pass);
                        return hashMap;
                    }
                };

                mysingletons.getmInstance(home_screen.this).addToRequestque(strReq);
            }

        });
        (dialog.findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        (dialog.findViewById(R.id.bt_cancels)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void get_signature() {
        {
            StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_DEV, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject JsonObject= new JSONObject(response);
                        String scucess=JsonObject.getString("success");
                        String data=JsonObject.getString("data");
                        JSONObject jsonObject1= new JSONObject(data);
                        String images=jsonObject1.getString("image");
                        //image.setImageMatrix(images);
                        Log.d("testd","check"+images);
                        Picasso.get().load(images).into(signature);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(home_screen.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("user_id",Common.USER_ID);
                    Log.d("test","check"+Common.USER_ID);
                    hashMap.put("view","getUserSelectedSign");
                    return hashMap;
                }
            };
            mysingletons.getmInstance(home_screen.this).addToRequestque(request);
        }
    }

    private void Dashbordcount() {
        {
            StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_DEV, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject JsonObject= new JSONObject(response);
                        String scucess=JsonObject.getString("success");
                        String data=JsonObject.getString("data");
                        JSONObject jsonObject1= new JSONObject(data);
                        String Cancelled=jsonObject1.getString("Cancelled");
                        String Draft=jsonObject1.getString("Draft");
                        String Expired=jsonObject1.getString("Expired");
                        String InProgress=jsonObject1.getString("InProgress");
                        String Rejected=jsonObject1.getString("Rejected");
                        String Signed=jsonObject1.getString("Signed");
                        Log.d("draft","check"+Cancelled);
                        tv_inprogress.setText(InProgress);
                        tv_draft.setText(Draft);
                        tv_explntion.setText(Expired);
                        tv_rejected.setText(Rejected);
                        tv_cancelled.setText(Cancelled);
                        tv_sign.setText(Signed);

                        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(home_screen.this);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("Cancelled",Cancelled);
                        editor.putString("Draft",Draft);
                        editor.putString("Expired",Expired);
                        editor.putString("InProgress",InProgress);
                        editor.putString("Rejected",Rejected);
                        editor.putString("Signed",Signed);
                        editor.apply();
                        Log.d("testd","check"+tv_inprogress);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(home_screen.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("user_id",Common.USER_ID);
                    Log.d("test","check"+Common.USER_ID);
                    hashMap.put("view","docketcount");
                    Log.d("check_id","user"+Common.USER_ID);
                    return hashMap;
                }
            };
            mysingletons.getmInstance(home_screen.this).addToRequestque(request);
        }
    }

    private void getWalletBalance() {
        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_DEV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject JsonObject=new JSONObject(response);
                    String scucess=JsonObject.getString("success");
                    String data=JsonObject.getString("data");
                    JSONObject jsonObject=new JSONObject(data);

                    String Dashboard=jsonObject.getString("walletBalance");
                    JSONArray Jsonarry=new JSONArray(Dashboard);

                    for (int i = 0; i <Jsonarry.length(); i++)

                    {
                        JSONObject dashboard_list=Jsonarry.getJSONObject(i);
                        String OA_BUSINESS_CREDIT_DEPOSIT=dashboard_list.getString("OA_BUSINESS_CREDIT_DEPOSIT");
                        Log.d("creat_date","date"+OA_BUSINESS_CREDIT_DEPOSIT);

                        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(home_screen.this);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("OA_BUSINESS_CREDIT_DEPOSIT",OA_BUSINESS_CREDIT_DEPOSIT);
                        editor.apply();

                    }

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
                hashMap.put("view","getWalletBalance");
                return hashMap;
            }
        };

        mysingletons.getmInstance(home_screen.this).addToRequestque(strReq);
    }


    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        Tools.setSystemBarColor(this);
    }
    private void initNavigationMenu() {
                final NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
                final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
                    public void onDrawerOpened(View drawerView) {
                        updateCounter(nav_view);
                        super.onDrawerOpened(drawerView);
                    }
                };

        View header=nav_view.getHeaderView(0);
        /*View view=navigationView.inflateHeaderView(R.layout.nav_header_main);*/
        profilea = (TextView)header.findViewById(R.id.Profile);
        email = (TextView)header.findViewById(R.id.email);
        user_profile=(CircularImageView)header.findViewById(R.id.user_pro);
        profilea.setText(Common.USER_NAME);
        email.setText(Common.REG_EMAIL_ID);
        Glide.with(getApplicationContext()).load(Common.profile_image).into(user_profile);
                drawer.setDrawerListener(toggle);
                toggle.syncState();
//                nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(final MenuItem item) {
//                        Toast.makeText(getApplicationContext(), item.getTitle() + " Selected", Toast.LENGTH_SHORT).show();
//                        actionBar.setTitle(item.getTitle());
//                        drawer.closeDrawers();
//                        return true;
//                    }
//                });
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_starred:
                          SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(home_screen.this);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("USER_ID","");
                        editor.apply();
                        Intent intent = new Intent(home_screen.this, login_screen.class);
                        startActivity(intent);
                        finish();
                        return true;
                    case R.id.nav_Wallet:

                                Intent i = new Intent(home_screen.this, Wallet.class);
                                startActivity(i);
                        return true;
                    case R.id.nav_help:
                        Intent is = new Intent(home_screen.this, company_info.class);
                        startActivity(is);
                        return true;

                    case R.id.nav_social:
                        Intent isa = new Intent(home_screen.this, contacts.class);
                        startActivity(isa);
                        return true;

                    case R.id.nav_Archive:
                        Intent isas = new Intent(home_screen.this, Archive_list.class);
                        startActivity(isas);
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), item.getTitle() + " Selected", Toast.LENGTH_SHORT).show();
                        return true;

                }
            }
        });
        // open drawer at start
               // drawer.openDrawer(GravityCompat.START);
                updateCounter(nav_view);
            }
            private void updateCounter(NavigationView nav) {
                Menu m = nav.getMenu();
                ((TextView) m.findItem(R.id.nav_inbox).getActionView().findViewById(R.id.text)).setText("0");

//                ((TextView) m.findItem(R.id.nav_inbox).getActionView().findViewById(R.id.text));
//                                Profile.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(home_screen.this, profile.class);
//                        startActivity(intent);
//                    }
//                });
                TextView badgePrioInbx = (TextView) m.findItem(R.id.nav_Wallet).getActionView().findViewById(R.id.text);
                badgePrioInbx.setText(Common.OA_BUSINESS_CREDIT_DEPOSIT);
                badgePrioInbx.setBackgroundColor(getResources().getColor(R.color.colorPrimaryLight));

                TextView badgeSocial = (TextView) m.findItem(R.id.nav_social).getActionView().findViewById(R.id.text);
                badgeSocial.setText("0 new");
                badgeSocial.setBackgroundColor(getResources().getColor(R.color.green_500));

            }

        }
