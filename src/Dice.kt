class Dice(var faces: Int, var amount: Int = 1) {
    fun roll(): Int{
        var sum = 0
        for (i in 1..amount) {
            val result = (1..faces).random()
            sum = sum + result
        }
        return sum

    }

}