package day04

import AdventDayProblem
import java.io.File

class Day04Part2 : AdventDayProblem {

  private val inputFile = "src/main/kotlin/day04/day04.txt"
  override fun runProblem(): String {

    var uselessAssignments = 0

    for (assignments: String in File(inputFile).readLines()) {
      val firstAssignment = Pair(Integer.parseInt(assignments.split(",")[0].split("-")[0]), Integer.parseInt(assignments.split(",")[0].split("-")[1]))
      val secondAssignment = Pair(Integer.parseInt(assignments.split(",")[1].split("-")[0]), Integer.parseInt(assignments.split(",")[1].split("-")[1]))

      if (hasOverlap(firstAssignment, secondAssignment) || hasOverlap(secondAssignment, firstAssignment)) {
        uselessAssignments++
      }
    }
    return uselessAssignments.toString()
  }

  private fun hasOverlap(firstAssignment: Pair<Int, Int>, secondAssignment: Pair<Int, Int>): Boolean {
    return firstAssignment.first <= secondAssignment.first && firstAssignment.second >= secondAssignment.first
  }
}