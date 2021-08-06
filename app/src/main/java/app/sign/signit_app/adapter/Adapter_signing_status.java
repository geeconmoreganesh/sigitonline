package app.sign.signit_app.adapter;

import android.content.Context;
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
import app.sign.signit_app.model.Dashboard;
import app.sign.signit_app.model.SigningStatus;

public class Adapter_signing_status extends RecyclerView.Adapter<Adapter_signing_status.myviewholder>
{
    private ArrayList<SigningStatus> arrayList;
    Context context;

    public Adapter_signing_status(ArrayList<SigningStatus> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_signing_status,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {

        SigningStatus signingStatus=arrayList.get(position);
        holder.tvPartyTitle.setText(signingStatus.getPARTYNAME());
        holder.tvPartyEmail.setText(signingStatus.getPARTYEMAIL());
        holder.tvSignature.setText(signingStatus.getPARTYSTATUSNM());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        private TextView tvPartyTitle;
        private TextView tvPartyEmail;
        private TextView tvSignature;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            tvPartyTitle = (TextView) itemView.findViewById(R.id.tv_party_title);
            tvPartyEmail = (TextView) itemView.findViewById(R.id.tv_party_email);
            tvSignature = (TextView) itemView.findViewById(R.id.tv_signature);


        }
    }
}
