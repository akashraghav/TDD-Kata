import java.lang.NumberFormatException

class TDDContainer {
    fun add(input: String): Int {
        var delimiters: Array<String> = arrayOf(",", "\n")
        if (input.startsWith("//")) {
           delimiters = delimiters.plus(input[2].toString())
        }
        val updatedString = input.substring(input.indexOf("\n") + 1)
        val data = updatedString.split(*delimiters)
        var sum = 0
        val (negatives, positives) = data.map { it.trim().toInt() }.partition { it < 0 }
        if (negatives.isNotEmpty()) {
            throw NumberFormatException("negatives not allowed $negatives")
        }
        positives.filter { it <= 1000 }.forEach {
            sum += it
        }
        return sum
    }
}
