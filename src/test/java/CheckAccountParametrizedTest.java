import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckAccountParametrizedTest {
    private final String account;
    private final boolean expected;

    public CheckAccountParametrizedTest(String account, boolean expected) {
        this.account = account;
        this.expected = expected;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getHaveMane() {
        return new Object[][]{
                {"Timofeeva Tatiana", true},
                {"Тимофеева Татьяна", true},
                {"Timof eeva Tatiana", false},
                {"", false},
                {"         ", false},
                {"Timofeeva Tatianaaaaaaaaaaaaa", false},
                {" TimofeevaTatiana", false},
                {"TimofeevaTatiana ", false},
        };
    }

    @Test
    public void checkAccount(){
        Account testaccount = new Account(account);
        boolean actual = testaccount.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}
