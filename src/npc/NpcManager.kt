package npc

import dialogue.DialogueStateEvent
import Event
import EventListener
import dialogue.DialogueExitEvent
import dialogue.DialogueTree
import java.util.*

class NpcManager : EventListener {

    private val npcMap: MutableMap<String, Npc> = mutableMapOf()
    var dialogueTree: Optional<DialogueTree> = Optional.empty()

    fun npcNames(): MutableSet<String> {
        return npcMap.keys
    }

    override fun notify(event: Event) {
        when (event) {
            is NpcCreationEvent -> npcMap.put(event.npc.name, event.npc)
            is DialogueStateEvent -> dialogueHandler(event)
            is DialogueExitEvent -> dialogueExitHandler()
        }
    }

    private fun dialogueHandler(event: DialogueStateEvent) {
        val npc = npcMap.get(event.name)
        npc?.activateDialogue(event.state)
        val tree = npc?.dialogueMap?.get(event.state)
        dialogueTree = Optional.ofNullable(tree)
    }

    private fun dialogueExitHandler(){
        dialogueTree.ifPresent({tree -> tree.flipper()})
        dialogueTree = Optional.empty()

    }
}