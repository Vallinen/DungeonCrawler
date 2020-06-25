class Town(var activeT: Boolean = true) {

    lateinit var quests: Quests
    lateinit var gameEngine: GameEngine
    lateinit var characterSheet: CharacterSheet
    lateinit var dialogue: DialogueTree

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
        println("HELLO M8 THIS IS A TOWN TEST, you are a ${characterSheet.race} named ${characterSheet.name}! Did it work? ")
    }

    fun questConvo(): DialogueNode {
        val yes = DialogueNode("Glorious! Head to the basement!", sideEffect = {
            quests.activeFlipper()
            dialogue.flipper()
        })
        val no = DialogueNode("Well fuck you then!", sideEffect = {dialogue.flipper()})
        val quest = DialogueNode("Yes, my key is gone! Can you help me find it?", mutableMapOf("Yes" to yes, "No" to no))
        return DialogueNode("Greetings ${characterSheet.race}", mutableMapOf("Quest" to quest))
    }

    fun isActive(): Boolean {
        return activeT
    }

    fun flipper() {
        activeT = !activeT

    }
}

