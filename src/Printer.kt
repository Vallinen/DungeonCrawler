class Printer : EventListener {
    override fun notify(event: Event) {
        when (event) {
            is CharacterCreatedEvent -> handleEvent(event)
        }
    }

    fun handleEvent(event: CharacterCreatedEvent) {
        println("Your name is: ${event.sheet.name}")
        println("Your race is: ${event.sheet.race}")

    }
}