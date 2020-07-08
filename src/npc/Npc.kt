package npc

import dialogue.DialogueTree

class Npc(val name : String, val dialogueMap: MutableMap<String, DialogueTree> = mutableMapOf()) {

    fun activateDialogue(dialogue : String){
        dialogueMap.get(dialogue)?.flipper()

    }
}