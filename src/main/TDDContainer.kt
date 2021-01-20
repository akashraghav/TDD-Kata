class TDDContainer {
    fun add(input: String): Int {
        val data = input.split(",")
        var sum = 0
        data.map { it.toInt() }.forEach {
            sum += it
        }
        return sum
    }

}
