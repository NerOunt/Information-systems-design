package lab1.src;

public class Mapper {
    public StudentShort toShortStudent(Student student) {
        if (student == null) {
            return null;
        }

        String shortName = createShortName(student);

        return new StudentShort(
                shortName,
                student.getStudentId(),
                student.getPhone()
        );
    }

    protected static String createShortName(Student student) {
        return student.getLastName() + " "
                + student.getFirstName().charAt(0) + "."
                + student.getPatronymic().charAt(0) + ".";
    }
}
