package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class adopt_signature extends AppCompatActivity {
    private RelativeLayout tab;
    private ImageView backImg;
    private EditText email;
    private RadioGroup rdGroup;
    private RadioButton button1;
    private RadioButton button2;
    private RadioButton button3;
    private LinearLayout bottomButton;
    private TextView tvSavedSignAsDefault;
    private TextView tvAdoptNewSign;
    ImageView back_img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopt_signature);
        email=findViewById(R.id.email);

        tab = (RelativeLayout) findViewById(R.id.tab);
        backImg = (ImageView) findViewById(R.id.back_img);
        rdGroup = (RadioGroup) findViewById(R.id.rdGroup);
        button1 = (RadioButton) findViewById(R.id.button_1);
        button2 = (RadioButton) findViewById(R.id.button_2);
        button3 = (RadioButton) findViewById(R.id.button_3);
        bottomButton = (LinearLayout) findViewById(R.id.bottom_button);
        tvSavedSignAsDefault = (TextView) findViewById(R.id.tv_Saved_Sign_as_Default);
        tvAdoptNewSign = (TextView) findViewById(R.id.tv_Adopt_New_Sign);

        back_img=findViewById(R.id.back_img);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(adopt_signature.this,home_screen.class);
                startActivity(intent);
            }
        });

        tvAdoptNewSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(adopt_signature.this,Adopt_your_Signature.class);
                startActivity(intent);
                finish();
            }
        });

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                button1.setText(charSequence.toString());
                button2.setText(charSequence.toString());
                button3.setText(charSequence.toString());
//                input = button1.getText().toString();
//                input = input.toLowerCase();
//                password.setText(input);
            }




            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}