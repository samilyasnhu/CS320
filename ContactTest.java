import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactTest {
    @Test
    void createContact_validFields() {
        Contact contact = new Contact("ID123", "John", "Doe", "1234567890", "123 Main St");

        assertNotNull(contact);
        assertEquals("ID123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void createContact_invalidId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void createContact_invalidFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "LongFirstName", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void createContact_invalidLastName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "John", "LongLastName", "1234567890", "123 Main St"));
    }

    @Test
    void createContact_invalidPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "John", "Doe", "12345", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "John", "Doe", "123456789A", "123 Main St"));
    }

    @Test
    void createContact_invalidAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("ID1", "John", "Doe", "1234567890",
                        "1234567890123456789012345678901"));
    }

    @Test
    void updateContactFields_valid() {
        Contact contact = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");

        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Elm St");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    void updateContactFields_invalid() {
        Contact contact = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }
}
