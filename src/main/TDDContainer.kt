class TDDContainer {
    fun add(input: String): Int {
        val data = input.split("," , "\n")
        var sum = 0
        data.map { it.toInt() }.forEach {
            sum += it
        }
        return sum
    }

}
