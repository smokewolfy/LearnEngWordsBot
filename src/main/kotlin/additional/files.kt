package additional

import java.io.File

data class Word(
    val eng: String,
    val rus: String,
    var correctAnswerCount: Int = 0,
)

fun main() {
    val file = File("words.txt")
    val dictionary: MutableList<Word> = mutableListOf()
    file.readLines().forEach {
        val line = it.split("|")
        dictionary.add(Word(eng = line[0], rus = line[1], correctAnswerCount = line[2].toIntOrNull() ?: 0))
    }
    dictionary.forEach { println("${it.eng} - ${it.rus}. Отвечено верно - ${it.correctAnswerCount} раз ") }
}