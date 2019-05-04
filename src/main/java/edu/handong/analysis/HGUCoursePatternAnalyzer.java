package edu.handong.analysis;
import java.lang.String;
import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
 
class HGUCoursePatternAnalyzer {
    private String[] lines = {
    		"1999-1, JC Nam, Java Programming",
    		"1999-2, JC Nam, Programming Language Theory",
            "1999-1, JC Nam, Data Structures",
            "2001-1, JC Nam, Database Systems",
            "2018-1, SB Lim, Java Programming",
            "2018-2, SB Lim, Programming Language Theory",
            "2019-1, SB Lim, Data Structures",
            "2019-1, SB Lim, Algorithm Analysis",
            "2018-1, SJ Kim, Java Programming",
            "2018-2, SJ Kim, Programming Language Theory",
            "2019-1, SJ Kim, Logic Design",
            "2019-1, SJ Kim, Algorithm Analysis",
            };
    
    private int numOfStudents;			//number of students. received by passing arguments
    private int numOfCourses;			//number of courses. received by passing arguments.
    Student[] students;					//instance array of Student class
    Course[] courses;					//instance array of Course class
    int cnt;							

    /**
     * This method runs our analysis logic to get the list of student and course
     * names from lines.
     * 
     * @param args
     */
    public void run(String[] args) {
        numOfStudents = Integer.parseInt(args[0]); //receiving the first argument
        numOfCourses = Integer.parseInt(args[1]); //receiving the second argument

        initiateStudentArrayFromLines(lines); // initializing Student class's instance array
        initiateCourseArrayFromLines(lines);  // initializing Course class's instance array
        
        System.out.println("Number of All Students: " + numOfStudents);
 
        for(int t = 0; t < students.length; t++)
        { 
        	cnt = t;
        	if(!(studentExist(students, students[t])))	//check if there's duplicate student instance
        	{
        		System.out.println(students[t].getName()); //if there's not, print out the name of the student.
        	}
        }
        
        System.out.println("Number of All Courses: " + numOfCourses);
        for(int t = 0; t < courses.length; t++)
        {
        	cnt = t;
        	if(!(courseExist(courses, courses[t])))	//check if there's duplicate course instance
        	{
        		System.out.println(courses[t].getCourseName());//if there's not, print out the name of the course.
        	}
        }
    }
    
    /**
     * This method returns a Student array to initiate the field, students, from
     * lines.
     * 
     * @param lines
     * @return
     */
    private Student[] initiateStudentArrayFromLines(String[] lines) {
    	students = new Student[lines.length];
        for (int i = 0; i < lines.length; i++) {
            students[i] = new Student(lines[i].substring(lines[i].indexOf(", ")+2, lines[i].lastIndexOf(", ")));//trimming string by using substring so I can get student name
        }
        return null;
    }
    
    /**
     * This method check if there is the same name of the second argument in the
     * array, students
     * 
     * @param students
     * @param student
     * @return boolean
     */
    private boolean studentExist(Student[] students, Student student) {
    	for(int i = cnt-1; i > -1; i--) //check array index from 'cnt-1' to -1
    	{
    		if(students[i].getName().equals(student.getName()))		//if there's duplicate in existing array
    		{
    			return true;
   			}
    		else		//if there's no duplicate in existing array
    		{
    			continue;
    		}
    	}
    	
    	return false;
    }
    
    /**
     * This method returns a Course array to initiate the field, courses, from
     * lines.
     * 
     * @param lines
     * @return
     */
    private Course[] initiateCourseArrayFromLines(String[] lines) {
        courses= new Course[lines.length];
        for (int i = 0; i < lines.length; i++) {
            courses[i] = new Course(lines[i].substring(lines[i].lastIndexOf(", ")+2, lines[i].length())); //trimming string by using substring so I can get course name
        }
        
        for (int i = 0; i < courses.length; i++) {
            courseExist(courses, courses[i]);
        }
        
        return null;
    }
    
    /**
     * This method check if there is the same name of the second argument in the
     * array, courses.
     * 
     * @param courses
     * @param course
     * @return boolean
     */
    private boolean courseExist(Course[] courses, Course course) {
    	for(int i = cnt-1; i > -1; i--) //check array index from 'cnt-1' to -1
    	{
    		if(courses[i].getCourseName().equals(course.getCourseName()))		//if there's duplicate in existing array
    		{
    			return true;
   			}
    		else		//if there's no duplicate in existing array
    		{
    			continue;
    		}
    	}
        return false;
    }
}