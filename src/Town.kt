import kotlin.system.exitProcess

class Town(var activeT: Boolean = true) {

    var dungeon = Dungeon()

    var gameEngine : GameEngine ?= null

    var quest = Quests()

    fun action() {

        if (quest.isNotActive()) println("Greetings adventurer, I have a quest for you! Do you accept it?")

        while (activeT) {

            val stringInput: String? = readLine()  // Read input

            // Do something with input
            if (stringInput == "exit") {
                exitProcess(0)
            }
            if (stringInput == "no") {
                println("Well then come back when you have some guts!")
            }
            if (quest.isNotActive() && (stringInput == "yes")) {
                println("Good, then I need you to get to the dungeon and find my fathers old sword.")
                quest.flipper()
            } // TODO Set quest status to active, also remove this option when quest is active

            if (stringInput == "leave") {
                println("You leave town and head towards the dungeon.")

                gameEngine?.travel()

            } // TODO Create a Flip function for both Dungeon and Town active

            if (quest.isActive() && (stringInput == "quest")) {
                if (quest.isComplete()) {
                    println("You found my fathers sword, I am forever in your debt.")
                } else {
                    println("You're not done yet!")
                }
            }
        }
    }

    fun isActive(): Boolean {
        return activeT
    }

    fun flipper() {
        activeT = !activeT

    }
}