package app.sign.signit_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.sign.signit_app.R;
import app.sign.signit_app.model.DocketFields;
import app.sign.signit_app.model.SigningStatus;

public class Adapter_Docket_fields extends RecyclerView.Adapter<Adapter_Docket_fields.myviewholder>
{
    private ArrayList<DocketFields> arrayList1;
    Context context;

    public Adapter_Docket_fields(ArrayList<DocketFields> arrayList1, Context context) {
        this.arrayList1 = arrayList1;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_docket_fields,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {

        DocketFields docketFields=arrayList1.get(position);
        holder.tvFieldTitle.setText(docketFields.getPARTYNAME());
        holder.tvType.setText(docketFields.getELEMENTTYPE());
        holder.tvValue.setText(docketFields.getELEMENTNAME());


    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        private TextView tvFieldTitle;
        private TextView tvType;
        private TextView tvValue;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            tvFieldTitle = (TextView) itemView.findViewById(R.id.tv_Field_Title);
            tvType = (TextView) itemView.findViewById(R.id.tv_Type);
            tvValue = (TextView)itemView.findViewById(R.id.tv_Value);


        }
    }
}
