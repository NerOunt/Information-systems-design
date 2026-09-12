import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.Strictness;
import java.util.Objects;

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

    public Student(Student student) {
        this(requireStudent(student).studentId, student.lastName, student.firstName, student.patronymic, student.address, student.phone);
    }

    public Student(String data) {
        this(parseStudentData(data));
    }

    public Student(JsonObject data) {
        this(parseJsonData(data));
    }

    private Student(String[] fields) {
        this(Integer.parseInt(fields[0]), fields[1], fields[2], fields[3], fields[4], fields[5]);
    }

    private static Student requireStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Студент для копирования не должен быть null");
        }
        return student;
    }

    private static String[] parseStudentData(String data) {
        if (data == null) {
            throw new IllegalArgumentException("Строка с данными студента не должна быть null");
        }

        if (data.stripLeading().startsWith("{")) {
            try {
                JsonObject json = new GsonBuilder().setStrictness(Strictness.STRICT).create().fromJson(data, JsonObject.class);
                return parseJsonData(json);
            } catch (JsonParseException exception) {
                throw new IllegalArgumentException("Неверный формат JSON", exception);
            }
        }

        String[] fields = data.split(";", -1);
        if (fields.length != 6) {
            throw new IllegalArgumentException("Строка должна содержать 6 полей, разделенных точкой с запятой");
        }
        return fields;
    }

    private static String[] parseJsonData(JsonObject data) {
        if (data == null) {
            throw new IllegalArgumentException("JSON с данными студента не должен быть null");
        }

        return new String[] {
            getJsonNumber(data, "studentId"),
            getJsonString(data, "lastName"),
            getJsonString(data, "firstName"),
            getJsonString(data, "patronymic"),
            getJsonString(data, "address"),
            getJsonString(data, "phone")
        };
    }

    private static String getJsonNumber(JsonObject data, String fieldName) {
        JsonElement value = data.get(fieldName);
        if (value == null || !value.isJsonPrimitive() || !value.getAsJsonPrimitive().isNumber()) {
            throw new IllegalArgumentException("Поле " + fieldName + " в JSON должно быть числом");
        }
        return value.getAsString();
    }

    private static String getJsonString(JsonObject data, String fieldName) {
        JsonElement value = data.get(fieldName);
        if (value == null || value.isJsonNull()) {
            return null;
        }
        if (!value.isJsonPrimitive() || !value.getAsJsonPrimitive().isString()) {
            throw new IllegalArgumentException("Поле " + fieldName + " в JSON должно быть строкой");
        }
        return value.getAsString();
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

    @Override
    public String toString() {
        return "ID: " + studentId
                + "\nФамилия: " + lastName
                + "\nИмя: " + firstName
                + "\nОтчество: " + patronymic
                + "\nАдрес: " + address
                + "\nТелефон: " + phone;
    }

    public String toShortString() {
        String initials = getInitial(firstName) + getInitial(patronymic);
        return lastName + " " + initials + ", тел. " + phone;
    }

    private static String getInitial(String name) {
        return new String(Character.toChars(name.codePointAt(0))) + ".";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Student student = (Student) object;
        return studentId == student.studentId
                && Objects.equals(lastName, student.lastName)
                && Objects.equals(firstName, student.firstName)
                && Objects.equals(patronymic, student.patronymic)
                && Objects.equals(address, student.address)
                && Objects.equals(phone, student.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, lastName, firstName, patronymic, address, phone);
    }

    public static void validateStudentId(int studentId) {
        if (studentId <= 0) {
            throw new IllegalArgumentException("Идентификатор студента должен быть больше нуля");
        }
    }

    public static void validateLastName(String lastName) {
        validateName(lastName, "Фамилия");
    }

    public static void validateFirstName(String firstName) {
        validateName(firstName, "Имя");
    }

    public static void validatePatronymic(String patronymic) {
        validateName(patronymic, "Отчество");
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

    private static void validateName(String value, String fieldName) {
        if (value == null || value.length() > 50 || !value.matches("\\p{L}+([ '-]\\p{L}+)*")) {
            throw new IllegalArgumentException(fieldName + ": от 1 до 50 символов, только буквы, пробелы, дефисы или апострофы");
        }
    }

    public static void main(String[] args) {
        Student student = new Student(1, "Иванов", "Иван", "Иванович", "Москва, ул. Лесная, д. 10", "+79991234567");
        Student copy = new Student(student);
        System.out.println("Норма при двух завершенных факультативах: " + student.hasCompletedMinimumElectives(2));
        System.out.println("Норма при трех завершенных факультативах: " + student.hasCompletedMinimumElectives(3));

        System.out.println("Полная информация:");
        System.out.println(student);

        System.out.println();
        System.out.println("Краткая информация:");
        System.out.println(student.toShortString());

        System.out.println();
        System.out.println("Студент и копия равны: " + student.equals(copy));
        copy.setPhone("+79997654321");
        System.out.println("После изменения телефона равны: " + student.equals(copy));

        StudentShort shortStudent = new StudentShort(student);
        System.out.println();
        System.out.println("Объект StudentShort:");
        System.out.println(shortStudent);
    }
}

class StudentShort {
    private int studentId;
    private String lastName;
    private String firstName;
    private String patronymic;
    private String phone;

    public StudentShort(int studentId, String lastName, String firstName, String patronymic, String phone) {
        Student.validateStudentId(studentId);
        Student.validateLastName(lastName);
        Student.validateFirstName(firstName);
        Student.validatePatronymic(patronymic);
        Student.validatePhone(phone);

        this.studentId = studentId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.phone = phone;
    }

    public StudentShort(Student student) {
        this(requireStudent(student).getStudentId(), student.getLastName(), student.getFirstName(), student.getPatronymic(), student.getPhone());
    }

    private static Student requireStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Студент для копирования не должен быть null");
        }
        return student;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return toShortString();
    }

    public String toShortString() {
        String initials = getInitial(firstName) + getInitial(patronymic);
        return lastName + " " + initials + ", тел. " + phone;
    }

    private static String getInitial(String name) {
        return new String(Character.toChars(name.codePointAt(0))) + ".";
    }
}
