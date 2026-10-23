public class Main {
    public static void main(String[] args) {
        Student student = new Student(
                "Иванов",
                "Иван",
                "Иванович",
                "Москва, ул. Лесная, д. 10",
                "+79991234567"
        );

        System.out.println("Данные студента:");
        printStudent(student);

        System.out.println("Проверка фамилии: " + Student.isValidName(student.getLastName()));
        System.out.println("Проверка имени: " + Student.isValidName(student.getFirstName()));
        System.out.println("Проверка отчества: " + Student.isValidName(student.getPatronymic()));
        System.out.println("Проверка адреса: " + Student.isValidAddress(student.getAddress()));
        System.out.println("Проверка телефона: " + Student.isValidPhone(student.getPhone()));

        try {
            student.setFirstName("123");
        } catch (IllegalArgumentException exception) {
            System.out.println("Ошибка при изменении имени: " + exception.getMessage());
        }

        System.out.println("После ошибки объект сохранил правильное имя: " + student.getFirstName());
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

