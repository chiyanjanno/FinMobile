package com.example.finmobile.other;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finmobile.R;
import com.example.finmobile.Userupdates;

import java.util.List;

public class List_DataAdapter extends RecyclerView.Adapter<List_DataAdapter.List_DataViewHolder>{
    private List<List_Data> list_data;

    private Context mCtx;

    public List_DataAdapter(Context mCtx, List<List_Data> list_data) {
        this.mCtx = mCtx;
        this.list_data = list_data;
    }

    @Override
    public List_DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view= inflater.inflate(R.layout.list_data,null);


        return new List_DataViewHolder(view);

    }

    @Override
    public void onBindViewHolder(List_DataViewHolder holder, int position) {
        List_Data member=list_data.get(position);


        holder.members.setText(member.getFull_name());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Userupdates.class);

                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return list_data.size();
    }

   class List_DataViewHolder extends RecyclerView.ViewHolder{
        private TextView members;
        Button delete,update;

        public List_DataViewHolder(View itemView) {
            super(itemView);
            members=(TextView)itemView.findViewById(R.id.members);
            delete = (Button) itemView.findViewById(R.id.delete);
            update = (Button) itemView.findViewById(R.id.update);

        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public Button delete, update;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


        }
    }
}
