import character.CharacterSheet
import dialogue.DialogueTree
import npc.NpcManager

class Town(var active: Boolean = true, var eventBus: EventBus, var characterSheet: CharacterSheet, var npcManager: NpcManager, var dialogue: DialogueTree) : Location, ActionLocation {

    override fun actionC(): ActionContainer {
        val container = ActionContainer()
        eventBus.sendEvent(ActionEvent("travel", { eventBus.sendEvent(TravelEvent("town", "dungeon")) }))
        eventBus.sendEvent(ActionEvent("test2", this::printStuff))
        eventBus.sendEvent(ActionEvent("talk", dialogue::flipper))

        if (dialogue.isActive()) {
            container.addAll(dialogue.actionC())
        }
        for (name in npcManager.npcNames()) {
            val key = "talk to $name"
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

