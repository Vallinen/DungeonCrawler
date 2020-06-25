class EventBus {
    private var subscribers: MutableList<EventListener> = mutableListOf()

    fun subscribe(subscriber: EventListener) {
        subscribers.add(subscriber)
    }
    fun sendEvent(event: Event){
        for (subscriber: EventListener in subscribers){
            subscriber.notify(event)
        }
    }
}