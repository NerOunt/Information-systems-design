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
        System.out.println(student);

        Mapper mapper = new Mapper();
        StudentShort shortStudent = mapper.toShortStudent(student);
        System.out.println(shortStudent);

        System.out.println("2 завершенных факультатива: минимум "
                + (student.hasCompletedMinimumElectives(2) ? "выполнен" : "не выполнен"));
        System.out.println("3 завершенных факультатива: минимум "
                + (student.hasCompletedMinimumElectives(3) ? "выполнен" : "не выполнен"));
    }
}
