package _2022.day01

import AdventDayProblem
import java.io.File

class Day01Part2 : AdventDayProblem {
  private val inputFile = "src/main/kotlin/_2022/day01/Day01.txt"

  override fun runProblem(): String {
    val calories = File(inputFile)
      .readText().split("\n\n")
      .map { it.lines().sumOf(String::toInt) }
      .sortedDescending()

    return (calories[0] + calories[1] + calories[2]).toString()
  }
}