package model.menu

class Menu() {
    var title: String = ""
    private var menuItems = mutableMapOf<Int, MenuItem>()

    constructor(title: String) : this() {
        this.title = title
    }

    fun addMenuItem(key: Int, nameMenuItem: String, function: () -> Unit) {
        menuItems[key] = MenuItem(nameMenuItem, function)
    }

    fun addMenuItem(key: Int, nameMenuItem: String) {
        menuItems[key] = MenuItem(nameMenuItem)
    }

    fun printMenu() {
        println(title)
        menuItems.forEach { println("${it.key}. ➡ ${it.value.name}") }
        print("Ввод  ➡ ")
    }

    fun initItemMenuFunction(key: Int) {
        menuItems[key]?.function?.invoke()
    }

    fun selectItemMenu(key: String) = try {
        if (menuItems.containsKey(key.toInt())) {
            initItemMenuFunction(key.toInt())
            println()
        } else {
            print("\n❌ Ошибка (неправильный ввод) ➡ введите: ")
            menuItems.forEach { print("${it.key} ") }
            println()
        }
    } catch (e: NumberFormatException) {
        println("\n❌ Ошибка (неправильный ввод) ➡ введите число.")
        println()
    }


}