package menu

import model.menu.Menu
import repository.Repository
import java.util.Scanner
import kotlin.system.exitProcess

class MainMenu {
    private val menu = Menu("Главное меню: ")
    private val addArchive: () -> Unit = { Repository.addArchive() }
    private val getArchive: () -> Unit = { Repository.getArchives() }
    private val stopApp: () -> Unit = { exitProcess(-1) }

    init {
        menu.addMenuItem(1, "Создать архив.", addArchive)
        menu.addMenuItem(2, "Список архивов.", getArchive)
        menu.addMenuItem(0, "Выход из приложения.", stopApp)
    }

    fun start() {
        menu.printMenu()
        menu.selectItemMenu(Scanner(System.`in`).nextLine())
    }
}