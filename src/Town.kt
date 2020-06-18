class Town(var activeT: Boolean = true) {

    lateinit var quests: Quests
    lateinit var gameEngine: GameEngine
    var dialogue: DialogueTree = DialogueTree(questConvo())

    fun actionC(): ActionContainer {
        val container = ActionContainer()
        container.addAction("travel", gameEngine::travel)
        container.addAction("test2", this::printStuff)
        container.addAction("talk", dialogue::flipper)
        if(dialogue.isActive()) {
            container.addAll(dialogue.actionC())
        }
        return container
    }

    fun printStuff() {
        println("HELLO M8 THIS IS A TOWN TEST")
    }

    fun questConvo(): DialogueNode {
        val yes = DialogueNode("Glorious! Head to the basement!")
        val no = DialogueNode("Well fuck you then!")
        val quest = DialogueNode("Yes, my key is gone! Can you help me find it?", mutableMapOf("Yes" to yes, "No" to no))
        return DialogueNode("Greetings Adventurer", mutableMapOf("Quest" to quest))
    }

    fun isActive(): Boolean {
        return activeT
    }

    fun flipper() {
        activeT = !activeT

    }
}

