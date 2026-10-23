public class Main {
    public static void main(String[] args) {
        Student student = new Student(
                "Иванов",
                "Иван",
                "Иванович",
                "Москва, ул. Лесная, д. 10",
                "+79991234567"
        );

        System.out.println("Корректный студент создан:");
        printStudent(student);

        System.out.println("Проверка фамилии Иванов: " + Student.isValidLastName("Иванов"));
        System.out.println("Проверка имени Иван: " + Student.isValidFirstName("Иван"));
        System.out.println("Проверка отчества Иванович: " + Student.isValidPatronymic("Иванович"));
        System.out.println("Проверка адреса: " + Student.isValidAddress("Москва, ул. Лесная, д. 10"));
        System.out.println("Проверка телефона: " + Student.isValidPhone("+79991234567"));

        try {
            student.setPhone("123");
        } catch (IllegalArgumentException exception) {
            System.out.println("Ошибка при изменении телефона: " + exception.getMessage());
        }

        System.out.println("После ошибки объект сохранил правильный телефон: " + student.getPhone());
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

