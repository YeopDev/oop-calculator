package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    private Calculator sut = new Calculator();

    @Test
    @DisplayName("1+2+3은 6이다")
    void test() {
        int result = sut.calculate("1+2+3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("1+2-3은 0이다")
    void test1() {
        int result = sut.calculate("1+2-3");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("1-3*2-5는 -9다")
    void test2() {
        int result = sut.calculate("1-3*2-5");
        assertThat(result).isEqualTo(-9);
    }

    @Test
    @DisplayName("4/2+1은 3이다")
    void test3() {
        int result = sut.calculate("4/2+1");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void test4() {
        int result = sut.calculate("324/2*2+1");
        assertThat(result).isEqualTo(325);
    }

}