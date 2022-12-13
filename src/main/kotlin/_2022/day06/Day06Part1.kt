package _2022.day06

import AdventDayProblem
import java.io.File

class Day06Part1 : AdventDayProblem {
  private val inputFile = "src/main/kotlin/_2022/day06/day06.txt"
  override fun runProblem(): String {
    val signal = File(inputFile).readText()

    for (index in 4..signal.length) {
      val set = HashSet<Char>()
      for (element in signal.substring(index - 4, index)) {
        set.add(element)
      }
      if (set.size == 4) {
        return index.toString()
      }
    }

    return signal
  }
}