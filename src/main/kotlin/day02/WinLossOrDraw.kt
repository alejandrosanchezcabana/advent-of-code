package day02

enum class WinLossOrDraw(val points : Int, var symbol: String) {
  WIN(6, "Z"),
  LOSS(0, "X"),
  DRAW(3, "Y")
}