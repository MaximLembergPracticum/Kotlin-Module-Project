import menu.MainMenu


class NoteApp {
    val mainMenu = MainMenu()

    init {
        while (true) {
            mainMenu.start()
        }
    }
}

