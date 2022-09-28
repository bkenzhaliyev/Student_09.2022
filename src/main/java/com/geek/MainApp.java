package com.geek;

import com.geek.models.Gender;
import com.geek.models.Student;
import com.geek.services.GenderService;
import com.geek.services.StudentService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class MainApp {
/* По  правильному все надо было сделать через интерфейсы
но в торопился
 */
    public static void main(String[] args) throws SQLException {
        GenderService genderService = new GenderService();
        List<Gender> genders = genderService.findAllGender();
        Gender gender1 = genderService.findGender(1);
        Gender gender2 = genderService.findGender(2);


 /* Вставка записи в таблицу Gender
//        Gender gender = new Gender("Муж");
//        genderService.saveGender(gender);
//        gender.setGender("Жен");
//        genderService.saveGender(gender);
/ Выборка по названию пола
//        Gender gender = genderService.findGenderTitle("Жен");
//        System.out.println(gender);

//        for (int i = 0; i < genders.size(); i++) {
//            Gender gender = genders.get(i);
//            System.out.println(gender);
//        }
*/

        StudentService studentService = new StudentService();

//        Вызов метода вставки записей в таблицу Student
//        addStudent(gender1, gender2, studentService);

//      Поиск студентов по дате рождения
//        List<Student> students = studentService.findStudentByBirthdayBetween(LocalDate.of(2000, 01, 01), LocalDate.of(5100, 12, 12));

//      Поиск студентов по полу -  в данном случае - Жен
//        List<Student> students = studentService.findStudentByGender(gender2);

//      Вывод всех студентов
        List<Student> students = studentService.findAllStudent();
        Student studentUpd = students.get(100);

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println(student);
        }

//      Метод обновления данных студента
        updateStudent(studentService, studentUpd);

//        Метод удаления студентов
//        deleteStudent(studentService, students);
    }

/*  Вставка записей таблицу Student
    Считаю передачу в метод класса Gender - Муж, Жен не очень удачным.
    Буду рад подсказке
 */
    public static void addStudent(Gender gM, Gender gW, StudentService studentService) {
        List<Student> students = null;
        for (int i = 0; i < 1000; i++) {
//            Генерация случайных данных - дата, пол - 1 - Муж, 2 - Жен
            int year = (int) (2000 + Math.random()*6);
            int month = (int) (1 + Math.random()*12);
            int day = (int) (1 + Math.random()*25);
            int gRandom = (int) (1 + Math.random()*2);

//     Лень было более осмысленные ФИО придумывать
//     Лень двигатель прогресса...
            Student student = new Student();
            student.setFirstName("firstName_" + i);
            student.setName("name_" + i);
            student.setMiddleName("middleName_" + i);
            student.setBirthday(LocalDate.of(year, month, day));
            if (gRandom == 1) {
                student.setGender(gM);
            } else {
                student.setGender(gW);
            }
            studentService.saveStudent(student);
        }
    }


/* Удаление студентов из БД
 */
    public static void deleteStudent(StudentService studentService, List<Student> students){
        System.out.println("Удаление студентов");
        for (int i = 0; i < students.size(); i++) {
         Student student = students.get(i);
         studentService.deleteStudent(student);
            System.out.printf("Студент с id = %s удален\n", String.valueOf(student.getId()));
        }
    }

    //Метод удаления студентов списком
    public static void updateStudent(StudentService studentService, Student student){
        if(student!=null){
            student.setName("New name");
            student.setBirthday(LocalDate.of(2008, 12, 31));
            student.setFirstName("Updated First Name");
            studentService.updateStudent(student);
            Student studentUpd = studentService.findStudent(student.getId());
            System.out.printf("Обновление данных студент с id = %s\n", student.getId());
            System.out.println(studentUpd);
        }

    }
}
