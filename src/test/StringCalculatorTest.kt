package test

import TDDContainer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.lang.NumberFormatException

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

    @Test
    fun test_add_singleInput_sameOutputAsInput() {
        Assert.assertEquals(tddContainer.add("1"), 1)
    }

    @Test
    fun test_add_variableInput_sumAsOutput() {
        val count = Math.random().toInt()
        var dataString = ""
        // create string "0,1,2,3,4,5,6...." random size
        for (i in 0..count) {
            dataString += if (i > 0) { ",$i" } else { "$i" }
        }
        val sum : Int = (count * count + 1) / 2
        Assert.assertEquals(tddContainer.add(dataString), sum)
    }

    @Test(expected = NumberFormatException::class)
    fun test_add_invalidInputPattern_throwException() {
        tddContainer.add("1/a/s,2,v,a")
    }

    @Test
    fun test_add_nextLineAsDelimiter_expectedOuptut() {
        Assert.assertEquals(tddContainer.add("1\n2,3"), 6)
    }

    @Test
    fun test_add_useNewDelimiter_expectedSum() {
        Assert.assertEquals(tddContainer.add("//;\n1;2;3"), 6)
        Assert.assertEquals(tddContainer.add("//x\n1x2x3"), 6)
    }

    @Test(expected = NumberFormatException::class)
    fun test_add_NegativeNumbers_throwException() {
        tddContainer.add("1,-2,3,-4,5")
    }

    @Test
    fun test_add_inputGreaterThan1000Numbers_throwException() {
        Assert.assertEquals(tddContainer.add("1,2500,3,1200,5,1900"), 9)
    }
}