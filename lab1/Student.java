public class Student {
    private int studentId;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private static final int MINIMUM_ELECTIVES = 3;
    private String phone;

    public Student(int studentId, String lastName, String firstName, String patronymic, String address, String phone) {
        validateStudentId(studentId);
        validateLastName(lastName);
        validateFirstName(firstName);
        validatePatronymic(patronymic);
        validateAddress(address);
        validatePhone(phone);

        this.studentId = studentId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        validateStudentId(studentId);
        this.studentId = studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        validatePatronymic(patronymic);
        this.patronymic = patronymic;
    }

    public boolean hasCompletedMinimumElectives(int completedElectives) {
        if (completedElectives < 0) {
            throw new IllegalArgumentException("Количество завершенных факультативов не может быть отрицательным");
        }
        return completedElectives >= MINIMUM_ELECTIVES;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public static void validateStudentId(int studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Идентификатор студента должен быть больше нуля");
        }
    }

    public static void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 50 || !lastName.matches("\\p{L}+([ '-]\\p{L}+)*")) {
            throw new IllegalArgumentException("Фамилия должна содержать от 1 до 50 символов: буквы, пробелы, дефисы или апострофы");
        }
    }

    public static void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 50 || !firstName.matches("\\p{L}+([ '-]\\p{L}+)*")) {
            throw new IllegalArgumentException("Имя должно содержать от 1 до 50 символов: буквы, пробелы, дефисы или апострофы");
        }
    }

    public static void validatePatronymic(String patronymic) {
        if (patronymic == null || patronymic.isEmpty()) {
            return;
        }
        if (patronymic.length() > 50 || !patronymic.matches("\\p{L}+([ '-]\\p{L}+)*")) {
            throw new IllegalArgumentException("Отчество должно содержать от 1 до 50 символов: буквы, пробелы, дефисы или апострофы");
        }
    }

    public static void validateAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Адрес не должен быть пустым");
        }
    }

    public static void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\+?[0-9]{10,15}")) {
            throw new IllegalArgumentException("Телефон должен содержать от 10 до 15 цифр, в начале допускается +");
        }
    }
}
