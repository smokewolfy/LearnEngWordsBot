package additional

import java.io.File

data class Word(
    val original: String,
    val rus: String,
    var correctAnswerCount: Int = 0,
)

enum class Menu(val pointer: Int) {
    LEARN(1),
    STATISTICS(2),
    EXIT(0),
}

fun main() {
    val file = File("words.txt")
    val dictionary: MutableList<Word> = mutableListOf()
    val commandMenuText: List<String> = listOf("Меню:", "1 - Учить слова", "2 - Статистика", "0 - Выход")
    file.readLines().forEach {
        val line = it.split("|")
        if (line.size == 3) {
            dictionary.add(Word(original = line[0], rus = line[1], correctAnswerCount = line[2].toIntOrNull() ?: 0))
        }
    }

    while (true) {
        commandMenuText.forEach { println(it) }
        when (readln().toInt()) {
            Menu.LEARN.pointer -> println(commandMenuText[1])
            Menu.STATISTICS.pointer -> dictionary.forEach { println("${it.original} - ${it.rus}. Отвечено верно - ${it.correctAnswerCount} раз ") }
            Menu.EXIT.pointer -> {
                println("Выходим")
                break
            }

            else -> println("Нет такой команды")
        }
    }
}