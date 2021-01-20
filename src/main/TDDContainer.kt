import java.lang.NumberFormatException

class TDDContainer {
    fun add(input: String): Int {
        if (input.isEmpty()) return 0

        var delimiters: Array<String> = arrayOf(",", "\n")
        val updatedString: String = if (input.startsWith("//")) {
            var delimiterString = input.substring(2, input.indexOf("\n"))
            delimiterString.split( "][").forEach {
                var delimiter = it
                delimiter = delimiter.removePrefix("[")
                delimiter = delimiter.removeSuffix("]")
                delimiters = delimiters.plus(delimiter)
            }
            input.substring(input.indexOf("\n") + 1)
        } else {
            input
        }

        val data = updatedString.split(*delimiters)
        val (negatives, positives) = data.map { it.trim().toInt() }.partition { it < 0 }
        if (negatives.isNotEmpty()) {
            throw NumberFormatException("negatives not allowed $negatives")
        }

        var sum = 0
        positives.filter { it <= 1000 }.forEach {
            sum += it
        }
        return sum
    }
}
