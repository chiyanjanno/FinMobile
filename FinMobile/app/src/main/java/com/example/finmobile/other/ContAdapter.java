package com.example.finmobile.other;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finmobile.R;
import com.example.finmobile.Userupdates;

import java.util.List;





public class ContAdapter extends RecyclerView.Adapter<ContAdapter.ContViewHolder>{
    private List<Cont> cont;

   // private Context mCtx;
    private Context c;
    public ContAdapter(List<Cont> cont, Context c) {
       this.c = c;
        this.cont= cont;
    }

    @Override
    public ContViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cont, parent, false);

       // LayoutInflater inflater = LayoutInflater.from(mCtx);
        //View view= inflater.inflate(R.layout.list_data,null);

        return new ContViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ContAdapter.ContViewHolder holder, int position) {
        Cont member=cont.get(position);
        Cont update2 = cont.get(position);

      //  holder.cname.setText(member.getFull_name());
        holder.Monthly_contribution.setText(member.getMonthly_contribution());
        holder.Month.setText(member.getMonth());
        holder.date_of_payment.setText(member.getDate_of_payment());
        holder.Paid_through.setText(member.getPaid_through());



        holder.undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
         holder.update2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });


    }

    @Override
    public int getItemCount() {

        return cont.size();
    }

    class ContViewHolder extends RecyclerView.ViewHolder{

        private TextView member;
        private TextView cname;
        private EditText Monthly_contribution;
        private EditText Month;
        private EditText Paid_through;
        private EditText date_of_payment;


        Button undo,update2;

        public ContViewHolder(View itemView) {
            super(itemView);

         //   cname = (TextView) itemView.findViewById(R.id.cname);
            Monthly_contribution = (EditText) itemView.findViewById(R.id.Monthly_contribution);
            Month = (EditText) itemView.findViewById(R.id.Month);
            Paid_through = (EditText) itemView.findViewById(R.id.date_of_payment);
            date_of_payment = (EditText) itemView.findViewById(R.id.Paid_through);

            update2 = (Button) itemView.findViewById(R.id.update2);
            undo = (Button) itemView.findViewById(R.id.undo);

        }
    }


}
