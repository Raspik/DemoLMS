

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by raspik on 25.02.16.
 */
public class DataManagement implements Serializable {
    public static Object deserData(String file_name) {
        Object retObject = null;
        try {
            FileInputStream fileIn = new FileInputStream(file_name + ".txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Course.deserializeStatic(in);
            Student.deserializeStatic(in);
            Teacher.deserializeStatic(in);
            Exercise.deserializeStatic(in);
            retObject = in.readObject();
            fileIn.close();
            in.close();

        } catch (FileNotFoundException al) {
            System.out.println("File not foun");
            System.exit(3);
        } catch (IOException a) {
            System.exit(4);
        } catch (ClassNotFoundException a) {
            System.exit(5);
        }
        return retObject;
    }

    public static void serData(String file_name, Object obj) {
        try {
            FileOutputStream fileout = new FileOutputStream(file_name + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            Course.serializeStatic(out);
            Student.serializeStatic(out);
            Teacher.serializeStatic(out);
            Exercise.serializeStatic(out);
            out.writeObject(obj);
            fileout.close();
            out.close();
        } catch (FileNotFoundException a) {
            System.out.println("Файл не найден");
            System.exit(1);
        } catch (IOException a) {
            System.out.println("Ошибка ввода.вывода");
            System.exit(2);
        }
    }

    public static void saveData() {
        serData("profiles", Storage.courseList);
        serData("profiles2", Storage.studentList);
        serData("profiles3", Storage.teacherList);
    }

    public static void loadData() {
        Storage.courseList = (ArrayList<Course>) deserData("profiles");
        Storage.studentList = (ArrayList<Student>) deserData("profiles2");
        Storage.teacherList = (ArrayList<Teacher>) deserData("profiles3");
    }
}