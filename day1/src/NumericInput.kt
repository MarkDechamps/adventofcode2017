import java.util.stream.Collectors

class NumericInput constructor(private val inputString:String ) {
    fun addEqual(): Int {

        val input = mutableList(inputString)
        if(input.isEmpty())return 0
        var sum =0
        val mid = input.size/2

        for(i in input.indices){
            val indexToCompareWith = i + mid
            val next = if (indexToCompareWith >= input.size) input[indexToCompareWith -input.size] else input[indexToCompareWith]
            val thisOne = input.get(i)
            if(next == thisOne)sum += thisOne
        }
        return sum
    }

    private fun mutableList(input: String): List<Int> {
        val intList = input.chars()
                .mapToObj { i -> i.toChar() }
                .map { i -> "" + i }
                .map { i -> i.toInt() }
                .collect(Collectors.toList())
        return intList
    }

}