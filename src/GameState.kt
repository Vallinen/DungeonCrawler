import dialogue.DialogueInitialisationEvent
import dialogue.DialogueStateEvent
import npc.NpcFactory

class GameState(val eventBus: EventBus) :EventListener {

    val bobDialogue = "intro"

    override fun notify(event: Event) {
        when (event){ is DialogueInitialisationEvent -> handleEvent(event) }
    }

    fun handleEvent(event: DialogueInitialisationEvent){
        if (event.npcName == NpcFactory.BARKEEP_NAME) {
            eventBus.sendEvent(DialogueStateEvent(event.npcName, bobDialogue))
        }
    }
}