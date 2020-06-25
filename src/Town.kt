import character.CharacterSheet
import dialogue.DialogueNode
import dialogue.DialogueTree

class Town(var activeT: Boolean = true, var gameEngine: GameEngine, var characterSheet: CharacterSheet, var quests: Quests, var dialogue: DialogueTree) {

    fun actionC(): ActionContainer {
        val container = ActionContainer()
        container.addAction("travel", gameEngine::travel)
        container.addAction("test2", this::printStuff)
        container.addAction("talk", dialogue::flipper)
        if(dialogue.isActive()) {
            container.addAll(dialogue.actionC())
        }
        return container
    }

    fun printStuff() {
        println("HELLO M8 THIS IS A TOWN TEST, you are a ${characterSheet.race} named ${characterSheet.name}! Did it work? ")
    }



    fun isActive(): Boolean {
        return activeT
    }

    fun flipper() {
        activeT = !activeT

    }
}

