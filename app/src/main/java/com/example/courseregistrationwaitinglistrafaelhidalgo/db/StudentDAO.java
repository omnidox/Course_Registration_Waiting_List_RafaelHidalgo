package com.example.courseregistrationwaitinglistrafaelhidalgo.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.courseregistrationwaitinglistrafaelhidalgo.db.entity.Student;

import java.util.List;

@Dao
public interface StudentDAO {

    @Insert
    public  long addStudent(Student student);

    @Update
    public void updateStudent(Student student);

    @Delete
    public void deleteStudent(Student student);

    @Query("select * from students")
    public List<Student> getStudents();

    @Query("select * from students where student_id ==:studentId")
    public Student getStudent(long studentId);

}
