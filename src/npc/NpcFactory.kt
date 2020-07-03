package npc

import dialogue.DialogueTree

class NpcFactory {

    companion object{
        const val BARKEEP_NAME = "Bob"
    }

    fun createBarkeep(dialogueTree: DialogueTree): Npc {
        val npc: Npc = Npc(BARKEEP_NAME, mutableMapOf("intro" to dialogueTree))

        return npc
    }
}