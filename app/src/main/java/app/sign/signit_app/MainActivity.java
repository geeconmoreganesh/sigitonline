package app.sign.signit_app;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.widget.TextView;

import app.sign.signit_app.R;
import app.sign.signit_app.model.AppUpdateChecker;
import app.sign.signit_app.utils.Common;

public class MainActivity extends Activity {
        public static final String MyPREFERENCES1 = "somthing";
        SharedPreferences sharedpreferences;
        private static int SPLASH_TIME_OUT = 3000;
        Handler handler;
        TextView varsion;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            AppUpdateChecker appUpdateChecker=new AppUpdateChecker(this);  //pass the activity in constructure
            appUpdateChecker.checkForUpdate(false);
            sharedpreferences= PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
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
            final String stepar=sharedpreferences.getString("Done","");


          Handler handler=new Handler();
          handler.postDelayed(new Runnable() {
              @Override
              public void run() {
                  if (stepar.equals("1")){

                      if( Common.USER_ID==""){
                          Intent intent = new Intent(MainActivity.this, login_screen.class);
                          startActivity(intent);
                          finish();
                      }
                      else {
                          // Toast.makeText(this, "faild in login ", Toast.LENGTH_SHORT).show();
                          Intent intent = new Intent(MainActivity.this, home_screen.class);
                          startActivity(intent);
                          finish();
                      }
                  }
                  else {

                      Intent intent = new Intent(MainActivity.this, login_card_overlap.class);
                      startActivity(intent);
                      finish();
                  }


              }
          },SPLASH_TIME_OUT);
//            UpdateChecker checker = new UpdateChecker(this);
//            // If you are in a Activity or a FragmentActivity
//            checker.start();



//            varsion = findViewById(R.id.varsion);

            PackageManager manager = this.getPackageManager();
            String version ="";
            try {

                PackageInfo info = manager.getPackageInfo(
                        this.getPackageName(), 0);
                version = info.versionName;
            } catch(Exception e){


            }
//            varsion.setText(version);
//        PackageInfo package = getPackageManager().getPackageInfo(getPackageName(), 0);
//        version = package.versionName;
//        versionCode = package.versionCode;



//            sharedpreferences = getSharedPreferences(MyPREFERENCES1,
//                    Context.MODE_PRIVATE);
//            String value = sharedpreferences.getString("password", "");
//
//            if (value.equalsIgnoreCase("")) {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        // This method will be executed once the timer is over
//                        // Start your app main activity
//                        Intent intent = new Intent( MainActivity.this,
//                                login_card_overlap.class);
//                        startActivity(intent);
//                        finish();
//                    }
//                }, SPLASH_TIME_OUT);
//            }
        }
}
