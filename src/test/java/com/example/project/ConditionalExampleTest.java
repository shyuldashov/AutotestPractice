package com.example.project;

import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * Условное выполнение
 * <br><hr>
 * Ваш тест будет выполняться в соответствии с набором различных условий,
 * доступных в пакете <code>org.junit.jupiter.api.condition</code>.
 */
public class ConditionalExampleTest {

    // Условное выполнение на основе JRE, которая используется для запуска теста.

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    public void test1() {
        System.out.println("Будет работать только на JRE между 8 и 11");
    }

    @Test
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
    public void test2() {
        System.out.println("Будет работать только на JRE 8 и 11.");
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_11)
    public void test3() {
        System.out.println("НЕ будет работать на JRE между 8 и 11");
    }

    @Test
    @DisabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
    public void test4() {
        System.out.println("НЕ будет работать на JRE 8 и 11");
    }

    // Условное выполнение операционной системы

    @Test
    @EnabledOnOs({OS.LINUX, OS.WINDOWS})
    void onLinuxOrWindows() {
        System.out.println("Будет работать на Linux или Windows.");
    }

    @Test
    @DisabledOnOs({OS.WINDOWS, OS.AIX, OS.SOLARIS, OS.MAC})
    void notOnWindowsOrAixOrSolarisOrMac() {
        System.out.println("Не работает на Windows, AIX, Solaris или MAC!");
    }

    // Возвращаемое значение метода Условное выполнение
    @Test
    @EnabledIf("myfunction")
    void enabled() {
        assertTrue(true);
    }

    @Test
    @DisabledIf("myfunction")
    void disabled() {
        assertTrue(true);
    }

    boolean myfunction() {
        return true;
    }

    // Переменная Env и условное выполнение системных свойств
    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = ".*oracle.*")
    public void executeOnlyInDevEnvironment() {
//        return true;
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*mysql.*")
    public void disabledOnProdEnvironment() {
//        return true;
    }

    @Test
    @EnabledIfSystemProperty(named = "my.property", matches = "prod*")
    public void onlyIfMyPropertyStartsWithProd() {
//        return true;
    }

}
