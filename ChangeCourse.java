

import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Raspik on 25.02.2016.
 */
public class ChangeCourse {


    public static void ChangeCourseForStud() {
        System.out.println("Введите Ид студента");
        int x = new Scanner(System.in).nextInt();
        Iterator<Student> iterator = Storage.studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.myId == x) {
                System.out.println("Студент найден");
                System.out.println("1 удалить с курса");
                System.out.println("2 записать на  курс");
                int x2 = new Scanner(System.in).nextInt();
                if (x2 == 1) {
                    System.out.println("С какого курса удалить");
                    int x3 = new Scanner(System.in).nextInt();
                    Iterator<Course> courseIterator = Storage.courseList.iterator();
                    while (courseIterator.hasNext()) {
                        Course course = courseIterator.next();
                        if (course.myId == x3) {

                            System.out.println("course.studentsOnCurrentCourse = " + course.studentsOnCurrentCourse);
                            System.out.println(course.studentsOnCurrentCourse.remove(student));
                            System.out.println("Удален");

                        }
                    }

                } else if (x2 == 2) {

                    System.out.println("На какой курс добавить");
                    int x3 = new Scanner(System.in).nextInt();
                    Iterator<Course> courseIterator = Storage.courseList.iterator();
                    while (courseIterator.hasNext()) {
                        Course course = courseIterator.next();
                        if (course.myId == x3) {
                            if (course.studentsOnCurrentCourse.contains(student)) {
                                System.out.println("Существует");
                            }
                            System.out.println(course.studentsOnCurrentCourse.add(student));
                            System.out.println("Добавлен");

                        }
                    }
                }
            }


        }
    }


    public static void changeCourseForTeacher() {
        System.out.println("Введите Ид преподавателя");
        int x = new Scanner(System.in).nextInt();
        Iterator<Teacher> iterator = Storage.teacherList.iterator();
        while (iterator.hasNext()) {
            Teacher teacher = iterator.next();
            if (teacher.myId == x) {
                System.out.println("Преподаватель найден");
                System.out.println("1 удалить с курса");
                System.out.println("2 записать на  курс");
                int x2 = new Scanner(System.in).nextInt();
                if (x2 == 1) {
                    System.out.println("С какого курса удалить");
                    int x3 = new Scanner(System.in).nextInt();
                    Iterator<Course> courseIterator = Storage.courseList.iterator();
                    while (courseIterator.hasNext()) {
                        Course course = courseIterator.next();
                        if (course.myId == x3) {

                            System.out.println("course.teachersOnCourse = " + course.teachersOnCourse);
                            System.out.println(course.teachersOnCourse.remove(teacher));
                            System.out.println("Удален");

                        }
                    }

                } else if (x2 == 2) {

                    System.out.println("На какой курс добавить");
                    int x3 = new Scanner(System.in).nextInt();
                    Iterator<Course> courseIterator =Storage.courseList.iterator();
                    while (courseIterator.hasNext()) {
                        Course course = courseIterator.next();
                        if (course.myId == x3) {
                            if (course.teachersOnCourse.contains(teacher)) {
                                System.out.println("Существует");
                            }
                            System.out.println(course.teachersOnCourse.add(teacher));
                            System.out.println("Добавлен");

                        }
                    }
                }
            }


        }
    }
}
