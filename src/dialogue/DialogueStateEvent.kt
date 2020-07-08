package dialogue

import Event

class DialogueStateEvent(val name : String, val state : String) : Event {
}