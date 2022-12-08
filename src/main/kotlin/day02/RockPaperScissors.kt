package day02

enum class RockPaperScissors(
  val yours: String,
  val opponent: String,
  private val points: Int,
  private val wins: String,
  private val loss: String
) {
  ROCK("X", "A", 1, "C", "B"),
  PAPER("Y", "B", 2, "A", "C"),
  SCISSORS("Z", "C", 3, "B", "A");

  fun getPoints(): Int {
    return points;
  }

  fun getResult(opponentMove: String) : WinLossOrDraw {
    return if (this.wins == opponentMove) {
      WinLossOrDraw.WIN
    } else if (this.loss == opponentMove) {
      WinLossOrDraw.LOSS
    } else {
      WinLossOrDraw.DRAW
    }
  }

  fun getOpponentWeakness(): String {
    return wins
  }
  fun getOpponentStrength(): String {
    return loss
  }

}