import kotlin.system.exitProcess

class Town {

    var active: Boolean = true

    var dungeon

    val quest = Quests()

    fun action() {

        if (quest.isNotActive()) println("Greetings adventurer, I have a quest for you! Do you accept it?")

        while (active) {

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
            } // TODO Set quest status to active, also remove this option when quest is active

            if (stringInput == "leave") {
                println("You leave town and head towards the dungeon.")

                leaveT()

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
        return active
    }

    fun leaveT() {
        active = false
        dungeon.enterD()
        // This does not work TODO MAKE IT WORK
    }
}