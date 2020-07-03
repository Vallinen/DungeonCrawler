import character.CharacterCreatedEvent
import character.CharacterCreator
import dialogue.DialogueFactory
import dialogue.DialogueTree
import npc.NpcCreationEvent
import npc.NpcFactory
import npc.NpcManager
import kotlin.system.exitProcess

class GameEngine : EventListener {


    val charCreator = CharacterCreator()

    private val town: Town
    private val dungeon: Dungeon
    private val quests: Quests
    private val locations: Map<String, Location>
    private val actionLocations: List<ActionLocation>
    private val actionContainer: ActionContainer
    private val eventBus: EventBus = EventBus()
    private val npcFactory: NpcFactory = NpcFactory()
    private val npcManager: NpcManager = NpcManager()
    private val gameState: GameState = GameState(eventBus)

    init {
        val printer = Printer()

        quests = Quests()


        val characterSheet = charCreator.charCreator()
        eventBus.sendEvent(CharacterCreatedEvent(characterSheet))
        val dialogueFactory = DialogueFactory()
        val dialogueTree = DialogueTree(eventBus = eventBus)
        val firstQuestConversation = dialogueFactory.firstQuestConversation(quests, dialogueTree, characterSheet)
        dialogueTree.rootNode = firstQuestConversation
        town = Town(eventBus = eventBus, characterSheet = characterSheet, npcManager = npcManager, dialogue = dialogueTree)
        dungeon = Dungeon(quests = quests, eventBus = eventBus)
        locations = mapOf("town" to town, "dungeon" to dungeon)
        actionLocations = listOf(town, dungeon)
        actionContainer = ActionContainer()

        eventBus.subscribe(printer)
        eventBus.subscribe(this)
        eventBus.subscribe(actionContainer)
        eventBus.subscribe(npcManager)
        eventBus.subscribe(gameState)

        eventBus.sendEvent(NpcCreationEvent(npcFactory.createBarkeep(dialogueTree)))
    }

    override fun notify(event: Event) {
        when (event) {
            is TravelEvent -> travel(event)
        }
    }

    fun runGame() {  // starts the game, by default with Town as TRUE


        while (true) {

            eventBus.sendEvent(ActionEvent("test1", this::printStuff))
            eventBus.sendEvent(ActionEvent("exit", this::exitGame))
            eventBus.sendEvent(ActionEvent("check quest", this::questStatus))

            for (actionLocation in actionLocations) {
                if (actionLocation.isActive()) {
                    actionLocation.actionC()
                }
            }

            val keys = actionContainer.actions.keys
            for (key in keys) {
                print("'$key' ")
            }
            println()
            val input: String? = readLine()
            if (input != null) {
                actionContainer.useAction(input)
            }
        }
    }

    private fun questStatus() {
        if (quests.isActive()) {
            println("You have a quest.")
        } else {
            println("You do not have a quest.")
        }
        if (quests.complete) {
            println("Your quest is complete.")
        } else {
            println("Your quest is not complete.")
        }
    }

    fun travel(travelEvent: TravelEvent) { //function that travels from town to dungeon and vice versa
        locations.get(travelEvent.origin)?.locationActive(false)
        locations.get(travelEvent.destination)?.locationActive(true)
    }

    fun printStuff() {
        println("HELLO M8 THIS IS A GENERAL TEST")
    }

    fun exitGame() {
        exitProcess(0)
    }
}
