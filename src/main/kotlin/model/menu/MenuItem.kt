package model.menu

class MenuItem(var name: String) {
    var function: () -> Unit = { }

    constructor(name: String, function: () -> Unit) : this(name) {
        this.function = function
    }

}