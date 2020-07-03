import character.CharacterCreatedEvent
import dialogue.DialogueEvent

class Printer : EventListener {
    override fun notify(event: Event) {
        when (event) {
            is CharacterCreatedEvent -> handleEvent(event)
            is DialogueEvent -> handleEvent(event)
        }
    }

    private fun handleEvent(event: DialogueEvent) {
        println(event.dialogueNode.text)
    }

    fun handleEvent(event: CharacterCreatedEvent) {
        println("Your name is: ${event.sheet.name}")
        println("Your race is: ${event.sheet.race}")

    }
}