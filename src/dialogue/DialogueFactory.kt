package dialogue

import Quests
import character.CharacterSheet

class DialogueFactory {

    fun firstQuestConversation(quests: Quests, dialogue: DialogueTree, player: CharacterSheet): DialogueNode {
        val yes = DialogueNode("Glorious! Head to the basement!", sideEffect = {
            quests.activeFlipper()
            dialogue.flipper()
        })
        val no = DialogueNode("Well fuck you then!", sideEffect = { dialogue.flipper() })
        val quest = DialogueNode("Yes, my key is gone! Can you help me find it?", mutableMapOf("Yes" to yes, "No" to no))
        return DialogueNode("Greetings ${player.race}", mutableMapOf("Quest" to quest))
    }
}