package day02

import AdventDayProblem
import java.io.File
import java.io.UnsupportedEncodingException

class Day02Part1 : AdventDayProblem {
  private val inputFile = "src/main/kotlin/day02/Day02.txt"
  override fun runProblem(): String {
    var points = 0

    for (round: String in File(inputFile).readLines()){
      val opponentMove = round.split(" ")[0]
      val yourMove = round.split(" ")[1]
      points += playRound(opponentMove, yourMove)
    }

    return points.toString()
  }

  /**
   * A = Rock
   * B = Paper
   * C = Scissors
   *
   * X = Rock = 1
   * Y = Paper = 2
   * Z = Scissors = 3
   */
  private fun playRound(opponentMove: String, yourMove: String): Int {
    val yourMoveEnum : RockPaperScissors = getMovement(yourMove)

    return yourMoveEnum.getPoints() + yourMoveEnum.getResult(opponentMove).points
  }

  private fun getMovement(movement: String) : RockPaperScissors {
    return when (movement) {
      RockPaperScissors.ROCK.yours -> {
        RockPaperScissors.ROCK
      }
      RockPaperScissors.PAPER.yours -> {
        RockPaperScissors.PAPER
      }
      RockPaperScissors.SCISSORS.yours -> {
        RockPaperScissors.SCISSORS
      }
      else -> {
        throw UnsupportedEncodingException()
      }
    }
  }
}