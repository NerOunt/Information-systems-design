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
}

