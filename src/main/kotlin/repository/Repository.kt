package repository

import menu.ArchiveMenu
import model.Archive
import model.Note
import java.util.Scanner

class Repository {

    companion object {
        private val archives: MutableList<Archive> = mutableListOf()

        fun addArchive() {
            val input = Scanner(System.`in`)
            do {
                println("\nВведите название архива: ")
                print("Ввод  ➡ ")
                val archiveName = input.nextLine()
                if (archiveName.isBlank()) {
                    println("\n❌ Ошибка (неправильный ввод) ➡ введите название архива.")
                } else {
                    archives.add(Archive(archiveName))
                    println("\n✔\uFE0F Архив \"$archiveName\".noteApp создан и добавлен в репозитарий.")
                    break
                }
            } while (true)
        }

        fun getArchives() {
            val input = Scanner(System.`in`)
            if (archives.isEmpty()) {
                println("\n \uD83D\uDD0E Список архивов пуст.")
            }
            do {
                println("\nСписок архивов:")
                archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
                println("0. Назад")
                print("Ввод  ➡ ")
                try {
                    val choice = input.nextLine().toInt()
                    if (choice == 0) {
                        return
                    }
                    if (choice > archives.size) {
                        print("\n❌ Ошибка (неправильный ввод) ➡ введите: 0..${archives.size}\n")
                    } else {
                        println("\n✔\uFE0F Вы выбрали архив ➡ ${archives[choice - 1].name}.\n")
                        val archiveMenu = ArchiveMenu(archives[choice - 1])
                        archiveMenu.start()
                    }
                } catch (e: NumberFormatException) {
                    println("\n❌ Ошибка (неправильный ввод) ➡ введите число.")
                }
            } while (true)
        }

        fun addNote(archive: Archive) {
            val input = Scanner(System.`in`)
            do {
                println("\nВведите название заметки: ")
                print("Ввод  ➡ ")
                val noteName = input.nextLine()
                if (noteName.isNotBlank()) {
                    println("\n\uD83D\uDCD1 Заметка $noteName:")
                    println("Введите текст заметки: ")
                    print("Ввод  ➡ ")
                    val noteText = input.nextLine()
                    if (noteText.isBlank()) {
                        println("\n❌ Ошибка (неправильный ввод) ➡ введите текст заметки.")
                    } else {
                        archive.notes.add(Note(noteName, noteText))
                        println("\n✔\uFE0F Заметка \"$noteName\" создана и добавлен в архив ${archive.name}.")
                        break
                    }
                } else {
                    println("\n❌ Ошибка (неправильный ввод) ➡ введите название заметки.")
                }
            } while (true)
        }

        fun getNotes(archive: Archive) {
            val input = Scanner(System.`in`)
            if (archive.notes.isEmpty()) {
                println("\n \uD83D\uDD0E Список заметок пуст.")
            }
            do {
                println("\nСписок заметок:")
                archive.notes.forEachIndexed { index, note -> println("${index + 1}. ${note.name}") }
                println("0. Назад")
                print("Ввод  ➡ ")
                try {
                    val choice = input.nextLine().toInt()
                    if (choice == 0) {
                        return
                    }
                    if (choice > archive.notes.size) {
                        print("\n❌ Ошибка (неправильный ввод) ➡ введите: 0..${archive.notes.size}\n")
                    } else {
                        println("\n✔\uFE0F Вы выбрали заметку➡ ${archive.notes[choice - 1].name}.\n")
                        getNoteContent(archive.notes[choice - 1])
                    }
                } catch (e: NumberFormatException) {
                    println("\n❌ Ошибка (неправильный ввод) ➡ введите число.")
                }
            } while (true)
        }

        fun getNoteContent(note: Note) {
            println("\n\uD83D\uDCD1 Заметка ${note.name}:")
            println("\nТекст:\n${note.text}")
            println("\n\"ENTER\" возврат в предыдущее меню.")
            readLine()
        }
    }




}


