class TDDContainer {
    fun add(input: String): Int {
        var delimiters: Array<String> = arrayOf(",", "\n")
        if (input.startsWith("//")) {
           delimiters = delimiters.plus(input[2].toString())
        }
        val updatedString = input.substring(input.indexOf("\n") + 1)
        val data = updatedString.split(*delimiters)
        var sum = 0
        data.map { it.toInt() }.forEach {
            sum += it
        }
        return sum
    }
}
