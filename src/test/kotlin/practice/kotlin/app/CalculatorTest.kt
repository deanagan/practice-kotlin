
package practice.kotlin.app
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals


import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.Arguments

internal class CalculatorTest {

    companion object {
	    @JvmStatic
	    fun testArguments() = listOf(
	        Arguments.of(1, 1, 2),
	        Arguments.of(2, 4, 6)
	    )
	}

    @ParameterizedTest(name = "given \"{0}\" and \"{1}\", when getting total, then it should return {2}")
    @MethodSource("testArguments")
    fun `given input numbers, when calculating total, then should return correct sum`(
        addend1: Int,
        addend2: Int,
        expected: Int
    ) {
        var calc = Calculator()

        val sum = calc.Sum2Numbers(addend1, addend2)

        assertEquals(expected, sum)
    }
}
