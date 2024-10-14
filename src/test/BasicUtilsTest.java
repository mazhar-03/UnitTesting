package test;

import main.BasicUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

public class BasicUtilsTest {
    @Test
    public void reversingArbitraryStringProducesCorrectResult() {
        Assertions.assertEquals(
                "txet modnar", BasicUtils.reversed("random text")
        );
        Assertions.assertEquals(
                "bd#sa6f3basż;", BasicUtils.reversed(";żsab3f6as#db")
        );
    }

    @Test
    public void reversingNullReturnsNull() {
        Assertions.assertNull(BasicUtils.reversed(null));
    }

    @Test
    public void checkingVowelCountBothVowelAndConsonant(){
        Assertions.assertEquals(3, BasicUtils.vowelCount("asdujki"));
    }

    @Test
    public void countingVowelsOnEmptyStringReturnsZero(){
        Assertions.assertEquals(0, BasicUtils.vowelCount(""));
    }

    @Test
    public void countingVowelsOnOnlyVowelLetters(){
        Assertions.assertEquals(5, BasicUtils.vowelCount("euioa"));
    }

    @Test
    public void countingVowelsOnOnlyConsonantLetters(){
        Assertions.assertEquals(0, BasicUtils.vowelCount("qwfdgkmk"));
    }

    @Test
    public void countingVowelsOnNullReturnsZero(){
        Assertions.assertEquals(0, BasicUtils.vowelCount(null));
    }

    @TestFactory
    public Stream<DynamicTest> checkingIsVowel(){
        List<Character> vowel = List.of('a', 'e', 'u', 'i', 'o');
        return vowel
                .stream()
                .map(
                        v -> (DynamicTest.dynamicTest(v.toString(), () -> Assertions.assertTrue(BasicUtils.isVowel(v))))
                );
    }
}
