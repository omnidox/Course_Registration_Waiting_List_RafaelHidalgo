# Course Registration Waiting List

This repository contains a simple Android application that manages a waiting list for course registration. The application allows users to add students to a waiting list, view the list of students, and delete students from the list.

## Functionality

- **Add Students**: Users can add students to the waiting list by providing their name and course details.
- **View Students**: The main screen displays a list of students who are currently on the waiting list.
- **Delete Students**: Users can remove students from the waiting list.

## Code Structure

- [`MainActivity.java`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/java/com/example/courseregistrationwaitinglistrafaelhidalgo/MainActivity.java): This is the main activity of the application. It handles the user interactions and displays the list of students.
  
- [`StudentsAdapter.java`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/java/com/example/courseregistrationwaitinglistrafaelhidalgo/adapter/StudentsAdapter.java): An adapter class that binds the student data to the RecyclerView for displaying the list of students.
  
- [`StudentDAO.java`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/java/com/example/courseregistrationwaitinglistrafaelhidalgo/db/StudentDAO.java) & [`StudentsAppDatabase.java`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/java/com/example/courseregistrationwaitinglistrafaelhidalgo/db/StudentsAppDatabase.java): These files are related to the database operations. The DAO (Data Access Object) provides methods for accessing the database, and the AppDatabase initializes the database.
  
- [`Student.java`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/java/com/example/courseregistrationwaitinglistrafaelhidalgo/db/entity/Student.java): This is the entity class that represents a student in the database.
  
- Layout Files:
  - [`activity_main.xml`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/res/layout/activity_main.xml): Layout for the main activity.
  - [`content_main.xml`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/res/layout/content_main.xml): Content layout for the main activity.
  - [`layout_add_student.xml`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/res/layout/layout_add_student.xml): Layout for adding a student.
  - [`student_list_item.xml`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/res/layout/student_list_item.xml): Layout for each student item in the list.

- Resources:
  - [`colors.xml`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/res/values/colors.xml), [`strings.xml`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/res/values/strings.xml), [`styles.xml`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/res/values/styles.xml), and [`themes.xml`](https://github.com/omnidox/Course_Registration_Waiting_List_RafaelHidalgo/blob/main/app/src/main/res/values/themes.xml): These files contain various resources used in the application such as string values, colors, styles, and themes.

## Conclusion

The application serves as a simple tool for managing a course registration waiting list. It demonstrates the use of Android's RecyclerView, database operations using Room persistence library, and user interactions in an Android application.
