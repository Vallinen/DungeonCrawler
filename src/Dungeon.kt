class Dungeon(var active: Boolean = false, var quests: Quests, var eventBus: EventBus) : Location, ActionLocation {

    override fun actionC(): ActionContainer {
        val container = ActionContainer()
        container.addAction("test3", this::printStuff)
        container.addAction("search", this::search)
        container.addAction("travel", {eventBus.sendEvent(TravelEvent("dungeon", "town"))})

        return container

    }

    override fun locationActive(active: Boolean) {
        this.active = active
    }

    fun search() {
        val roll: Int = Dice(6, 1).roll()

        if (roll == 6 && quests.isNotComplete()) {
            println("You found the key.")
            quests.completeFlipper()
        } else {
            println("You find nothing but dirt.")
        }
    }


    fun printStuff() {
        println("HELLO M8 THIS IS A DUNGEON TEST")
    }

    override fun isActive(): Boolean {
        return active
    }

}

