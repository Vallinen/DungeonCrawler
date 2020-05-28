class Dungeon(var activeD: Boolean = false) {

    fun action() {

        println("YOU ARE IN THE DUNGEON")
        // Read input
        // Do something with input
    }

    fun isActive(): Boolean {
        return activeD
    }

    fun flipper() {
        activeD = !activeD
    }
}