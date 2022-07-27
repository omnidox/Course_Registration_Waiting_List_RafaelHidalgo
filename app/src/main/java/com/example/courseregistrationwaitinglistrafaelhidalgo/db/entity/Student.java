package com.example.courseregistrationwaitinglistrafaelhidalgo.db.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity(tableName = "students")

public class Student {


    @ColumnInfo(name="student_name")
    private String name;

    @ColumnInfo(name="student_email")
    private String email;

    @ColumnInfo(name="student_level")
    private String level;

    @ColumnInfo(name="student_id")
    @PrimaryKey(autoGenerate =true)
    private long id;


    @Ignore
    public Student() {
    }



    public Student(long id, String name, String email, String level) {

        this.name = name;
        this.email = email;
        this.level = level;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
