package day05

import AdventDayProblem
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class Day05Part1 : AdventDayProblem {
  private val inputFile = "src/main/kotlin/day05/day05.txt"
  private val cratesPosition = HashMap<Int, Stack<String>>().toMutableMap()
  override fun runProblem(): String {
    val listOfTops = ArrayList<String>()
    val crates = File(inputFile).readText().split("\n\n")[0].split("\n").reversed().toMutableList()
    val moves = File(inputFile).readText().split("\n\n")[1].split("\n")

    parseCrates(crates)
    moveCrates(moves)

    for (tops in cratesPosition.values) {
      listOfTops.add(tops.peek())
    }
    return listOfTops.toString().replace(", ", "")
  }

  private fun moveCrates(moves: List<String>) {
    for (move in moves) {
      var numberOfMoves = move.split(" ")[1].toInt()
      val originStack = move.split(" ")[3].toInt()
      val destinationStack = move.split(" ")[5].toInt()

      while (numberOfMoves != 0) {
        cratesPosition[destinationStack]!!.add(cratesPosition[originStack]!!.pop())
        numberOfMoves--
      }
    }
  }

  private fun parseCrates(crates: MutableList<String>) {
    crates.removeAt(0)
    for (crateStack in crates) {
      val cratesList =
        crateStack
          .replace("[", "")
          .replace("]", "")
          .replace("    ", "|")
          .replace(" ", "")
      for ((index, crateInformation) in cratesList.split("").withIndex()) {
        if (crateInformation.isNotBlank() && !crateInformation.contains("|")) {
          if (cratesPosition[index] == null) {
            cratesPosition[index] = Stack()
          }
          cratesPosition[index]?.add(crateInformation)
        }
      }
    }
  }
}