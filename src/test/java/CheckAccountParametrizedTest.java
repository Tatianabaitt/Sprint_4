import io.qameta.allure.Step;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.qameta.allure.junit4.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckAccountParametrizedTest {
    private final String account;
    private final boolean expected;
    private final String message;

    public CheckAccountParametrizedTest(String account, boolean expected, String message) {
        this.account = account;
        this.expected = expected;
        this.message = message;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getHaveMane() {
        return new Object[][]{
                {null, false, "Не пройден тест на обработку строки, со значением null"},
                {"Timofeeva Tatiana", true, "Не пройден тест на определение корректной строки на английском языке"},
                {"Тимофеева Татьяна", true, "Не пройден тест на определение корректной строки на русском языке"},
                {"Timof eeva Tatiana", false, "Не пройден тест на проверку количества пробелов в переданной строке"},
                {"", false, "Не пройден тест на проверку, что передана пустая строка"},
                {"         ", false, "Не пройден тест на проверку строки, состоящей из одних пробелов"},
                {"Tatiana Timofeevaaaa", false, "Строка из 20 символов. Не пройден тест на проверку длины строки"},
                {"T T", true, "Строка из 3 символов. Не пройден тест на проверку длины строки"},
                {"TЕ", false, "Строка из 2 символов. Не пройден тест на проверку длины строки"},
                {"Tatiana Timofeevaaa", true, "Строка из 19 символов. Не пройден тест на проверку длины строки"},
                {" TimofeevaTatiana", false, "Не пройден тест на проверку, что на первом месте в строке пробел"},
                {"TimofeevaTatiana ", false, "Не пройден тест на проверку, что на последнем месте в строке пробел"},
        };
    }

    @Test
    public void checkAccountTest() {
        Account testaccount = createAccount(this.account);
        boolean actual = checkAccount(testaccount);
        assertResult(this.message, this.expected, actual);
    }

    @Step("Create account")
    public Account createAccount(String account){
        return new Account(account);
    }

    @Step("Check name")
    public boolean checkAccount(Account account){
        return account.checkNameToEmboss();
    }

    @Step("Assert expected and actual")
    public void assertResult(String message, boolean expected, boolean actual){
        assertEquals(message, expected, actual);
    }
}
