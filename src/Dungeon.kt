import kotlin.system.exitProcess

class Dungeon(var activeD: Boolean = false) {

    var gameEngine: GameEngine? = null

    fun actionC(): ActionContainer {
        val container = ActionContainer()
        container.addAction("test", this::printStuff)
        return container

    }

    fun printStuff() {
        println("HELLO M8 THIS IS A DUNGEON TEST")
    }

    fun action() {

        println("YOU ARE IN THE DUNGEON")

        while (activeD) { //TODO Figure out a system for dungeons, dicerolls ect...

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

