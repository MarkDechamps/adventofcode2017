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

    fun evenDivision(s: String): Int {
        val first = toIntStream(s).toList()
        val second = toIntStream(s).toList()

        return first.map { i ->
            val third = ArrayList<Int>()
            third.addAll(second)
            third.remove(i)
            dividesEvenlyWith(i, third)
        }.filter { i -> i > 0 }.get(0)


    }

    fun dividesEvenlyWith(i: Int, second: List<Int>): Int {
        return second.stream()
                .filter({ j -> max(i, j) % min(i, j) == 0 })
                .map { j -> max(i, j) / min(i, j) }
                .findFirst().orElse(-1)
    }

    private fun max(i: Int, j: Int): Int {
        return if (i > j) i else j
    }

    private fun min(i: Int, j: Int): Int {
        return if (i < j) i else j
    }

}