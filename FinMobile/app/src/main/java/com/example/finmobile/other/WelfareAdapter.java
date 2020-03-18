package com.example.finmobile.other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finmobile.R;

import java.util.List;

public class WelfareAdapter extends RecyclerView.Adapter<WelfareAdapter.WelViewHolder>{
    private List<Wel> welfare;

    // private Context mCtx;
    private Context c;
    public WelfareAdapter(List<Wel> welfare, Context c) {
        this.c = c;
        this.welfare= welfare;
    }

    @Override
    public WelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.welfare, parent, false);

        // LayoutInflater inflater = LayoutInflater.from(mCtx);
        //View view= inflater.inflate(R.layout.list_data,null);

        return new WelViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull WelfareAdapter.WelViewHolder holder, int position) {
        Wel member=welfare.get(position);
        Wel update2 = welfare.get(position);

        //  holder.cname.setText(member.getFull_name());
        holder.welfare_contribution.setText(member.getWelfare_contribution());
        holder.welfare_month.setText(member.getWelfare_month());
        holder.welfare_date.setText(member.getWelfare_date());
        holder.welfare_mode.setText(member.getWelfare_mode());



      holder.undo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
         holder.update3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });


    }

    @Override
    public int getItemCount() {

        return welfare.size();
    }

    class WelViewHolder extends RecyclerView.ViewHolder{

        private TextView member;
        private TextView cname;
        private EditText welfare_contribution;
        private EditText welfare_month;
        private EditText welfare_mode;
        private EditText welfare_date;


        Button undo2,update3;

        public WelViewHolder(View itemView) {
            super(itemView);

            //   cname = (TextView) itemView.findViewById(R.id.cname);
            welfare_contribution = (EditText) itemView.findViewById(R.id.welfare_contribution);
            welfare_month = (EditText) itemView.findViewById(R.id.welfare_month);
            welfare_date = (EditText) itemView.findViewById(R.id.welfare_mode);
            welfare_mode = (EditText) itemView.findViewById(R.id.welfare_date);

            update3 = (Button) itemView.findViewById(R.id.update3);
            undo2 = (Button) itemView.findViewById(R.id.undo2);

        }
    }


}
