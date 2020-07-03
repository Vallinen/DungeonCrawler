package npc

import dialogue.DialogueTree

class NpcFactory {

    fun createBarkeep(dialogueTree: DialogueTree): Npc {
        val npc: Npc = Npc("Bob", mutableMapOf("intro" to dialogueTree))

        return npc
    }
}