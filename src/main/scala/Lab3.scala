import scala.collection.mutable.ArrayBuffer

/**
  * Created by mgupta on 3/25/17.
  */
object Lab3 extends App {
  // Q. Given an array buffer with positive and negative integers. Remove all but the first negative number

  val x = ArrayBuffer(1, 2, -3, 5, 0, 10, 6, -2, -6, 13, 18, 7, -11)

  // java way
  def removeAllButFirstNegative(b: ArrayBuffer[Int]): Unit = {
    var first = true;
    var i = 0;
    while (i < b.length) {
      if (b(i) < 0) {
        if (first) {
          first = false;
          i += 1;
        } else {
          b.remove(i);
        }
      } else {
        i += 1
      }
    }
  }

  removeAllButFirstNegative(x)
  println(x)

  val y = ArrayBuffer(1, 2, -3, 5, 0, 10, 6, -2, -6, 13, 18, 7, -11)
  // scala way
  val indexes = for (i <- 0 until y.length if y(i) < 0) yield i
  val indexesToRemove = indexes.drop(1); // number of indexes to drop
  for (i <- indexesToRemove.reverse) y.remove(i) // remove from end as after remove the index number changes
  println(y)


}
