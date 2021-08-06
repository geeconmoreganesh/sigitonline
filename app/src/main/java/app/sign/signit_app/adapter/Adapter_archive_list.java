package app.sign.signit_app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.sign.signit_app.R;
import app.sign.signit_app.model.ArchiveList;
import app.sign.signit_app.model.DocketHistory;


public class Adapter_archive_list extends RecyclerView.Adapter<Adapter_archive_list.myviewholder>
{
    private ArrayList<ArchiveList> arrayList2;
    Context context;

    public Adapter_archive_list(ArrayList<ArchiveList> arrayList2, Context context) {
        this.arrayList2 = arrayList2;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_archive_list,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {

        ArchiveList archiveList=arrayList2.get(position);
        holder.tvDocumentName.setText(archiveList.getName());
        holder.tvSender.setText(archiveList.getParties());
        holder.tvSignedOn.setText(archiveList.getStatusNm());
        holder.tvReceivedOn.setText(archiveList.getName());
    }

    @Override
    public int getItemCount() {
        return arrayList2.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {

        private ImageView pdfThamb;
        private TextView tvDocumentName;
        private TextView tvSender;
        private TextView tvSignedOn;
        private TextView tvReceivedOn;
        public myviewholder(@NonNull View itemView) {
            super(itemView);

            pdfThamb = (ImageView) itemView.findViewById(R.id.pdf_thamb);
            tvDocumentName = (TextView) itemView.findViewById(R.id.tv_document_name);
            tvSender = (TextView) itemView.findViewById(R.id.tv_Sender);
            tvSignedOn = (TextView) itemView.findViewById(R.id.tv_Signed_On);
            tvReceivedOn = (TextView) itemView.findViewById(R.id.tv_Received_On);
        }
    }
}
