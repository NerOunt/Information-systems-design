public class Main {
    public static void main(String[] args) {
        Student student = new Student(
                "Иванов",
                "Иван",
                "Иванович",
                "Москва, ул. Лесная, д. 10",
                "+79991234567"
        );

        System.out.println("Данные после вызова геттеров:");
        printStudent(student);

        student.setLastName("Петров");
        student.setFirstName("Петр");
        student.setPatronymic("Петрович");
        student.setAddress("Казань, ул. Мира, д. 5");
        student.setPhone("+79997654321");

        System.out.println("Данные после вызова сеттеров:");
        printStudent(student);
        System.out.println("Общий минимум факультативов: " + Rules.MINIMUM_ELECTIVES);
    }

    private static void printStudent(Student student) {
        System.out.println("Фамилия: " + student.getLastName());
        System.out.println("Имя: " + student.getFirstName());
        System.out.println("Отчество: " + student.getPatronymic());
        System.out.println("Адрес: " + student.getAddress());
        System.out.println("Телефон: " + student.getPhone());
    }
}

