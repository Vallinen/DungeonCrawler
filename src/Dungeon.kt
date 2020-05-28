import kotlin.system.exitProcess

class Dungeon(var activeD: Boolean = false) {

    var gameEngine: GameEngine? = null

    fun action() {

        println("YOU ARE IN THE DUNGEON")

        while (activeD) {

            val stringInput: String? = readLine()  // Read input

            // Do something with input
            if (stringInput == "exit") {
                exitProcess(0)
            }
        }
    }

    fun isActive(): Boolean {
        return activeD
    }

    fun flipper() {
        activeD = !activeD
    }
}