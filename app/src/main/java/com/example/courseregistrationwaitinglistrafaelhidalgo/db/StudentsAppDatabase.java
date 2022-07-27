package com.example.courseregistrationwaitinglistrafaelhidalgo.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.courseregistrationwaitinglistrafaelhidalgo.db.entity.Student;

@Database(entities = {Student.class},version = 1)
public abstract class StudentsAppDatabase extends RoomDatabase {

    public abstract StudentDAO getStudentDAO();

}
