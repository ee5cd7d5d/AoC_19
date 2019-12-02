import java.io.File
import kotlin.math.floor


fun readInputNewline(path: String): List<Int> {
    val file = File(path)
    return file.readText().lines().map{ it.toInt() }
}

fun calculateSingleModuleFuel(mass: Int): Int = floor(mass.toDouble() / 3.0).toInt() - 2

fun calculateAccumulateSingleModuleFuel(mass: Int): Int {
    var nextFuelStep = calculateSingleModuleFuel(mass)
    var completeFuel = nextFuelStep
    while (nextFuelStep > 6) {
        val currentFuelStep = calculateSingleModuleFuel(nextFuelStep)
        completeFuel += currentFuelStep
        nextFuelStep = currentFuelStep
    }
    return completeFuel
}

fun main(){
    val input = readInputNewline(mainPath + "resources/day_1.txt")
    val result1 = input.map{ calculateSingleModuleFuel(it) }.sum()
    val result2 = input.map{ calculateAccumulateSingleModuleFuel(it) }.sum()
    print("Task 1: $result1\n")
    print("Task 2: $result2\n")
}