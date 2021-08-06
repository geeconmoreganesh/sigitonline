package app.sign.signit_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.sign.signit_app.R;
import app.sign.signit_app.edit_contact;
import app.sign.signit_app.model.contact_list;

public class adapter_Transaction_history extends RecyclerView.Adapter<adapter_Transaction_history.myviewholder> {
        private ArrayList<TransactionHis> arrayList;
        Context context;

        public adapter_Transaction_history(ArrayList<TransactionHis> arrayList, Context context) {
            this.arrayList = arrayList;
            this.context = context;
        }

        @NonNull
        @Override
        public adapter_Transaction_history.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.single_transaction_history, parent, false);
            return new adapter_Transaction_history.myviewholder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull myviewholder holder, int position) {

            final TransactionHis transactionHis = arrayList.get(position);
            holder.idTRANSACTIONDESCRIPTION.setText(transactionHis.getTransactionDescription());
            holder.tvDATE.setText(transactionHis.getDate());
            holder.tvBALANCECREDITS.setText("Balance Credit - "+transactionHis.getBalanceCredits());
            holder.tvAMOUNT.setText(transactionHis.getAmount());
            holder.tvMETHOD.setText(transactionHis.getMethod());
            holder.tvSTATUS.setText(transactionHis.getStatus());

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

    public void filterList(ArrayList<TransactionHis> filteredList) {
        arrayList = filteredList;
        notifyDataSetChanged();
    }
        public class myviewholder extends RecyclerView.ViewHolder {
            private LinearLayout LlCardWallet;
            private LinearLayout img;
            private TextView idTRANSACTIONDESCRIPTION;
            private TextView tvDATE;
            private TextView tvBALANCECREDITS;
            private LinearLayout endLayout;
            private TextView tvAMOUNT;
            private TextView tvMETHOD;
            private TextView tvSTATUS;

            public myviewholder(@NonNull View itemView) {
                super(itemView);
                LlCardWallet = (LinearLayout) itemView.findViewById(R.id.Ll_card_wallet);
                img = (LinearLayout) itemView.findViewById(R.id.img);
                idTRANSACTIONDESCRIPTION = (TextView) itemView.findViewById(R.id.id_TRANSACTION_DESCRIPTION);
                tvDATE = (TextView) itemView.findViewById(R.id.tv_DATE);
                tvBALANCECREDITS = (TextView) itemView.findViewById(R.id.tv_BALANCE_CREDITS);
                endLayout = (LinearLayout) itemView.findViewById(R.id.end_layout);
                tvAMOUNT = (TextView) itemView.findViewById(R.id.tv_AMOUNT);
                tvMETHOD = (TextView) itemView.findViewById(R.id.tv_METHOD);
                tvSTATUS = (TextView) itemView.findViewById(R.id.tv_STATUS);
            }
        }
    }

