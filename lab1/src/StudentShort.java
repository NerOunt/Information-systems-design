package lab1.src;

public class StudentShort {
    protected final String name;
    protected final int studentId;
    protected final String phone;

    public StudentShort(String name, int studentId, String phone) {
        this.name = name;
        this.studentId = studentId;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "StudentShort {" +
                "name='" + name + '\'' +
                ", studentId=" + studentId +
                ", phone='" + phone + '\'' +
                '}';
    }
}
