import kotlin.test.assertEquals
import org.junit.Test as test

class TestSourceDay2() {

    @test
    fun test_readInput() {
        val input = readInputComma(testPath + "resources/test_day_2_puzzle_1.txt")
        assertEquals(input, listOf(1, 0, 0, 0, 99))
    }

    @test
    fun test_rinputLength() {
        val input = readInputComma(mainPath + "resources/day_2.txt")
        assertEquals(input.size, 129)
    }

    @test
    fun test_Opcodes() {
        assertEquals(Opcodes(1,
            0,
            0,
            0,
            listOf(1, 0, 0, 0).toMutableList()).rewriteData(),
            listOf(2, 0, 0, 0))
    }

    @test
    fun test_Opcodes2() {
        assertEquals(Opcodes(2,
            3,
            0,
            3,
            listOf(2, 3, 0, 3).toMutableList()).rewriteData(),
            listOf(2, 3, 0, 6))
    }


    @test
    fun test_Calc() {
        val input = "2,3,0,3,99".split(",").map { it.toInt() }.toMutableList()
        val output = "2,3,0,6,99".split(",").map { it.toInt() }.toMutableList()
        assertEquals(output, processIntList(input))
    }

    @test
    fun test_Calc2() {
        val input = "2,4,4,5,99,0".split(",").map { it.toInt() }.toMutableList()
        val output = "2,4,4,5,99,9801".split(",").map { it.toInt() }.toMutableList()
        assertEquals(output, processIntList(input))
    }

    @test
    fun test_Calc3() {
        val input = "1,1,1,4,99,5,6,0,99".split(",").map { it.toInt() }.toMutableList()
        val output = "30,1,1,4,2,5,6,0,99".split(",").map { it.toInt() }.toMutableList()
        assertEquals(output, processIntList(input))
    }
}