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
                "Петров;Петр;Петрович;Казань, ул. Мира, д. 5;+79997654321"
        );

        JsonObject json = new JsonObject();
        json.addProperty("lastName", "Сидоров");
        json.addProperty("firstName", "Сидор");
        json.addProperty("patronymic", "Сидорович");
        json.addProperty("address", "Самара, ул. Полевая, д. 7");
        json.addProperty("phone", "+79990000002");
        Student studentFromJson = new Student(json);

        System.out.println("Студент из обычного конструктора:");
        printStudent(student);
        System.out.println("Студент из строки:");
        printStudent(studentFromLine);
        System.out.println("Студент из JSON:");
        printStudent(studentFromJson);
        System.out.println("Общий минимум факультативов: " + Rules.MINIMUM_ELECTIVES);
    }

    private static void printStudent(Student student) {
        System.out.println(
                student.getLastName() + " "
                        + student.getFirstName() + " "
                        + student.getPatronymic()
                        + ", адрес: " + student.getAddress()
                        + ", телефон: " + student.getPhone()
        );
    }
}

