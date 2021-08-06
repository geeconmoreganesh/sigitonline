package app.sign.signit_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bumptech.glide.Glide;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import app.sign.signit_app.Constant.AppConfig;
import app.sign.signit_app.R;
import app.sign.signit_app.utils.Common;
import app.sign.signit_app.utils.mysingletons;
public class profile extends AppCompatActivity {
    EditText ed_full_name,user_name,email_id,memorable_word,passcord;
    CircularImageView image;
    String file_new;
    String file_New;
    Bitmap bitmap;
    TextView tv_username,tv_submit;
    String encodeImageString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ed_full_name=findViewById(R.id.ed_full_name);
        image=findViewById(R.id.image);
        tv_submit=findViewById(R.id.tv_submit);
        user_name=findViewById(R.id.user_name);
        email_id=findViewById(R.id.email_id);
        tv_username=findViewById(R.id.tv_username);
        memorable_word=findViewById(R.id.memorable_word);
        passcord=findViewById(R.id.passcord);
        ed_full_name.setText(Common.FULL_NAME);
        user_name.setText(Common.USER_NAME);
        email_id.setText(Common.REG_EMAIL_ID);
        ed_full_name.setText(Common.FULL_NAME);
        tv_username.setText(Common.FULL_NAME);
        Dashbordcount();

        Glide.with(getApplicationContext()).load(Common.profile_image).into(image);
        tv_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname=ed_full_name.getText().toString().trim();
                String email=email_id.getText().toString().trim();
                String passcode=passcord.getText().toString().trim();
            //    String passcode=passcord.getText().toString().trim();
                String memorableWord=memorable_word.getText().toString().trim();
                Log.d("test10", "onClick: "+fullname+email);
                update_profile(fullname,email,passcode,memorableWord);
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dexter.withContext(profile.this)
                        .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                                Intent intent=new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(Intent.createChooser(intent,"Browse image"),1);
                            }
                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                            }
                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                                permissionToken.continuePermissionRequest();
                            }
                        }).check();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==1 && resultCode==RESULT_OK)
        {
            Uri filepath=data.getData();
            file_new = filepath.toString();
            file_New= file_new.substring(file_new.lastIndexOf(".") + 1);
            //  String file_ext= MimeTypeFilter.getFileExtensionFromUrl(file_New.toString());
            //Log.d(TAG, "onActivityResult: "+file_new);
            try{
                InputStream inputStream=getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                image.setImageBitmap(bitmap);
                encodeBitmapImage(bitmap);
            }catch (Exception ex)
            {
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void encodeBitmapImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytesofimage=byteArrayOutputStream.toByteArray();
        encodeImageString = Base64.encodeToString(bytesofimage, Base64.DEFAULT);
    }


    private void Dashbordcount() {
        {
            StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_DEV, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject JsonObject= new JSONObject(response);
                        String profile_image=JsonObject.getString("data");
                        //  Picasso.get().load(profile_image).into(image);
                       // Glide.with(getApplicationContext()).load(profile_image).into(image);
                        Log.d("imagess", "onResponse: "+profile_image);
                        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(profile.this);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("data",profile_image);
                        editor.apply();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(profile.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("user_id",Common.USER_ID);
                    Log.d("test","check"+Common.USER_ID);
                    hashMap.put("view","getuserprofile");
                    return hashMap;
                }
            };
            mysingletons.getmInstance(profile.this).addToRequestque(request);
        }
    }

    private void update_profile(final String fullnasnapme, final String email, final String passcode, final String memorableWord) {
        {
            StringRequest request = new StringRequest(Request.Method.POST, AppConfig.URL_DEV, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject JsonObject= new JSONObject(response);
                        String data=JsonObject.getString("data");
                        JSONObject jsonObject1=new JSONObject(data);
                        String msg=jsonObject1.getString("message");
                        Toast.makeText(profile.this, ""+msg, Toast.LENGTH_SHORT).show();
                        //  Picasso.get().load(profile_image).into(image);
//                        Glide.with(getApplicationContext()).load(profile_image).into(image);
//                        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(profile.this);
//                        SharedPreferences.Editor editor=sharedPreferences.edit();
//                        editor.putString("data",profile_image);
//                        editor.apply();

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(profile.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String,String> hashMap = new HashMap<>();
                    hashMap.put("view","updateuserprofile");
                    hashMap.put("user_id",Common.USER_ID);
                    hashMap.put("fullname",fullnasnapme);
                    hashMap.put("email",email);
                    hashMap.put("passcode",passcode);
                    hashMap.put("memorableWord",memorableWord);
                    hashMap.put("profile_image",encodeImageString);
                    hashMap.put("image_type","png");
                    Log.d("check_image", "getParams: "+encodeImageString);
                    return hashMap;
                }
            };
            mysingletons.getmInstance(profile.this).addToRequestque(request);
        }
    }

}
