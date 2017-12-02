import kotlin.streams.toList

class MaxMinus {

    fun min(s: String): Int {
        return toIntStream(s).min()!!
    }

    fun max(s: String): Int {
        return toIntStream(s).max()!!
    }

    private fun toIntStream(input: String): List<Int> {
        val intStream = split(input)
                .stream()
                .map { i -> i.toInt() }
        return intStream.toList()
    }


    fun split(s: String): List<String> {
        return s.split("\\s".toRegex())
    }

    fun maxMinMin(s: String): Int {
        return max(s) - min(s)
    }
}