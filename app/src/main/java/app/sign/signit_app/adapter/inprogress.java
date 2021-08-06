package app.sign.signit_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import app.sign.signit_app.R;
import app.sign.signit_app.docket_status;
import app.sign.signit_app.download_pdf;
import app.sign.signit_app.model.Dashboard;

public class inprogress extends RecyclerView.Adapter<inprogress.myviewholder>
{
    private ArrayList<Dashboard> arrayList;
    Context context;

    public inprogress(ArrayList<Dashboard> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_inprogress,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position)
    {

    final Dashboard dashboard=arrayList.get(position);
    holder.tv_document_name.setText(dashboard.getNAME());
    holder.send_to.setText(dashboard.getPARTIES());
    holder.tv_date.setText(dashboard.getCREATEDON());

            if(dashboard.getIMGCOUNT().length() > 1) {
                Glide.with(holder.imageView.getContext()).load("http://geecon.co.uk/dev/signIt/uploads/signatures/images/"+dashboard.getIMGPATH()+"/page-0.png").into(holder.imageView);
                } else {
                Glide.with(holder.imageView.getContext()).load("http://geecon.co.uk/dev/signIt/uploads/signatures/images/"+dashboard.getIMGPATH()+"/page.png").into(holder.imageView);
      }

        holder.Ll_inprogress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), docket_status.class);
                intent.putExtra("Ds_ids",String.valueOf(dashboard.getDSID()));
                intent.putExtra("IMG_PATH",String.valueOf(dashboard.getIMGPATH()));
                intent.putExtra("IMG_COUNT",String.valueOf(dashboard.getIMGCOUNT()));
                intent.putExtra("doc_name",String.valueOf(dashboard.getNAME()));
                view.getContext().startActivity(intent);
            }
        });
        holder.iv_download_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), download_pdf.class);
                intent.putExtra("Ds_ids",String.valueOf(dashboard.getDSID()));
                intent.putExtra("IMG_PATH",String.valueOf(dashboard.getIMGPATH()));
                intent.putExtra("IMG_COUNT",String.valueOf(dashboard.getIMGCOUNT()));
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        LinearLayout Ll_inprogress;
        TextView tv_document_name,send_to,tv_date;
        ImageView iv_download_image;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.pdf_thamb);
            tv_document_name=(TextView)itemView.findViewById(R.id.tv_document_name);
            send_to=(TextView)itemView.findViewById(R.id.send_to);
            tv_date=(TextView)itemView.findViewById(R.id.tv_date);
            iv_download_image=(ImageView) itemView.findViewById(R.id.iv_download_image);
            Ll_inprogress=(LinearLayout)itemView.findViewById(R.id.Ll_inprogress);
        }
    }
}
