class GameEngine {

    val town = Town()
    val dungeon = Dungeon()


    fun runGame() {  // starts the game, by default with Town as TRUE
        town.gameEngine = this



        while (true) {

            if (town.isActive()) {
                town.action()
            } else if (dungeon.isActive()) {
                dungeon.action()
            }

        }
    }

    fun travel() {
        town.flipper()
        dungeon.flipper()
    }
}