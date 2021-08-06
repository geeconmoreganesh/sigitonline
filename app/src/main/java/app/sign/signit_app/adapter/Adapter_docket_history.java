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
import app.sign.signit_app.model.DocketHistory;


public class Adapter_docket_history extends RecyclerView.Adapter<Adapter_docket_history.myviewholder>
{
    private ArrayList<DocketHistory> arrayList2;
    Context context;

    public Adapter_docket_history(ArrayList<DocketHistory> arrayList2, Context context) {
        this.arrayList2 = arrayList2;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_docket_history,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {

        DocketHistory docketHistory=arrayList2.get(position);
        holder.tvTitle.setText(docketHistory.getMSG());
        holder.tvCreate.setText("Date :"+docketHistory.getCREATEDON());
    }

    @Override
    public int getItemCount() {
        return arrayList2.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        private TextView tvTitle;
        private TextView tvCreate;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_Title);
            tvCreate = (TextView) itemView.findViewById(R.id.tv_create);



        }
    }
}
