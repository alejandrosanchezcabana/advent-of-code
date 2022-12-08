class Utils {
  fun <E> List<E>.splitBy(predicate: (E) -> Boolean): List<List<E>> =
    this.fold(mutableListOf(mutableListOf<E>())) { acc, element ->
      if (predicate.invoke(element)) {
        acc += mutableListOf<E>()
      } else {
        acc.last() += element
      }
      acc
    }
}