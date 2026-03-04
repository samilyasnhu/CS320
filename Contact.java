public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateContactId(contactId);
        validateName(firstName, "First name");
        validateName(lastName, "Last name");
        validatePhone(phone);
        validateAddress(address);
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        validateName(firstName, "First name");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateName(lastName, "Last name");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    private static void validateContactId(String contactId) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must be non-null and at most 10 characters.");
        }
    }

    private static void validateName(String name, String label) {
        if (name == null || name.length() > 10) {
            throw new IllegalArgumentException(label + " must be non-null and at most 10 characters.");
        }
    }

    private static void validatePhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be non-null and exactly 10 digits.");
        }
    }

    private static void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be non-null and at most 30 characters.");
        }
    }
}
