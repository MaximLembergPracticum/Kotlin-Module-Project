package menu

import model.Archive
import model.menu.Menu
import repository.Repository
import java.util.Scanner

class ArchiveMenu(archive: Archive) {
    private val menu = Menu("\uD83D\uDDC4\uFE0F Архив ${archive.name}: ")
    private val addNote: () -> Unit = { Repository.addNote(archive) }
    private val getNotes: () -> Unit = { Repository.getNotes(archive) }
    private val back : () -> Unit = { }

    init {
        menu.addMenuItem(1, "Создать заметку.", addNote)
        menu.addMenuItem(2, "Список заметок.", getNotes)
        menu.addMenuItem(0, "Назад", back)
    }

    fun start() {
        menu.printMenu()
        menu.selectItemMenu(Scanner(System.`in`).nextLine())
    }
}