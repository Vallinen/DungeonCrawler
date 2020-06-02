class ActionContainer {

    val actions: MutableMap<String, () -> Unit> = mutableMapOf()

    fun addAction(key: String, action: () -> Unit) {
        actions.put(key, action)
    }

    fun addAll(other: ActionContainer) {
        //Add all actions from other into this
    }

    fun useAction(key: String)   {

        actions.get(key)?.invoke()


        //Trigger action in here
        /*throw RuntimeException("IMPLEMENT ME BEFORE USING ME")*/
    }
}