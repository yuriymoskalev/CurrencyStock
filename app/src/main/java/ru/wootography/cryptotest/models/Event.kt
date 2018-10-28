package ru.wootography.cryptotest.models

class Event {

    var id: Int = 0
        private set

    var data: Any? = null
    var secondData: Any? = null

    constructor(type: Int) {
        this.id = type
    }


    constructor(type: Int, data: Any) {
        this.id = type
        this.data = data
    }

    constructor(type: Int, data: Any, secondData: Any) {
        this.id = type
        this.data = data
        this.secondData = secondData
    }
}
