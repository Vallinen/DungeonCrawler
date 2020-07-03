package npc

import Event
import EventListener

class NpcManager : EventListener {

    private val npcMap: MutableMap<String, Npc> = mutableMapOf()

    fun npcNames(): MutableSet<String> {
        return npcMap.keys
    }

    override fun notify(event: Event) {
        when (event) {
            is NpcCreationEvent -> npcMap.put(event.npc.name, event.npc)
        }
    }
}