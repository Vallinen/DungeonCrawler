import character.CharacterSheet
import dialogue.DialogueTree

class Town(var active: Boolean = true, var eventBus: EventBus, var characterSheet: CharacterSheet, var quests: Quests, var dialogue: DialogueTree) : Location, ActionLocation {

    override fun actionC(): ActionContainer {
        val container = ActionContainer()
        eventBus.sendEvent(ActionEvent("travel", { eventBus.sendEvent(TravelEvent("town", "dungeon")) }))
        eventBus.sendEvent(ActionEvent("test2", this::printStuff))
        eventBus.sendEvent(ActionEvent("talk", dialogue::flipper))

        if (dialogue.isActive()) {
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

}

