package app.sign.signit_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import app.sign.signit_app.R;

public class login_card_overlap extends AppCompatActivity {
    private static final int MAX_STEP = 7;

    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private Button btnNext,btn_sign_in;
    ImageView image_login;
    TextView tv_sign_up;
    private String about_title_array[] = {
            "Welcome to Signit",
            "Register Account ",
            "Account Setup",
            "Adopt Sign",
            "Set Template",
            "Send Docket",
            "Signing Docket"
    };
    private String about_description_array[] = {
            "Easily Sign documents online with Digital signature",

            "Register your account from anywhere,\n" +
                    "anytime and from any device\n",

            "Setup your own branding in Document and Emails",

            "You can change your signature, \n" +
            "at any point of time.",

            "Create the unlimited Templates without any restriction,\n"+
                    "it is as simple as creating the PDF.",


            "Send the document in just one credit. \n" +
                    "Sending document is easy-peasy.\n",

            "Open the email from Signitonline.co.uk, Click your \n" +
                    "unique link to the document.\n",
    };
    private int about_images_array[] = {
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.one,
            R.drawable.two
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_card_overlap);
        image_login=findViewById(R.id.image_login);
        tv_sign_up=findViewById(R.id.tv_sign_up);

//        ((View) findViewById(R.id.sign_up)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(login_card_overlap.this, sign_up.class);
//                startActivity(intent);
//            }
//        });
        initComponent();
    }

    private void initComponent() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);
//        btnNext = (Button) findViewById(R.id.btn_next);
//        btn_sign_in= (Button) findViewById(R.id.btn_sign_in);

        image_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(login_card_overlap.this);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("Done","1");
                editor.apply();
                Intent intent = new Intent(login_card_overlap.this, login_screen.class);
                startActivity(intent);
                finish();

            }
        });
//
//        tv_sign_up.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(login_card_overlap.this, sign_up.class);
//                startActivity(intent);
//                finish();
//            }
//        });
        // adding bottom dots
        bottomProgressDots(0);

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
//                btnNext.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        int current = viewPager.getCurrentItem() + 1;
//                        if (current < MAX_STEP) {
//                            // move to next screen
//                            viewPager.setCurrentItem(current);
//                        } else {
//                            finish();
//                        }
//                    }
//                });

//        ((ImageButton) findViewById(R.id.bt_close)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });

    }

    private void bottomProgressDots(int current_index) {
        LinearLayout dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        ImageView[] dots = new ImageView[MAX_STEP];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            int width_height = 15;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(width_height, width_height));
            params.setMargins(10, 10, 10, 10);
            dots[i].setLayoutParams(params);
            dots[i].setImageResource(R.drawable.shape_circle);
            dots[i].setColorFilter(getResources().getColor(R.color.grey_20), PorterDuff.Mode.SRC_IN);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[current_index].setImageResource(R.drawable.shape_circle);
            dots[current_index].setColorFilter(getResources().getColor(R.color.text_blue), PorterDuff.Mode.SRC_IN);
        }
    }

    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(final int position) {
            bottomProgressDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.iteam_stepar, container, false);
            ((TextView) view.findViewById(R.id.title)).setText(about_title_array[position]);
            ((TextView) view.findViewById(R.id.description)).setText(about_description_array[position]);
            ((ImageView) view.findViewById(R.id.image)).setImageResource(about_images_array[position]);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return about_title_array.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }
}


