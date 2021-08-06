package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class update_company_profile extends AppCompatActivity {
     TextView tv_Update_Company;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_company_profile);
        tv_Update_Company=findViewById(R.id.tv_Update_Company);
    }
}