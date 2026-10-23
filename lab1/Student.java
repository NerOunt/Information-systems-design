import com.google.gson.JsonObject;

public class Student {
    private String lastName;
    private String firstName;
    private String patronymic;
    private String address;
    private String phone;

    public Student(String lastName, String firstName, String patronymic, String address, String phone) {
        setLastName(lastName);
        setFirstName(firstName);
        setPatronymic(patronymic);
        setAddress(address);
        setPhone(phone);
    }

    public Student(String line) {
        if (line == null || line.isBlank()) {
            throw new IllegalArgumentException("Пустая строка");
        }

        String[] fields = line.split(";", -1);
        if (fields.length != 5) {
            throw new IllegalArgumentException("Ожидалось 5 полей, получено: " + fields.length);
        }

        setLastName(fields[0].trim());
        setFirstName(fields[1].trim());
        setPatronymic(fields[2].trim());
        setAddress(fields[3].trim());
        setPhone(fields[4].trim());
    }

    public Student(JsonObject json) {
        setLastName(json.get("lastName").getAsString());
        setFirstName(json.get("firstName").getAsString());
        setPatronymic(json.get("patronymic").getAsString());
        setAddress(json.get("address").getAsString());
        setPhone(json.get("phone").getAsString());
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!isValidName(lastName)) {
            throw new IllegalArgumentException("Некорректная фамилия: " + lastName);
        }
        this.lastName = lastName.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!isValidName(firstName)) {
            throw new IllegalArgumentException("Некорректное имя: " + firstName);
        }
        this.firstName = firstName.trim();
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        if (!isValidName(patronymic)) {
            throw new IllegalArgumentException("Некорректное отчество: " + patronymic);
        }
        this.patronymic = patronymic.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (!isValidAddress(address)) {
            throw new IllegalArgumentException("Некорректный адрес: " + address);
        }
        this.address = address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (!isValidPhone(phone)) {
            throw new IllegalArgumentException("Некорректный телефон: " + phone);
        }
        this.phone = phone.trim();
    }

    public static boolean isValidName(String value) {
        if (value == null) {
            return false;
        }

        String trimmed = value.trim();
        return !trimmed.isEmpty()
                && trimmed.length() <= 50
                && trimmed.matches("\\p{L}+([ '-]\\p{L}+)*");
    }

    public static boolean isValidAddress(String address) {
        return address != null && !address.isBlank();
    }

    public static boolean isValidPhone(String phone) {
        if (phone == null) {
            return false;
        }
        return phone.trim().matches("\\+?[0-9]{10,15}");
    }

    public boolean hasCompletedMinimumElectives(int completedElectives) {
        if (completedElectives < 0) {
            throw new IllegalArgumentException("Количество завершенных факультативов не может быть отрицательным");
        }
        return completedElectives >= Rules.MINIMUM_ELECTIVES;
    }

    public String toFullString() {
        return "Студент: "
                + lastName + " "
                + firstName + " "
                + patronymic
                + ", адрес: " + address
                + ", телефон: " + phone;
    }

    public String toShortString() {
        return lastName + " "
                + firstName.charAt(0) + "."
                + patronymic.charAt(0) + "., телефон: "
                + phone;
    }

    public boolean isSameStudent(Student student) {
        return student != null && phone.equals(student.phone);
    }
}

