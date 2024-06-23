package additional

import java.io.File

fun main() {
    val file = File("words.txt")
    file.readLines().forEach { println(it) }
}