package _2022.day03

import AdventDayProblem
import java.io.File
import java.util.stream.Collectors


class Day03Part2 : AdventDayProblem {

  private val inputFile = "src/main/kotlin/day03/Day03.txt"
  override fun runProblem(): String {
    var priorities = 0
    var elf1 = ""
    var elf2 = ""
    var elf3: String

    for (rugsack: String in File(inputFile).readLines()) {
      if (elf1 == "") {
        elf1 = rugsack
      } else if (elf2 == "") {
        elf2 = rugsack
      } else {
        elf3 = rugsack
        priorities += calculatePriorities(calculateDuplicates(elf1, elf2, elf3))
        elf1 = ""
        elf2 = ""
      }
    }

    return priorities.toString()
  }

  private fun calculateDuplicates(elf1: String, elf2: String, elf3: String): ArrayList<Char> {
    var listOfDuplicates = ArrayList<Char>()
    for (elf1Elements: Char in elf1.toCharArray()) {
      if (elf2.toCharArray().contains(elf1Elements) and elf3.toCharArray().contains(elf1Elements)) {
        listOfDuplicates.add(elf1Elements)
      }
    }

    listOfDuplicates = listOfDuplicates.stream().distinct().collect(Collectors.toList()) as ArrayList<Char>

    return listOfDuplicates
  }

  private fun calculatePriorities(listOfDuplicates: ArrayList<Char>): Int {
    var priorities = 0
    for (duplicatedValue: Char in listOfDuplicates) {
      var priority = if (duplicatedValue.isUpperCase()) {
        27
      } else {
        1
      }
      var controlChar: Char = if (duplicatedValue.isUpperCase()) {
        'A'
      } else {
        'a'
      }
      while (controlChar != duplicatedValue) {
        controlChar++
        priority++
      }

      priorities += priority
    }
    return priorities
  }
}