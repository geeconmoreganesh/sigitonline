package app.sign.signit_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import app.sign.signit_app.R;
import app.sign.signit_app.download_pdf;
import app.sign.signit_app.edit_contact;
import app.sign.signit_app.model.Dashboard;
import app.sign.signit_app.model.contact_list;

public class adapter_contact_list extends RecyclerView.Adapter<adapter_contact_list.myviewholder> {
        private ArrayList<contact_list> arrayList;
        Context context;

        public adapter_contact_list(ArrayList<contact_list> arrayList, Context context) {
            this.arrayList = arrayList;
            this.context = context;
        }

        @NonNull
        @Override
        public adapter_contact_list.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.single_contact, parent, false);
            return new adapter_contact_list.myviewholder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull myviewholder holder, int position) {

            final contact_list contact_lists = arrayList.get(position);
            holder.tv_persone_name.setText(contact_lists.getcONTACT_PERSON());
            holder.email.setText(contact_lists.geteMAIL());

            holder.edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), edit_contact.class);
                    intent.putExtra("oa_id",String.valueOf(contact_lists.getoA_ID()));
                    intent.putExtra("oA_BRAND_ID",String.valueOf(contact_lists.getoA_BRAND_ID()));
                    intent.putExtra("oA_CD",String.valueOf(contact_lists.getoA_CD()));
                    intent.putExtra("cONTACT_ID",String.valueOf(contact_lists.getcONTACT_ID()));
                    view.getContext().startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class myviewholder extends RecyclerView.ViewHolder {
            ImageView imageView,edit;
            TextView tv_persone_name, email;

            public myviewholder(@NonNull View itemView) {
                super(itemView);
                tv_persone_name = (TextView) itemView.findViewById(R.id.tv_persone_name);
                email = (TextView) itemView.findViewById(R.id.email);
                edit = (ImageView) itemView.findViewById(R.id.edit);
            }
        }
    }

