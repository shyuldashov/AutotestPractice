package com.example.project;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Жизненный цикл
 * <br><hr>
 * Методы обратного вызова, которые будут выполняться в соответствии с жизненным циклом теста
 */
public class ExampleAppTest {
    @BeforeAll
    static void setup() {
        System.out.println("Выполняет метод перед всеми тестами");
    }

    @BeforeEach
    void setupThis() {
        System.out.println("Выполняется перед каждым методом @Test в текущем тестовом классе");
    }

    @AfterEach
    void tearThis() {
        System.out.println("Выполняется после каждого метода @Test в текущем тестовом классе");
    }

    @AfterAll
    static void tear() {
        System.out.println("Выполняет метод после всех тестов");
    }

    /**
     * Утверждения
     * <br><hr>
     * Помогают сверить ожидаемый результат с фактическим результатом теста.
     */

    @Test
    void exampleTest() {
        Assertions.assertTrue(true);
        Assertions.assertFalse(false);

        Assertions.assertNotNull("not null string");
        Assertions.assertNull(null);

        String s1 = new String("lala");
        String s2 = new String("no-no");
        Assertions.assertNotSame(s1, s2);  // разные объекты, s1 не то же самое s2

        Assertions.assertEquals(4, 4); // равенство
        Assertions.assertNotEquals(3, 2);  // неравенство

        Assertions.assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3}, "Тест на равенство массивов");

        Iterable<Integer> listOne = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Iterable<Integer> listTwo = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Assertions.assertIterableEquals(listOne, listTwo);  // Итерируемые типы одинаковы

        Assertions.assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(50);
            return "результат";
        });

        Throwable exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("сообщение об ошибке");
        });

        Assertions.fail("не нашел веских причин для прохождения");
    }

    /**
     * Предположения
     * <br><hr>
     * Неудачное предположение приводит к прерыванию теста, нет смысла
     * продолжать выполнение данного метода тестирования.
     */

    @Test
    void testAssumption() {
        System.setProperty("myproperty", "foo");
        Assumptions.assumeTrue("foo".equals(System.getProperty("myproperty")));

    }
    /*
        @Test
        public void testConnection() {
            boolean isConnected = checkConnection(); // Некоторый метод, который проверяет сетевое соединение
            assumingThat(isConnected, () -> {
                // Тестовый код, требующий активного сетевого подключения
                // например test для проверки вызова API
                assertTrue(myApiCall().contains("Hello World"));
            });
        }
     */
}
