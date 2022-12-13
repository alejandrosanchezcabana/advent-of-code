package _2022.day01

import AdventDayProblem
import java.io.File

class Day01Part1 : AdventDayProblem {
  private val inputFile = "src/main/kotlin/day01/Day01.txt"

  override fun runProblem(): String {
    val calories = File(inputFile)
      .readText().split("\n\n")
      .map { it.lines().sumOf(String::toInt) }
      .sortedDescending()

    return calories.max().toString()
  }
}