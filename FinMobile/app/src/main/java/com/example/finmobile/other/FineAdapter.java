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

public class FineAdapter extends RecyclerView.Adapter<FineAdapter.FinViewHolder> {
    private List<Fin> fines;

    // private Context mCtx;
    private Context c;

    public FineAdapter(List<Fin> fines, Context c) {
        this.c = c;
        this.fines = fines;
    }

    @Override
    public FinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fines, parent, false);

        // LayoutInflater inflater = LayoutInflater.from(mCtx);
        //View view= inflater.inflate(R.layout.list_data,null);

        return new FinViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FineAdapter.FinViewHolder holder, int position) {
        Fin member = fines.get(position);
        Fin update2 = fines.get(position);

        //  holder.cname.setText(member.getFull_name());
        holder.fine_amount.setText(member.getFine_amount());
        holder.fine_month.setText(member.getFine_month());
        holder.fine_date.setText(member.getFine_date());
        holder.fine_description.setText(member.getFine_description());
        holder.fine_mode.setText(member.getFine_mode());



      holder.undo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
         holder.update4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

             }
         });


    }

    @Override
    public int getItemCount() {

        return fines.size();
    }

    class FinViewHolder extends RecyclerView.ViewHolder {

        private TextView member;
        private TextView cname;
        private EditText fine_amount;
        private EditText fine_month;
        private EditText fine_date;
        private EditText fine_description;

        private EditText fine_mode;



        Button undo3, update4;

        public FinViewHolder(View itemView) {
            super(itemView);

            //   cname = (TextView) itemView.findViewById(R.id.cname);
            fine_amount = (EditText) itemView.findViewById(R.id.fine_amount);
            fine_month = (EditText) itemView.findViewById(R.id.fine_month);
            fine_date = (EditText) itemView.findViewById(R.id.fine_date);
            fine_description = (EditText) itemView.findViewById(R.id.fine_description);
            fine_mode = (EditText) itemView.findViewById(R.id.fine_mode);


            update4 = (Button) itemView.findViewById(R.id.update4);
            undo3 = (Button) itemView.findViewById(R.id.undo3);

        }
    }
}

