package com.anish.softwaricaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{
    Context mContext;
    List<Students> studentsList;

    public StudentAdapter(Context mContext, List<Students> studentsList) {
        this.mContext = mContext;
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_acitivty,parent,false);
        return  new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, final int position) {
        final Students contacts=studentsList.get(position);
        holder.tvName.setText(contacts.getName());
        holder.tvAddress.setText(contacts.getAddress());
        holder.tvGender.setText(contacts.getGender());
        holder.tvAge.setText(Integer.toString(contacts.getAge()));


        holder.imgRemove.setImageDrawable(mContext.getResources().getDrawable(R.drawable.bin));
        String gender=contacts.getGender();
        if (gender=="male") {

            holder.imgProfile.setImageResource(R.drawable.male);
        }
        else if(gender=="female"){
            holder.imgProfile.setImageResource(R.drawable.female);
        }
        else {
            holder.imgProfile.setImageDrawable(mContext.getResources().getDrawable(R.drawable.bin));
        }

        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"hi"+contacts.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Students students=studentsList.get(position);
                studentsList.remove(position);
                notifyItemRemoved(position);
                Toast.makeText(mContext,"Removed:"+students.getName(),Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public  class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView tvName,tvAddress,tvAge,tvGender;
        ImageView imgProfile,imgRemove;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvname);
            tvAddress=itemView.findViewById(R.id.tvaddress);
            tvAge=itemView.findViewById(R.id.tvage);
            tvGender=itemView.findViewById(R.id.tvgender);
            imgProfile=itemView.findViewById(R.id.imgprofile);
            imgRemove=itemView.findViewById(R.id.imgremove);
        }
         }

}
