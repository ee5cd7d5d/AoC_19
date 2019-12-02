import java.io.File

class Opcodes (
    operation: Int,
    inputPos1: Int,
    inputPos2: Int,
    private val outputPos: Int,
    private var data: MutableList<Int>){

    private val output: Int =
        when (operation) {
            1 -> data[inputPos1] + data[inputPos2]
            else -> data[inputPos1] * data[inputPos2]
        }

    fun rewriteData(): MutableList<Int> {
        if (outputPos == 129){
            print("a")
        }
        data[outputPos] = this.output
        return data
    }
}

fun readInputComma(path: String): MutableList<Int> {
    val file = File(path)
    return file.readText().split(',').map{ it.toInt() }.toMutableList()
}

fun processIntList(integers: MutableList<Int>): MutableList<Int> {
    var thisData = integers
    var thisInd = 0
    var thisInt = integers[thisInd]
    while (thisInt != 99) {
        val opcodes = Opcodes(
            thisData[thisInd],
            thisData[thisInd+1],
            thisData[thisInd+2],
            thisData[thisInd+3],
            thisData)
        thisData = opcodes.rewriteData()
        thisInd += 4
        thisInt = integers[thisInd]
    }
    return thisData
}

fun main() {
    val input = readInputComma(mainPath + "resources/day_2.txt")
    input[1] = 12
    input[2] =  2
    print(processIntList(input)[0].toString()+"\n")
    var noun = 0
    var verb = 0
    var result = 0
    val input2 = readInputComma(mainPath + "resources/day_2.txt")
    loop@
    for (in1 in 0..99){
        for (in2 in 0..99){
            val thisInput = input2.toMutableList()
            thisInput[1] = in1
            thisInput[2] = in2
            if ( processIntList(thisInput)[0] == 19690720) {
                noun = in1
                verb = in2
                result = 100 * noun + verb
                break@loop
            }
        }
    }
    print("In1: $noun\nIn2: $verb\nResult: $result")
}