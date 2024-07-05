package model

class Archive(var name: String) {
    val notes = mutableListOf<Note>()
}