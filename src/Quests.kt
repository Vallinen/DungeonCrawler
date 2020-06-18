class Quests {


    var activeQ: Boolean = false

    var complete: Boolean = false

    fun isComplete(): Boolean {
        return complete
    }

    fun isNotComplete(): Boolean {
        return !complete
    }


    fun isActive(): Boolean {
        return activeQ
    }

    fun isNotActive(): Boolean {
        return !activeQ
    }

    fun activeFlipper() {
        activeQ = !activeQ

    }

    fun completeFlipper() {
        complete = !complete

    }
}
