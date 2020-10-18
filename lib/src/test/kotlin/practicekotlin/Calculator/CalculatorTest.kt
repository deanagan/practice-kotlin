
package practicekotlin

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.asserter
import kotlin.test.elementAtShouldBe
import kotlin.test.expect


import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object CalculatorTest: Spek({

    val testCases = mapOf(
        Pair(1,2) to 3,
        Pair(2,3) to 5,
        Pair(1,1) to 20, // failing intentionally
    )
    testCases.forEach { value, expectedValue ->
        describe("$value"){
            val calculator by memoized { Calculator() }

            it("${value.first} + ${value.second} = $expectedValue") {
                assertEquals(expectedValue, calculator.Sum2Numbers(value.first, value.second))
            }
        }
    }


    describe("Calculator") {
        val calculator by memoized { Calculator() }

        it("1 + 2 = 3") {
            assertEquals(3, calculator.Sum2Numbers(1, 2))
        }
    }
})
