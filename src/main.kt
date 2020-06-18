import kotlin.system.exitProcess

fun main() { // Main menu

    val n = Number(0)

    val startGame = GameEngine()


    while (true) { //sample menu loop
        print("Enter text: ")
        val stringInput = readLine()
        println("You entered: $stringInput")

        if (stringInput == "exit") {
            exitProcess(0)
        }
        if (stringInput == "plus") {
            n.add()
        }
        if (stringInput == "start") { // redirects to class game engine
            startGame.runGame()
        }
        if (stringInput == "roll") {
            val diceRoll = Dice(6, 3).roll()
            println("You rolled a: $diceRoll")
        }
    }
}

class Number(var number: Int) { // sample class, serves no real purpose
    fun add() {
        this.number += 1
        println(this.number)
    }

} // TODO Ask for quest
// Todo Travel back from dungeon to town
// Todo return the key and complete the quest, if you have the key
// Todo prevent failing the quest because you have 2 keys
// Todo implement more than one room
// Todo implement room specific actions