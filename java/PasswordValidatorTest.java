import static org.junit.Assert.*;
import org.junit.Test;

public class PasswordValidatorTest {


    @Test
    public void emptyPassword() {
        assertEquals(false, PasswordValidator.validate(""));
    }

    @Test
    public void validPassword() {
        assertEquals(true, PasswordValidator.validate("7It^^n&2h5@mWTUtefj2"));
    }

    @Test
    public void hunter23() {
        assertEquals(false, PasswordValidator.validate("Hunter23"));
    }

    @Test
    public void shortPassword() {
        assertEquals(false, PasswordValidator.validate("zku8$df"));
    }
    @Test
    public void untypeable() {
        assertEquals(false, PasswordValidator.validate("98yk😍j`sdmD"));
    }

    @Test
    public void sequenceLetters() {
        assertEquals(false, PasswordValidator.validate("&Rtijk=%X"));
    }

    @Test
    public void sequenceNumbers() {
        assertEquals(false, PasswordValidator.validate("ow456tiQcy5n"));
    }

    @Test
    public void onlyLowerCase() {
        assertEquals(false, PasswordValidator.validate("aienervew"));
    }

    @Test
    public void twoOutOfFour() {
        assertEquals(false, PasswordValidator.validate("thm5igprt"));
    }
/*
    @Test
    public void reversedDictionaryWord() {
        assertEquals(false, PasswordValidator.validate("32retnuH"));
    }

    @Test
    public void obfuscatedDictionaryWord() {
        assertEquals(false, PasswordValidator.validate("P4ssw0rd"));
    }

    @Test
    public void xkcd936() {
        assertEquals(true, PasswordValidator.validate("blueaeroplanecandywashing"));
    }
*/
}
