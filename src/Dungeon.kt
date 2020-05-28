class Dungeon(var active: Boolean = false) {

    fun action() {

        println("YOU ARE IN THE DUNGEON")
        // Read input
        // Do something with input
    }

    fun isActive(): Boolean {
        return active
    }

    fun enterD() {
        active = true

    }
}