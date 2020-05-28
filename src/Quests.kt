class Quests {


    var active: Boolean = false

    var complete: Boolean = false

    fun isComplete(): Boolean {
        return complete
    }

    fun isNotComplete(): Boolean {
        return !complete
    }


    fun isActive(): Boolean {
        return active
    }

    fun isNotActive(): Boolean {
        return !active
    }
}
