package com.example.courseregistrationwaitinglistrafaelhidalgo.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.courseregistrationwaitinglistrafaelhidalgo.MainActivity;
import com.example.courseregistrationwaitinglistrafaelhidalgo.R;
import com.example.courseregistrationwaitinglistrafaelhidalgo.db.entity.Student;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.MyViewHolder> {


    private Context context;
    private ArrayList<Student> studentsList;
    private MainActivity mainActivity;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView email;
        public TextView level;
//        public RadioButton gradButton, seniorButton, juniorButton, sophButton, freshButton, radioButton;


        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
            email = view.findViewById(R.id.email);
            level = view.findViewById(R.id.level);
//            gradButton = view.findViewById(R.id.graduate);
//            seniorButton = view.findViewById(R.id.senior);
//            juniorButton = view.findViewById(R.id.junior);
//            sophButton = view.findViewById(R.id.sophomore);
//            freshButton = view.findViewById(R.id.freshman);
        }
    }


    public StudentsAdapter(Context context, ArrayList<Student> students, MainActivity mainActivity) {
        this.context = context;
        this.studentsList = students;
        this.mainActivity = mainActivity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list_item, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {


        final Student student = studentsList.get(position);

        holder.name.setText(student.getName());
        holder.email.setText(student.getEmail());
        holder.level.setText(student.getLevel());

        // get selected radio button from radioGroup
//        int selectedID = holder.level.getCheckedRadioButtonId();

        // find the radiobutton by returned id
//        RadioButton radioButton = (RadioButton) mainActivity.findViewById(selectedID);

//        holder.levelText.setText(radioButton.getText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                mainActivity.addAndEditStudents(true, student, position);
            }
        });

    }

    @Override
    public int getItemCount() {

        return studentsList.size();
    }


}
