class DialogueTree(val rootNode: DialogueNode) {

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
        for (option in dialogueOptions) {
            container.addAction(option, { currentNode = currentNode.children.get(option)!! })
        }
        return container
    }
}