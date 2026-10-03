package lab1.src;

public class Student {
    private int studentId;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String phone;

    public Student(int studentId, String lastName, String firstName, String patronymic, String address, String phone) {
        setStudentId(studentId);
        setLastName(lastName);
        setFirstName(firstName);
        setPatronymic(patronymic);
        setAddress(address);
        setPhone(phone);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
