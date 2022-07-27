package com.example.courseregistrationwaitinglistrafaelhidalgo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.courseregistrationwaitinglistrafaelhidalgo.adapter.StudentsAdapter;
import com.example.courseregistrationwaitinglistrafaelhidalgo.db.StudentsAppDatabase;
import com.example.courseregistrationwaitinglistrafaelhidalgo.db.entity.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;


    private StudentsAdapter studentsAdapter;
    private ArrayList<Student> studentArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private StudentsAppDatabase studentsAppDatabase;
    private static final String TAG="MainActivityTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" Students Manager ");

        recyclerView = findViewById(R.id.recycler_view_students);
        studentsAppDatabase = Room.databaseBuilder(getApplicationContext(),StudentsAppDatabase.class,"StudentDB").addCallback(callback).build();



        new GetAllStudentsAsyncTask().execute();

        studentsAdapter = new StudentsAdapter(this, studentArrayList, MainActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(studentsAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAndEditStudents(false, null, -1);
            }


        });



    }

















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void addAndEditStudents(final boolean isUpdate, final Student student, final int position) {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(getApplicationContext());
        View view = layoutInflaterAndroid.inflate(R.layout.layout_add_student, null);

        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilderUserInput.setView(view);

        TextView studentTitle = view.findViewById(R.id.new_student_title);
        final EditText newStudent = view.findViewById(R.id.name);
        final EditText StudentEmail = view.findViewById(R.id.email);
        final EditText StudentLevel = view.findViewById(R.id.level);

        studentTitle.setText(!isUpdate ? "Add New Student" : "Edit Student");

        if (isUpdate && student != null) {
            newStudent.setText(student.getName());
            StudentEmail.setText(student.getEmail());
            StudentLevel.setText(student.getLevel());
        }

        alertDialogBuilderUserInput
                .setCancelable(false)
                .setPositiveButton(isUpdate ? "Update" : "Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogBox, int id) {

                    }
                })
                .setNegativeButton("Delete",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {

                                if (isUpdate) {

                                    deleteStudent(student, position);
                                } else {

                                    dialogBox.cancel();

                                }

                            }
                        });


        final AlertDialog alertDialog = alertDialogBuilderUserInput.create();
        alertDialog.show();

        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(newStudent.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Enter Student name!", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    alertDialog.dismiss();
                }


                if (isUpdate && student != null) {

                    updateStudent(newStudent.getText().toString(), StudentEmail.getText().toString(),StudentLevel.getText().toString(), position);
                } else {

                    createStudent(newStudent.getText().toString(), StudentEmail.getText().toString(), StudentLevel.getText().toString());
                }
            }
        });
    }

    private void deleteStudent(Student student, int position) {

        studentArrayList.remove(position);

        new DeleteStudentAsyncTask().execute(student);

    }

    private void updateStudent(String name, String email, String level, int position) {

        Student student = studentArrayList.get(position);

        student.setName(name);
        student.setEmail(email);
        student.setLevel(level);



        new UpdateStudentAsyncTask().execute(student);

        studentArrayList.set(position, student);




    }

    private void createStudent(String name, String email, String level) {

        new CreateStudentAsyncTask().execute(new Student(0,name,email,level));

    }

    private class GetAllStudentsAsyncTask extends AsyncTask<Void,Void,Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            studentArrayList.addAll(studentsAppDatabase.getStudentDAO().getStudents());
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            studentsAdapter.notifyDataSetChanged();
        }
    }


    private class CreateStudentAsyncTask extends AsyncTask<Student,Void,Void>{



        @Override
        protected Void doInBackground(Student... students) {

            long id = studentsAppDatabase.getStudentDAO().addStudent(students[0]);


            Student student = studentsAppDatabase.getStudentDAO().getStudent(id);

            if (student != null) {

                studentArrayList.add(0, student);


            }

            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            studentsAdapter.notifyDataSetChanged();
        }
    }

    private class UpdateStudentAsyncTask extends AsyncTask<Student,Void,Void>{


        @Override
        protected Void doInBackground(Student... students) {

            studentsAppDatabase.getStudentDAO().updateStudent(students[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            studentsAdapter.notifyDataSetChanged();
        }
    }

    private class DeleteStudentAsyncTask extends AsyncTask<Student,Void,Void>{

        @Override
        protected Void doInBackground(Student... students) {

            studentsAppDatabase.getStudentDAO().deleteStudent(students[0]);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            studentsAdapter.notifyDataSetChanged();
        }
    }

    RoomDatabase.Callback callback= new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            //Toast.makeText(getApplicationContext()," On Create Called ",Toast.LENGTH_LONG).show();
            Log.i(TAG, " on create invoked ");

            createStudent("Ozzy Osbourne Jones","Ozzy@metal.com","Graduate");
            createStudent("John Smith","John@email.com","Junior");
            createStudent("Pocahontas","Pocahontas@email.com","Junior");
            createStudent("Osmosis Jones","Osmosis@frank.com","Freshman");




        }


        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            //  Toast.makeText(getApplicationContext()," On Create Called ",Toast.LENGTH_LONG).show();
            Log.i(TAG, " on open invoked ");

        }

    };























//    public void addListenerOnButton() {
//
//        radioSexGroup = (RadioGroup) findViewById(R.id.level);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                // get selected radio button from radioGroup
//                int selectedId = radioSexGroup.getCheckedRadioButtonId();
//
//                // find the radiobutton by returned id
//                radioSexButton = (RadioButton) findViewById(selectedId);
//
//                Toast.makeText(MainActivity.this,
//                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();
//
//            }
//
//        });
//
//    }
}