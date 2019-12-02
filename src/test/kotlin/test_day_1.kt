import kotlin.test.assertEquals
import org.junit.Test as test

class TestSource() {

    val rootPath = "/home/pedro/Projects/KOTLIN/AoC_19/"
    val testPath = rootPath + "src/test/"

    @test fun test_readInput() {
        val input = readInput_1(testPath + "resources/test_day_1_puzzle_1.txt")
        assertEquals(input, listOf(12, 14, 1969, 100756))
    }

    @test fun test_calculateSingleModuleFuel() {
        val input = readInput_1(testPath + "resources/test_day_1_puzzle_1.txt")
        assertEquals(input.map{ calculateSingleModuleFuel(it) }, listOf(2, 2, 654, 33583))
    }

    @test fun test_fuelSum() {
        val input = readInput_1(testPath + "resources/test_day_1_puzzle_1.txt")
        assertEquals(input.map{ calculateSingleModuleFuel(it) }.sum(), 34241)
    }

    @test fun test_calculateAccumulateSingleModuleFuel() {
        val input = readInput_1(testPath + "resources/test_day_1_puzzle_2.txt")
        assertEquals(input.map{ calculateAccumulateSingleModuleFuel(it) }, listOf(2, 966, 50346))
    }
}