

import java.io.Serializable;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Raspik on 01.03.2016.
 */
public class Show implements Serializable {
    public static void showCourseInformationById() {
        System.out.println("Введите Ид курса");
        int x = new Scanner(System.in).nextInt();
        Iterator<Course> courseIterator =Storage.courseList.iterator();
        while (courseIterator.hasNext()) {
            Course course = courseIterator.next();
            if (course.myId == x) {
                System.out.print("Course name:\t\t"+course.name+"\n" +
                        "Course description:\t"+course.aboutCourse+"\n"+
                        "Start date:\t\t\t"+course.startData+"\n"+
                        "End date:\t\t\t"+course.endData+"\n"
                        +"Days:\t\t\t \t"+course.daysOfWeek+"\n");
                System.out.println("Список задач на курсе "+course.exerciseOnCourse);

            }
        }
        System.out.println("1 что бы вернуться в меню");
        if(new Scanner(System.in).nextInt()==1){
            return;
        }

    }

    public static void showStudentInformationById() {
        System.out.println("Введите ИД студента");
        int x = new Scanner(System.in).nextInt();
        Iterator<Student> studentIterator = Storage.studentList.iterator();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            if (student.myId == x) {
                System.out.println(student);


                System.out.print("My course list: ");
                for (Course elem : Storage.courseList) {
                    if (elem.studentsOnCurrentCourse.contains(student)) {
                        System.out.print("[" + elem.name + "] ");
                    }
                }
                System.out.println();
                System.out.print("My task list:");
                for (Course elem : Storage.courseList) {
                    if (elem.studentsOnCurrentCourse.contains(student)) {
                        System.out.print(elem.exerciseOnCourse+" ");
                    }

                }
            }

        }
        System.out.println("1 что бы вернуться в меню");
        if(new Scanner(System.in).nextInt()==1){
            return;
        }
    }

    public static void showTeacherInformationById() {
        System.out.println("Введите ИД преподавателя");
        int x = new Scanner(System.in).nextInt();
        Iterator<Teacher> teacherIterator = Storage.teacherList.iterator();
        while (teacherIterator.hasNext()) {
            Teacher teacher = teacherIterator.next();
            if (teacher.myId == x) {
                System.out.println(teacher);
                System.out.print("My course list: ");
                for (Course elem : Storage.courseList) {
                    if (elem.teachersOnCourse.contains(teacher)) {
                        System.out.print("[" + elem.name + "]");
                    }
                    System.out.println();
                }
            }
        }
        System.out.println("1 что бы вернуться в меню");
        if(new Scanner(System.in).nextInt()==1){
            return;
        }
    }

    public static void showAllStudentsOnCourseById() {
        System.out.println("Введите ИД курса");
        int x = new Scanner(System.in).nextInt();
        Iterator<Course> crs = Storage.courseList.iterator();
        while (crs.hasNext()) {
            Course cc = crs.next();
            if (cc.myId == x) {
                System.out.println(cc.studentsOnCurrentCourse);
            }
        }
        System.out.println("1 что бы вернуться в меню");
        if(new Scanner(System.in).nextInt()==1){
            return;
        }
    }

    public static void showJournal() {
        System.out.println("введите ИД курса");
        int x = new Scanner(System.in).nextInt();
        Random random = new Random();
        Iterator<Course> iter = Storage.courseList.iterator();

        while (iter.hasNext()) {
            Course course = iter.next();
            if (course.myId == x) {
                Iterator<Student> iter2 = course.studentsOnCurrentCourse.iterator();
                while (iter2.hasNext()) {
                    Student student = iter2.next();
                    course.journalOfCourse.put(student, course.exerciseOnCourse);
                    for (Exercise ex : course.exerciseOnCourse) {
                        ex.mark = random.nextInt(100);
                    }
             }
            }
            System.out.println(course.journalOfCourse);
        }
        System.out.println("1 что бы вернуться в меню");
        if(new Scanner(System.in).nextInt()==1){
            return;
        }

    }

    public static void showAllCourses() {
        int a = 1;
        Iterator<Course> courseIterator = Storage.courseList.iterator();
        while (courseIterator.hasNext()) {
            Course course = courseIterator.next();
            System.out.println(a++ +". "+course.name);
        }

        System.out.println("1 что бы вернуться в меню");
        if (new Scanner(System.in).nextInt() == 1) {
            return;
        }
    }
}
