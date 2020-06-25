package dialogue

class DialogueNode(var text: String, var children:  MutableMap<String, DialogueNode> = mutableMapOf(), var sideEffect: () -> Unit = {}) {


}