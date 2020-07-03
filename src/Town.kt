import character.CharacterSheet
import dialogue.DialogueTree

class Town(var active: Boolean = true, var gameEngine: GameEngine, var characterSheet: CharacterSheet, var quests: Quests, var dialogue: DialogueTree): Location, ActionLocation {

    override fun actionC(): ActionContainer {
        val container = ActionContainer()
        container.addAction("travel", {gameEngine.travel(TravelEvent("town", "dungeon"))})
        container.addAction("test2", this::printStuff)
        container.addAction("talk", dialogue::flipper)
        if(dialogue.isActive()) {
            container.addAll(dialogue.actionC())
        }
        return container
    }

    override fun locationActive(active: Boolean) {
        this.active = active
    }

    fun printStuff() {
        println("HELLO M8 THIS IS A TOWN TEST, you are a ${characterSheet.race} named ${characterSheet.name}! Did it work? ")
    }

    override fun isActive(): Boolean {
        return active
    }

    fun flipper() {
        active = !active

    }
}

