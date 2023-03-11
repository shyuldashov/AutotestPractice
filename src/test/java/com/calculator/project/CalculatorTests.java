package com.calculator.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTests {
    /**
     * Тест без параметров для сложения двух чисел
     */
    @Test
    @DisplayName("Тест 2 + 2 = 4")
    void addTwoNumbers() {
        Calculator calc = new Calculator();
        assertEquals(4, calc.add(2, 2), "2 + 2 должно быть 4");
    }


    /**
     * Параметризованный тест, сумма двух чисел
     *
     * @param first    целое число
     * @param second   целое число
     * @param expected ожидаемый результат
     */
    @ParameterizedTest(name = "{0} + {1} = {2}")  // Параметры
    @CsvSource(
            {
                    "0, 1, 1",
                    "1, 2, 3",
                    "49, 51, 100",
                    "1, 100, 101",
//                    "5, 100, 101",  // Неверное значение
            }
    )
    // Тестовые значения
    void addParams(final int first, final int second, final int expected) {
        Calculator calc = new Calculator();
        assertEquals(expected, calc.add(first, second),
                () -> first + " + " + second + " должно быть " + expected); // Тут используется lambda функция
    }
}
