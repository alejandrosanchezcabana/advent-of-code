package _2022.day07

import AdventDayProblem
import java.io.File

class Day07Part2 : AdventDayProblem {
  private val inputFile = "src/main/kotlin/_2022/day07/day07.txt"
  override fun runProblem(): String {
    return fileSystemDirs.values
      .filter { 70_000_000 - fileSystemDirs["/"]!!.size + it.size >= 30_000_000 }
      .minBy { it.size }
      .size.toString()
  }

  private val fileSystemDirs = buildFileSystemDirs()
  private fun evaluateLine(
    line: List<String>, currentDir: Directory, fileSystem: MutableMap<String, Directory>
  ): Directory {
    when (line[0]) {
      "$" -> {
        return if (line[1] == "cd") {
          if (line[2] == "..") currentDir.parent!!
          else fileSystem["${currentDir.name}/${line[2]}"]!!
        } else currentDir
      }

      "dir" -> {
        val newDir = Directory(name = "${currentDir.name}/${line[1]}", parent = currentDir)
        fileSystem[newDir.name] = newDir
      }

      else -> updateDirectorySizes(currentDir, line[0].toLong())
    }
    return currentDir
  }

  private fun updateDirectorySizes(dir: Directory, sizeToAdd: Long) {
    dir.size += sizeToAdd
    if (dir.parent != null) {
      updateDirectorySizes(dir.parent!!, sizeToAdd)
    }
  }

  private fun buildFileSystemDirs(): MutableMap<String, Directory> {
    val fileSystem = mutableMapOf<String, Directory>()
    var currentDir = Directory(name = "/", parent = null)
    fileSystem[currentDir.name] = currentDir

    File(inputFile).readLines().map { it.split(" ") }
      .drop(1).forEach { line ->
        currentDir = evaluateLine(line, currentDir, fileSystem)
      }


    return fileSystem
  }
}
