package day06

import AdventDayProblem
import java.io.File

class Day06Part2 : AdventDayProblem {
  private val inputFile = "src/main/kotlin/day06/day06.txt"
  override fun runProblem(): String {
    val packetSize = 14
    val signal = File(inputFile).readText()

    for (index in packetSize..signal.length) {
      val set = HashSet<Char>()
      for (element in signal.substring(index - packetSize, index)) {
        set.add(element)
      }
      if (set.size == packetSize) {
        return index.toString()
      }
    }

    return signal
  }
}