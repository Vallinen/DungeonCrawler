import character.CharacterSheet
import kotlin.system.exitProcess

class Dungeon(var activeD: Boolean = false, var gameEngine: GameEngine, var quests: Quests) {

    fun actionC(): ActionContainer {
        val container = ActionContainer()
        container.addAction("test3", this::printStuff)
        container.addAction("search", this::search)
        container.addAction("travel", gameEngine::travel)

        return container

    }

    fun search() {
        val roll: Int = Dice(6, 1).roll()

        if (roll == 6 && quests.isNotComplete()) {
            println("You found the key.")
            quests.completeFlipper()
        } else {
            println("You find nothing but dirt.")
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

