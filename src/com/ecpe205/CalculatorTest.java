package com.ecpe205;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
    Calculator calc;

    @BeforeAll
    void setup(){
        calc = new Calculator();
    }

    //CREATE A TEST TO TEST isEven
    @Test
    void shouldCheckValueIsEven() {
        assertEquals(true,calc.isEven(2));
        assertEquals(false,calc.isEven(1));
    }

    @Test
    void shouldCheckValueIsOdd() {
        assertEquals(true,calc.isOdd(1));
        assertEquals(false,calc.isOdd(2));
    }


    @Test
    @DisplayName("Sum 2 encoded values")
    void shouldSumTwoEncodedValues() {

        // 1 + 2 = 3
        assertEquals(3, calc.sum(1,2) );
        assertEquals(9, calc.sum(5,4) );
        assertEquals(5, calc.sum(3,2) );
        assertEquals(14, calc.sum(5,9) );
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void shouldSumValueWithOne( int value ) {
        assertEquals(value + 1, calc.sum(value, 1));
    }

    @ParameterizedTest
    @MethodSource("sumInputValues")
    void shouldSumTwoInputValues(int a, int b) {
        assertEquals(a + b, calc.sum(a, b));
    }

    static Stream<Arguments> sumInputValues () {
        return Stream.of(
                Arguments.of(1,2),
                Arguments.of(4,6),
                Arguments.of(2,7),
                Arguments.of(3,7),
                Arguments.of(3,0)
        );
    }

    static Stream<Arguments> arrayOfIntegerSets () {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,4,1}),
                Arguments.of(new int[]{7,1,5,4,1}),
                Arguments.of(new int[]{7,2,8,3,4})
        );
    }
    @ParameterizedTest
    @MethodSource("useBaseXPowerY")
    void shouldSolveExponent(double a, double b) {//testing for exponent() method
        assertEquals(Math.pow(a,b), calc.expo(a, b));
    }

    static Stream<Arguments> useBaseXPowerY () {
        return Stream.of(
                Arguments.of(5,9),
                Arguments.of(3,1),
                Arguments.of(9,4),
                Arguments.of(7,7),
                Arguments.of(5,6)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {7,3,4,6,9})
    void shouldSolveFactorial(int n) {//testing for factorial() method
        assertEquals(24, calc.factorial(n));
    }

    @ParameterizedTest
    @ValueSource(strings = {"jennie","chaeyoung", "lisa", "jisoo", "blackpink" })
    void shouldKnowIfStringIsPalindrome(String n) {//testing for isPalindrome() method
        assertEquals(true, calc.isPalindrome(n));
    }

    @Test
    @MethodSource ("unsortedArrays")
    public void sortingArrayOrdersByAscendingValue(int[] unsortedArray) {
        int[] sortedArray = new bubbleSort().sort(unsortedArray);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            assertThat(sortedArray[i], is(lessThanOrEqualTo(sortedArray[i + 1])));
        }
        assertThat(Arrays.asList(sortedArray), containsInAnyOrder(unsortedArray));
    }
}