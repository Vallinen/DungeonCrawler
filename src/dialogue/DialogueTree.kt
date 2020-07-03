package dialogue

import ActionContainer
import ActionEvent
import EventBus

class DialogueTree(var rootNode: DialogueNode = DialogueNode(""), val eventBus: EventBus) {

    var active: Boolean = false
    var currentNode: DialogueNode = rootNode


    fun isActive(): Boolean {
        return active
    }

    fun flipper() {
        active = !active
        currentNode = rootNode
    }

    fun actionC(): ActionContainer {
        val container = ActionContainer()
        val dialogueOptions = currentNode.children.keys
        println(currentNode.text)
        currentNode.sideEffect.invoke()
        for (option in dialogueOptions) {
            eventBus.sendEvent(ActionEvent(option, { currentNode = currentNode.children.get(option)!! }))
        }
        return container
    }
}