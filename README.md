# Course Registration Waiting List

This repository contains the code for a Course Registration Waiting List application developed by Rafael Hidalgo. The application is designed to manage a waiting list of students who wish to register for a course. Users can add students to the waiting list, view the list, and remove students from it.

## Key Features

1. **Add Students**: Users can add students to the waiting list by providing their name and email.
2. **View Waiting List**: The main screen displays a list of students currently on the waiting list.
3. **Remove Students**: Users can remove students from the waiting list.

## Code Structure

- [MainActivity.java](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/master/app/src/main/java/com/example/courseregistrationwaitinglistrafaelhidalgo/MainActivity.java): This is the main activity of the application. It handles the user interface interactions and manages the list of students.
  
- [StudentsAdapter.java](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/master/app/src/main/java/com/example/courseregistrationwaitinglistrafaelhidalgo/adapter/StudentsAdapter.java): This adapter class is responsible for displaying the list of students in a RecyclerView.
  
- [StudentDAO.java](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/master/app/src/main/java/com/example/courseregistrationwaitinglistrafaelhidalgo/db/StudentDAO.java) & [StudentsAppDatabase.java](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/master/app/src/main/java/com/example/courseregistrationwaitinglistrafaelhidalgo/db/StudentsAppDatabase.java): These classes are related to the database operations. The DAO (Data Access Object) provides methods to interact with the database, and the AppDatabase class sets up the Room database.
  
- [Student.java](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/master/app/src/main/java/com/example/courseregistrationwaitinglistrafaelhidalgo/db/entity/Student.java): This is the entity class representing a student. It contains attributes like name and email.
  
- Layout Files:
  - [activity_main.xml](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/master/app/src/main/res/layout/activity_main.xml): Main layout file for the application.
  - [content_main.xml](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/master/app/src/main/res/layout/content_main.xml): Layout for the main content.
  - [layout_add_student.xml](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/master/app/src/main/res/layout/layout_add_student.xml): Layout for adding a new student.
  - [student_list_item.xml](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/master/app/src/main/res/layout/student_list_item.xml): Layout for each student item in the list.

## Conclusion

This application serves as a simple yet effective tool for managing a course registration waiting list. It demonstrates the use of Android's Room database for data persistence and showcases the implementation of CRUD operations in a mobile application.
