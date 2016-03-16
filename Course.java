

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Raspik on 18.02.2016.
 */
public class Course implements Serializable{
  static   int id = 1; // поменять на 1
    String name;

  //  Collection<Student> studentsCollection = new ArrayList<>();
String startData;
    String endData;
String daysOfWeek;
    String aboutCourse;
int myId;
   // int mark = 0;
   List<Student> studentsOnCurrentCourse = new ArrayList<Student>();
    List<Exercise> exerciseOnCourse = new ArrayList<Exercise>();
List<Teacher> teachersOnCourse = new ArrayList<Teacher>();
    Map<Student,List<Exercise>> journalOfCourse = new HashMap<Student,List<Exercise>>();


    public Course(String name,String aboutCourse,
         String startData,String endData,
                   String daysOfWeek
    ) {
        this.name = name;
        this.aboutCourse = aboutCourse;
        this.startData = startData;
        this.endData = endData;
this.daysOfWeek = daysOfWeek;
      myId = id;
        id++;


        System.out.println("New course has been successfully created");
    }
    public static void serializeStatic(ObjectOutputStream oos) throws IOException{
        oos.writeInt(id);
    }
    public static void deserializeStatic(ObjectInputStream ois) throws IOException {
        id=ois.readInt();
    }


    @Override
    public String toString() {
        return "Course ID" +myId+"  Course name: "+name+"\n"
                ;
    }

}
