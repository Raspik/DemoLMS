

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Raspik on 18.02.2016.
 */
public class Student implements Serializable{
    String firstName;
    String lastName;
//Course[] course = new Course[3];
   List<Course> myCourse = new ArrayList<Course>();
    List<Exercise> myExercise = new ArrayList<Exercise>();
    int  stopAdd = 1;
    static int id = 1;
    int myId;
    boolean stopAddtoCourse = false;
    public Student(String firstName,String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        myId = id;
        id++;
        System.out.println(firstName+" "+lastName + myId+" was added to Base");

    }

    public static void serializeStatic(ObjectOutputStream oos) throws IOException {
        oos.writeInt(id);
    }
    public static void deserializeStatic(ObjectInputStream ois) throws IOException {
        id=ois.readInt();
    }

    @Override
    public String toString() {

        return
                 firstName+ " "+lastName+" id:"+myId;
    }
}
