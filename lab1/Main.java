import com.google.gson.JsonObject;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(
                "Иванов",
                "Иван",
                "Иванович",
                "Москва, ул. Лесная, д. 10",
                "+79991234567"
        );

        Student studentFromLine = new Student(
                "Петров;Петр;Петрович;Казань, ул. Мира, д. 5;+79991234567"
        );

        JsonObject json = new JsonObject();
        json.addProperty("lastName", "Сидоров");
        json.addProperty("firstName", "Сидор");
        json.addProperty("patronymic", "Сидорович");
        json.addProperty("address", "Самара, ул. Полевая, д. 7");
        json.addProperty("phone", "+79990000002");
        Student studentFromJson = new Student(json);

        System.out.println("Студент из обычного конструктора:");
        System.out.println(student.toFullString());
        System.out.println("Студент из строки:");
        System.out.println(studentFromLine.toFullString());
        System.out.println("Студент из JSON:");
        System.out.println(studentFromJson.toFullString());

        System.out.println("Данные после вызова геттеров:");
        System.out.println("Фамилия: " + student.getLastName());
        System.out.println("Имя: " + student.getFirstName());
        System.out.println("Отчество: " + student.getPatronymic());
        System.out.println("Адрес: " + student.getAddress());
        System.out.println("Телефон: " + student.getPhone());

        System.out.println("Студент и студент из строки совпадают по телефону: "
                + (student.isSameStudent(studentFromLine) ? "да" : "нет"));

        student.setLastName("Смирнов");
        student.setFirstName("Алексей");
        student.setPatronymic("Сергеевич");
        student.setAddress("Москва, ул. Новая, д. 15");
        student.setPhone("+79997654321");

        System.out.println("Данные после вызова сеттеров:");
        System.out.println(student.toFullString());
        System.out.println("Краткие данные студента: " + student.toShortString());

        System.out.println("Проверка фамилии: " + Student.isValidName(student.getLastName()));
        System.out.println("Проверка адреса: " + Student.isValidAddress(student.getAddress()));
        System.out.println("Проверка телефона: " + Student.isValidPhone(student.getPhone()));

        Mapper mapper = new Mapper();
        StudentShort shortStudent = mapper.toShortStudent(student);
        System.out.println("Краткий объект: " + shortStudent.toShortString());
        System.out.println("Данные краткого объекта после вызова геттеров:");
        System.out.println("Имя: " + shortStudent.getName());
        System.out.println("Телефон: " + shortStudent.getPhone());

        System.out.println("2 завершенных факультатива: минимум "
                + (student.hasCompletedMinimumElectives(2) ? "выполнен" : "не выполнен"));
        System.out.println("3 завершенных факультатива: минимум "
                + (student.hasCompletedMinimumElectives(3) ? "выполнен" : "не выполнен"));
        System.out.println("Общий минимум факультативов: " + Rules.MINIMUM_ELECTIVES);
    }
}


