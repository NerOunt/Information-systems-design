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

        System.out.println("Полные данные студента:");
        System.out.println(student.toFullString());
        System.out.println("Краткие данные студента:");
        System.out.println(student.toShortString());
        System.out.println("Студент из строки:");
        System.out.println(studentFromLine.toFullString());
        System.out.println("Студент из JSON:");
        System.out.println(studentFromJson.toFullString());
        System.out.println("Студенты совпадают по телефону: "
                + (student.isSameStudent(studentFromLine) ? "да" : "нет"));
    }
}


