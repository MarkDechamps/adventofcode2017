

class NumericInput constructor(private val input:List<Int> ) {
    fun addEqual(): Int {

        if(input.isEmpty())return 0;
        var sum =0
        var first = input[0]

        for(i in input.indices){
            val next = if ((i + 1) == input.size) first else input.get(i + 1)
            val thisOne = input.get(i)
            if(next == thisOne)sum += thisOne
        }
        return sum;
    }


}