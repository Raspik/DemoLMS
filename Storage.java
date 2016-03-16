

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raspik on 02.03.2016.
 */
public class Storage implements Serializable {
    static List<Course> courseList = new ArrayList<Course>();
    static List<Student> studentList = new ArrayList<Student>();
    static List<Teacher> teacherList = new ArrayList<Teacher>();
}
