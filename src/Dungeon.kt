import kotlin.system.exitProcess

class Dungeon(var activeD: Boolean = false) {

    lateinit var gameEngine: GameEngine
    lateinit var quests: Quests

    fun actionC(): ActionContainer {
        val container = ActionContainer()
        container.addAction("test3", this::printStuff)
        container.addAction("search", this::search)

        return container

    }

    fun search() {
        val roll: Int = Dice(6, 1).roll()

        if (roll == 6)  {
            println("You found the key.")
            quests.completeFlipper()

        }
    }


    fun printStuff() {
        println("HELLO M8 THIS IS A DUNGEON TEST")
    }

    fun isActive(): Boolean {
        return activeD
    }

    fun flipper() {
        activeD = !activeD
    }
}

