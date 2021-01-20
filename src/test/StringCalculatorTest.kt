package test

import TDDContainer
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class StringCalculatorTest {

    private lateinit var tddContainer: TDDContainer

    @Before
    fun setup() {
        tddContainer = TDDContainer()
    }

    @Test
    fun test_add_emptyInput_zero() {
        Assert.assertEquals(tddContainer.add(""), 0)
    }
}