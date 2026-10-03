package lab1.src;

public class App {
    public static void main(String[] args) throws Exception {
        Student student = new Student(
                1,
                "Иванов",
                "Иван",
                "Иванович",
                "Москва, ул. Лесная, д. 10",
                "+79991234567"
        );
        Student sameStudent = new Student(
                1,
                "Иванов",
                "Иван",
                "Иванович",
                "Москва, ул. Лесная, д. 10",
                "+79991234567"
        );

        System.out.println("Полные данные студента:");
        System.out.println(student);
        System.out.println("Краткие данные студента:");
        System.out.println(student.toShortString());
        System.out.println("Студенты равны: " + (student.equals(sameStudent) ? "да" : "нет"));
        System.out.println("2 завершенных факультатива: минимум "
                + (student.hasCompletedMinimumElectives(2) ? "выполнен" : "не выполнен"));
        System.out.println("3 завершенных факультатива: минимум "
                + (student.hasCompletedMinimumElectives(3) ? "выполнен" : "не выполнен"));
    }
}
