package com.example.project;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Тег @Tag
 * <br><hr>
 * Эти теги можно использовать для фильтрации обнаружения и выполнения тестов.
 * Использование <code>@org.junit.jupiter.api.Tag</code> на уровне класса, а также на уровне метода.
 */
@Tag("all")
public class TagExampleTest {

    @Test
    @Tag("development")
    void testOne() {
        assertEquals("ok", "ok");
    }

    @Test
    @Tag("production")
    void testTwo() {
        assertEquals("ok", "ok");
    }

    @Test
    @Tag("performance")
    void testThree() {
        assertEquals("ok", "ok");
    }
}
