

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

import java.io.*;
import java.util.*;

/**
 * Created by Raspik on 18.02.2016.
 */
public class Menu implements Serializable {
int b;
    public void interfaceTable() {
        do {
            System.out.println("Выберете пункт меню");
            System.out.println("1 Создание курса ");
            System.out.println("2. Вывод подробной информации о курсе по его идентификатору");
            System.out.println("3. Вывод списка названий всех курсов");
            System.out.println("4. Создание студента в рамках определенного курса(ов)");
            System.out.println("5. Перевод студента из одного курса на другой");
            System.out.println("6. Вывод информации о студенте по его идентификатору");
            System.out.println("7. Создание тренера в рамках определенного курса(ов)");
            System.out.println("8. Вывод информации о тренере по его идентификатору");
            System.out.println("9. Создание задач в рамках определенного курса");
            System.out.println("10. Вывод имен и фамилий всех студентов по идентификатору курса");
            System.out.println("11. Вывод журнала успеваемости определенного курса");
            System.out.println("12. Сохранение журнала успеваемости в файл");
            System.out.println("13. LoadData");
            System.out.println("14. exit");

            System.out.println("Введите команду");

         b = new Scanner(System.in).nextInt();
            switch (b) {
                case 1:Creater.createCourse();break;
                case 2: Show.showCourseInformationById(); break;
                case 3: Show.showAllCourses();break;
                case 4:Creater.createStud();break;
                case 5:ChangeCourse.ChangeCourseForStud();break;
                case 6:Show.showStudentInformationById(); break;
                case 7: Creater.createTeacher(); break;
                case 8: Show.showTeacherInformationById(); break;
                case 9:Creater.createExercise(); break;
                case 10:Show.showAllStudentsOnCourseById();break;
                case 11:Show.showJournal(); break;
                case 12:DataManagement.saveData();break;
                case 13:DataManagement.loadData(); break;
                case 15:ChangeCourse.changeCourseForTeacher(); break;


            }
        } while (b != 14);
        System.out.println("GoodBye");
    }
}
