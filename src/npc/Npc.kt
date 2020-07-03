package npc

import dialogue.DialogueTree

class Npc(val name : String, private val dialogueMap: MutableMap<String, DialogueTree> = mutableMapOf()) {
}