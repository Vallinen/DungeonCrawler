package character

import Event

data class CharacterCreatedEvent(var sheet: CharacterSheet) : Event