package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;

import java.math.BigDecimal;

import afu.org.checkerframework.checker.nullness.qual.Nullable;

public class add_promocode extends AppCompatActivity {
    private Button paymentbtn;
    private int PayPal_Req_code=10;
    private static PayPalConfiguration paypaliconfig=new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(pyment_with_peypal.PAYPAL_CLIENT_ID);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promocode);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        paymentbtn = (Button) findViewById(R.id.paymentbtn);
        Intent intent=new Intent(this,PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,paypaliconfig);
        startService(intent);

        paymentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continuePayment();
            }
        });

    }

    private void continuePayment() {
        PayPalPayment palPayment=new PayPalPayment(new BigDecimal(100),"" +
                "USD","PaymentTest", PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent=new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,paypaliconfig);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,palPayment);
        startActivityForResult(intent,PayPal_Req_code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PayPal_Req_code && resultCode== Activity.RESULT_OK)
        {
            Toast.makeText(this, "payment Successfully", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "payment unSuccessfully", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }
}