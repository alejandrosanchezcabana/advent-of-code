package day03

import AdventDayProblem
import java.io.File
import java.util.stream.Collectors


class Day03Part1 : AdventDayProblem {

  private val inputFile = "src/main/kotlin/day03/Day03.txt"
  override fun runProblem(): String {
    var priorities = 0
    for (rugsack: String in File(inputFile).readLines()) {
      val firstCompartment = rugsack.substring(0, rugsack.length / 2)
      val secondCompartment = rugsack.substring(rugsack.length / 2)
      priorities += calculateDifferenceAndPriorities(firstCompartment, secondCompartment)
    }

    return priorities.toString()
  }

  private fun calculateDifferenceAndPriorities(firstCompartment: String, secondCompartment: String): Int {
    var listOfDuplicates = ArrayList<Char>()
    for (firstCompartmentElement: Char in firstCompartment.toCharArray()) {
      if (secondCompartment.toCharArray().contains(firstCompartmentElement)) {
        listOfDuplicates.add(firstCompartmentElement)
      }
    }

   listOfDuplicates = listOfDuplicates.stream().distinct().collect(Collectors.toList()) as ArrayList<Char>

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