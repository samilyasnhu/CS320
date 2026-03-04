import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    @Test
    void addContact_uniqueId() {
        ContactService service = new ContactService();
        Contact contact = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);

        assertNotNull(service.getContact("ID1"));
    }

    @Test
    void addContact_duplicateIdThrows() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("ID1", "Jane", "Smith", "0987654321", "456 Elm St");

        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    void deleteContact_byId() {
        ContactService service = new ContactService();
        Contact contact = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.deleteContact("ID1");

        assertEquals(null, service.getContact("ID1"));
    }

    @Test
    void deleteContact_missingIdThrows() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("MISSING"));
    }

    @Test
    void updateContact_fieldsById() {
        ContactService service = new ContactService();
        Contact contact = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updateContact("ID1", "Jane", "Smith", "0987654321", "456 Elm St");

        Contact updated = service.getContact("ID1");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("0987654321", updated.getPhone());
        assertEquals("456 Elm St", updated.getAddress());
    }

    @Test
    void updateContact_partialFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updateContact("ID1", null, "Smith", null, "456 Elm St");

        Contact updated = service.getContact("ID1");
        assertEquals("John", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("1234567890", updated.getPhone());
        assertEquals("456 Elm St", updated.getAddress());
    }

    @Test
    void updateContact_missingIdThrows() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class,
                () -> service.updateContact("MISSING", "Jane", null, null, null));
    }
}
