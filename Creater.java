

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Raspik on 25.02.2016.
 */
public class Creater implements Serializable {
    static String daysWeek;
    static String startData;
    static String endData;

    public static void createCourse() {
        System.out.println("Input name of the course");
        String c = new Scanner(System.in).nextLine();
        Iterator<Course> courseIterator = Storage.courseList.iterator();
        while(courseIterator.hasNext()){
            Course course = courseIterator.next();
            if(course.name.equals(c)){
                System.err.println("Курс с таким названием уже существует");
                return;
            }
        }
        System.out.println("Course description");
        String d = new Scanner(System.in).nextLine();
          createDaysOfWeeek();
        startData();
        endData();
        Storage.courseList.add(new Course(c, d,daysWeek,startData,endData));
        System.out.println("1 если хотите вернуться в меню");
        System.out.println("2 создать еще один курс");
        int exitSubMenu = new Scanner(System.in).nextInt();
        if (exitSubMenu == 1) {
            return;
        } else if (exitSubMenu == 2) {
            createCourse();
        }

    }

    public static void createStud() {
        System.out.println("ИД курса");
        int x = new Scanner(System.in).nextInt();
        /////////
        Iterator<Course> iter = Storage.courseList.iterator();
        while (iter.hasNext()) {
            Course course = iter.next();
            if (course.myId == x) {
                if(course.studentsOnCurrentCourse.size()>12){
                    System.err.println("Переполнение курса");
                    return;
                }
                System.out.println("Input name of the student");
                String c = new Scanner(System.in).nextLine();
                System.out.println("surname");
                String d = new Scanner(System.in).nextLine();
                Student newStudent = new Student(c, d);
                course.studentsOnCurrentCourse.add(newStudent);
                Storage.studentList.add(newStudent);
            }
        }

        System.out.println("1 - создать нового студента");
        System.out.println("2 - вернуться в меню");

        int b = new Scanner(System.in).nextInt();
        if (b == 1) {
            createStud();
        } else if (b == 2) {
            return;
        }
    }

    public static void createTeacher() {
        System.out.println("ИД курса");
        int x = new Scanner(System.in).nextInt();
        /////////
        Iterator<Course> iter = Storage.courseList.iterator();
        while (iter.hasNext()) {
            Course course = iter.next();
            if (course.myId == x) {
                System.out.println("Input name of the teacher");
                String c = new Scanner(System.in).nextLine();
                System.out.println("surname");
                String d = new Scanner(System.in).nextLine();

                Teacher newTeacher = new Teacher(c, d);

                course.teachersOnCourse.add(newTeacher);
                Storage.teacherList.add(newTeacher);
     break;       }
        }

        /////////////
        System.out.println("1 - создать нового учителя");
        System.out.println("2 - вернуться в меню");

        int b = new Scanner(System.in).nextInt();
        if (b == 1) {
            createTeacher();
        } else if (b == 2) {
            return;
        }
    }

    public static void createExercise() {
        System.out.println("ИД курса");
        int x = new Scanner(System.in).nextInt();
        /////////
        Iterator<Course> iter = Storage.courseList.iterator();
        while (iter.hasNext()) {
            Course course = iter.next();
            if (course.myId == x) {
                System.out.println("name of exercise");
                String c = new Scanner(System.in).nextLine();
                System.out.println("описание");
                String d = new Scanner(System.in).nextLine();
                Exercise newExercise = new Exercise(c, d);
                course.exerciseOnCourse.add(newExercise);

            }
        }

        /////////////
        System.out.println("1 - создать новую задачу");
        System.out.println("2 - вернуться в меню");

        int b = new Scanner(System.in).nextInt();
        if (b == 1) {
            createExercise();
        } else if (b == 2) {
            return;
        }
    }

    public static void createDaysOfWeeek() {
        int b = 0;
        String daysOfWeek[] = new String[7];
        daysOfWeek[0] = "MON";
        daysOfWeek[1] = "TUE";
        daysOfWeek[2] = "WED";
        daysOfWeek[3] = "THU";
        daysOfWeek[4] = "FRI";
        daysOfWeek[5] = "SAT";
        daysOfWeek[6] = "SUN";
        System.out.println("Список сокращенных дней недели");
        System.out.println(Arrays.toString(daysOfWeek));
        System.out.println("Введите дни когда будут курсы в формате ***,***,***...");
        String s = new Scanner(System.in).nextLine();
        String[] values;
        values = s.split("[,]");

        boolean testDay = true;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                for (int j = 0; j < daysOfWeek.length; j++) {
                    if (values[i].equals(daysOfWeek[j])) {
                        testDay = true;
                        break;
                    } else {
                        testDay = false;
                    }
                }
            }
            if (!testDay) {
                System.err.println(values[i] + " не есть день недели");
                System.out.println("Попробуйте ввести еще раз");
                createDaysOfWeeek();
                break;
            }
        }
        daysWeek = Arrays.toString(values);
    }
    public static void startData(){
        int b = 0;

        System.out.println("Введите дату начала курса ***,***,***");
        String s = new Scanner(System.in).nextLine();
        String[] values;
        values = s.split("[,]");
        if(values.length!=3){
            System.err.println("Неправильный ввод данных");
        }
        startData = Arrays.toString(values);
    }
    public static void endData(){
        int b = 0;

        System.out.println("Введите дата окончания курса ***,***,***");
        String s = new Scanner(System.in).nextLine();
        String[] values;
        values = s.split("[,]");
        if(values.length!=3){
            System.err.println("Неправильный ввод данных");
        }
        endData = Arrays.toString(values);
    }
}

