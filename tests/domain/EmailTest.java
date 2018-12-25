package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    private static final String[] VALID_EMAIL_ADDR = {
        "mlntdrv@gmail.com",
        "mln_tdrv@gmail.com",
        "mln.tdrv@gmail.com",
        "mln-tdrv29@gmail.com"
    };

    private static final String[] INVALID_EMAIL_ADDR = {
        "mlntdrv@gmail@com",
        "mlntdrv@gmailcom",
        "mln.tdrv.gmail.com",
        "mln tdrv29@gmail.com"
    };

    @Test
    public void testCorrectArg() throws Exception {
        Email email;
        for(int i = 0; i <= VALID_EMAIL_ADDR.length - 1; i++) {
            email = new Email(VALID_EMAIL_ADDR[i]);

            assertEquals(VALID_EMAIL_ADDR[i], email.toString());
        }
    }

    @Test
    public void testIncorrectArg() {
        for(int i = 0; i <= INVALID_EMAIL_ADDR.length - 1; i++) {
            final int fi = i;
            Throwable ex = assertThrows(Exception.class, () -> {
                Email email = new Email(INVALID_EMAIL_ADDR[fi]);
            });

            assertEquals("Invalid e-mail address.", ex.getMessage());
        }
    }
}