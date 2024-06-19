package additional

import java.io.File

fun main() {
    val file = File("src/main/kotlin/additional/words.txt")
    file.readLines().forEach { println(it) }
}