package edu.handong.analysis.datamodel;

public class Course{
    private String courseName; 

    //Constructor of the class Course
    public Course(String name)
    {
        this.courseName = name;
    }
    
    //getter method of the Course class
    public String getCourseName()
    {
        return this.courseName;
    }
}