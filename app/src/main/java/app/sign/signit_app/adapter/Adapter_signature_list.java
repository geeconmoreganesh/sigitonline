package app.sign.signit_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import app.sign.signit_app.R;
import app.sign.signit_app.model.ArchiveList;
import app.sign.signit_app.model.SignatureList;


public class Adapter_signature_list extends RecyclerView.Adapter<Adapter_signature_list.myviewholder>
{
    private ArrayList<SignatureList> arrayList2;
    Context context;

    public Adapter_signature_list(ArrayList<SignatureList> arrayList2, Context context) {
        this.arrayList2 = arrayList2;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_signature_list,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {

        SignatureList signatureList=arrayList2.get(position);
      //  holder.tvDocumentName.setText(archiveList.getName());
        Glide.with(holder.Signature.getContext()).load(signatureList.getSignature()).into(holder.Signature);
    }

    @Override
    public int getItemCount() {
        return arrayList2.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        private RadioButton radioButton;
        private ImageView Signature;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            radioButton = (RadioButton) itemView.findViewById(R.id.radio_button);
            Signature = (ImageView) itemView.findViewById(R.id.Signature);

        }
    }
}
