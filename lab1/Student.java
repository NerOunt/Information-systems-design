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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!isValidLastName(lastName)) {
            throw new IllegalArgumentException("Некорректная фамилия: " + lastName);
        }
        this.lastName = lastName.trim();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!isValidFirstName(firstName)) {
            throw new IllegalArgumentException("Некорректное имя: " + firstName);
        }
        this.firstName = firstName.trim();
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        if (!isValidPatronymic(patronymic)) {
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

    public static boolean isValidLastName(String lastName) {
        return lastName != null
                && !lastName.isBlank()
                && lastName.trim().length() <= 50
                && lastName.trim().matches("\\p{L}+([ '-]\\p{L}+)*");
    }

    public static boolean isValidFirstName(String firstName) {
        return firstName != null
                && !firstName.isBlank()
                && firstName.trim().length() <= 50
                && firstName.trim().matches("\\p{L}+([ '-]\\p{L}+)*");
    }

    public static boolean isValidPatronymic(String patronymic) {
        return patronymic != null
                && !patronymic.isBlank()
                && patronymic.trim().length() <= 50
                && patronymic.trim().matches("\\p{L}+([ '-]\\p{L}+)*");
    }

    public static boolean isValidAddress(String address) {
        return address != null && !address.isBlank();
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.trim().matches("\\+?[0-9]{10,15}");
    }
}

