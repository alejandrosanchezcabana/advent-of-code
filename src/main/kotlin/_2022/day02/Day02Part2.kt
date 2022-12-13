package _2022.day02

import AdventDayProblem
import java.io.File
import java.io.UnsupportedEncodingException

class Day02Part2 : AdventDayProblem {
  private val inputFile = "src/main/kotlin/_2022/day02/Day02.txt"
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
   * Rock = 1
   * Paper = 2
   * Scissors = 3
   *
   * X = Loss = 0
   * Y = Draw = 3
   * Z = Win = 6
   */
  private fun playRound(opponentMove: String, resultSymbol: String): Int {
    var result = getSymbol(resultSymbol)
    var yourMoveEnum : RockPaperScissors = getYourMovement(getOpponentMovement(opponentMove), result)

    return result.points + yourMoveEnum.getPoints()
  }

  private fun getOpponentMovement(movement: String) : RockPaperScissors {
    return when (movement) {
      RockPaperScissors.ROCK.opponent -> {
        RockPaperScissors.ROCK
      }
      RockPaperScissors.PAPER.opponent -> {
        RockPaperScissors.PAPER
      }
      RockPaperScissors.SCISSORS.opponent -> {
        RockPaperScissors.SCISSORS
      }
      else -> {
        throw UnsupportedEncodingException()
      }
    }
  }

  private fun getYourMovement(movement: RockPaperScissors, result: WinLossOrDraw) : RockPaperScissors {
    return when (result) {
      WinLossOrDraw.WIN -> {
        getOpponentMovement(movement.getOpponentStrength())
      }
      WinLossOrDraw.LOSS -> {
        getOpponentMovement(movement.getOpponentWeakness())
      }
      else -> {
        movement
      }
    }
  }

  private fun getSymbol(symbol: String) : WinLossOrDraw {
    return when (symbol) {
      WinLossOrDraw.WIN.symbol -> {
        WinLossOrDraw.WIN
      }
      WinLossOrDraw.LOSS.symbol -> {
        WinLossOrDraw.LOSS
      }
      WinLossOrDraw.DRAW.symbol -> {
        WinLossOrDraw.DRAW
      }
      else -> {
        throw UnsupportedEncodingException()
      }
    }
  }
}