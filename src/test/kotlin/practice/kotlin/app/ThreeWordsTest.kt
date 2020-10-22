
package practice.kotlin.app
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals


import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.Arguments

internal class ThreeWordsTest {

    companion object {
	    @JvmStatic
	    fun testArguments() = listOf(
            Arguments.of("Hello World hello", true),
            Arguments.of("He is 123 man", false),
            Arguments.of("1 2 3 4", false),
            Arguments.of("bla bla bla bla", true),
            Arguments.of("Hi", false)
	    )
	}

    @ParameterizedTest(name = "given \"{0}\", when checking for 3 consecutive words with no digits, then it should return {1}")
    @MethodSource("testArguments")
    fun `given input numbers, when calculating total, then should return correct sum`(
        input: String,
        expected: Boolean
    ) {
        var sut = ThreeWords()

        val has3ConsecutiveWords = sut.DoesHaveThreeWords(input)

        assertEquals(expected, has3ConsecutiveWords)
    }
}
