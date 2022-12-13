package _2022.day07

data class Directory(
  var name: String,
  var size: Long = 0L,
  var parent: Directory?,
)