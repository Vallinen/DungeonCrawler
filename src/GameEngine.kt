class GameEngine {

    val town = Town()
    val dungeon = Dungeon()


    fun runGame() {  // starts the game, by default with Town as TRUE
        town.gameEngine = this



        while (true) {

            val container = ActionContainer()

            container.addAction("test", this::printStuff)

            /*if (dungeon.isActive()) {
                val dungeonContainer = dungeon.actionC()
                container.addAll(dungeonContainer)
            }

            if (town.isActive()) {
                val townContainer = town.actionC()
                container.addAll(townContainer)
            }*/ //THIS WILL BE IMPLEMENTED SHORTLY, HOPEFULLY

            val input: String? = readLine()
            if (input != null) {
                container.useAction(input)
            }

            /*if (town.isActive()) {
                town.action()
            } else if (dungeon.isActive()) {
                dungeon.action()
            }*/

        }
    }

    fun travel() { //function that travels from town to dungeon and vice versa
        town.flipper()
        dungeon.flipper()
    }
    fun printStuff() {
        println("HELLO M8 THIS IS A GENERAL TEST")
    }
}
