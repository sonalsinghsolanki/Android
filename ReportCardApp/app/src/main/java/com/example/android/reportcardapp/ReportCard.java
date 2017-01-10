package com.example.android.reportcardapp;

/**
 * Report Card class
 * mCourseName is a private String variable for Course name
 * mCourseMarks is a private Double variable for marks scored by a student in a particular subject
 * mCourseGrades is a private String variable for grades scored by a student in a particular subject
 * mCourseCredits is a private Double variable for credits scored by a student in a particular subject
 */
public class ReportCard {
    private String mCourseName;
    private double mCourseMarks;
    private String mCourseGrades;
    private double mCourseCredits;

    //Class constructor for the Report card class to add values for the variables defined as private
    public ReportCard(String courseName, double courseMarks, String courseGrades, double courseCredits) {
        mCourseName = courseName;
        mCourseMarks = courseMarks;
        mCourseGrades = courseGrades;
        mCourseCredits = courseCredits;
    }

    @Override
    public String toString() {
        return "Course Name: " + mCourseName + "Course Marks: " + mCourseMarks + "Course Grades: " + mCourseGrades + "Course Credits :" + mCourseCredits;
    }

    //Setter method to access or set private variable mCoursename
    public void setCourseName(String courseName) {
        mCourseName = courseName;
    }

    //Setter method to access or set private variable mCourseMarks
    public void setCourseMarks(double courseMarks) {
        mCourseMarks = courseMarks;
    }

    //Setter method to access or set private variable mCourseGrades
    public void setCourseGrades(String courseGrades) {
        mCourseGrades = courseGrades;
    }

    //Setter method to access or set private variable mCourseCredits
    public void setCourseCredits(double courseCredits) {
        mCourseCredits = courseCredits;
    }

    //Getter method to access or get private variable mCoursename
    public String getCourseName() {
        return mCourseName;
    }

    //Getter method to access or get private variable mCourseMarks
    public double getCourseMarks() {
        return mCourseMarks;
    }

    //Getter method to access or get private variable mCourseGrades
    public String getCourseGrades() {
        return mCourseGrades;
    }

    //Getter method to access or get private variable mCourseCredits
    public double getCourseCredits() {
        return mCourseCredits;
    }

}
