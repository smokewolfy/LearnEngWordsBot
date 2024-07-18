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

fun loadDictionary(file: File): MutableList<Word> {
    val dictionary: MutableList<Word> = mutableListOf()
    file.readLines().forEach {
        val line = it.split("|")
        if (line.size == 3) {
            dictionary.add(Word(original = line[0], rus = line[1], correctAnswerCount = line[2].toIntOrNull() ?: 0))
        }
    }
    return dictionary
}

fun statistics(dictionary: MutableList<Word>): String {
    val learnedWordsCount = dictionary.count { it.correctAnswerCount >= 3 }
    val progressPercentage = learnedWordsCount * 100 / 7
    return "Выучено $learnedWordsCount из ${dictionary.size} | $progressPercentage%"
}

fun main() {
    val file = File("words.txt")
    val dictionary: MutableList<Word> = loadDictionary(file)
    val commandMenuText: List<String> = listOf("Меню:", "1 - Учить слова", "2 - Статистика", "0 - Выход")

    while (true) {
        commandMenuText.forEach { println(it) }
        when (readln().toIntOrNull()) {
            Menu.LEARN.pointer -> println(commandMenuText[1])
            Menu.STATISTICS.pointer -> println(statistics(dictionary))
            Menu.EXIT.pointer -> {
                println("Выходим")
                break
            }
            else -> println("Нет такой команды")
        }
    }
}