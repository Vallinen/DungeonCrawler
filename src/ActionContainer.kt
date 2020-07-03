class ActionContainer : EventListener {


    val actions: MutableMap<String, () -> Unit> = mutableMapOf()

    fun addAction(key: String, action: () -> Unit) {
        actions.put(key, action)

    }

    fun addAll(other: ActionContainer) {

        actions.putAll(other.actions)

    }

    fun useAction(key: String) {

        actions.get(key)?.invoke()
        actions.clear()

    }

    override fun notify(event: Event) {
        when (event) {
            is ActionEvent -> addAction(event.key, event.action)

        }
    }
}