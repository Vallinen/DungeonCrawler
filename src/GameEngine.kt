import kotlin.system.exitProcess

class GameEngine {

    val town = Town()
    val dungeon = Dungeon()
    val quests = Quests()


    fun runGame() {  // starts the game, by default with Town as TRUE

        town.gameEngine = this
        dungeon.quests = quests
        town.quests = quests
        dungeon.gameEngine = this

        while (true) {

            val container = ActionContainer()

            container.addAction("test1", this::printStuff)
            container.addAction("exit", this::exitGame)
            container.addAction("check quest", this::questStatus)

            if (dungeon.isActive()) {
                val dungeonContainer = dungeon.actionC()
                container.addAll(dungeonContainer)
            }

            if (town.isActive()) {
                val townContainer = town.actionC()
                container.addAll(townContainer)
            }
            val keys = container.actions.keys
            for (key in keys) {
                print("'$key' ")
            }
            println()
            val input: String? = readLine()
            if (input != null) {
                container.useAction(input)
            }
        }
    }

    private fun questStatus() {
        if (quests.isActive()) {
            println("You have a quest.")
        } else {
            println("You do not have a quest.")
        }
        if (quests.complete) {
            println("Your quest is complete.")
        } else {
            println("Your quest is not complete.")
        }
    }

    fun travel() { //function that travels from town to dungeon and vice versa
        town.flipper()
        dungeon.flipper()
    }

    fun printStuff() {
        println("HELLO M8 THIS IS A GENERAL TEST")
    }

    fun exitGame() {
        exitProcess(0)
    }
}
