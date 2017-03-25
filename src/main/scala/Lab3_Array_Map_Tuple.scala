import java.io.File
import java.util.Scanner

import scala.collection.mutable.ArrayBuffer

/**
  * Created by mgupta on 3/25/17.
  */
object Lab3_Array_Map_Tuple extends App {
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

  // Q. Read a file, a word at a time, and keep a map that yields the frequency of each word
  val in = new Scanner(new File("src/main/resources/alice.txt").getAbsoluteFile())
  val count = scala.collection.mutable.Map[String, Int]()
  while (in.hasNext) {
    val word = in.next();
    //    if (count.keySet.contains(word)) {
    //      count(word) = count(word) + 1
    //    } else {
    //      count = count + (word -> 1)
    //    }
    count(word) = count.getOrElse(word, 0) + 1
  }

  println(count("Alice"))
  println(count("Rabbit"))


  val in2 = new Scanner(new File("src/main/resources/alice.txt").getAbsoluteFile())
  var icount = Map[String, Int]() // immutable Map
  while (in2.hasNext) {
    val word = in2.next();
    icount = icount + (word -> (icount.getOrElse(word, 0) + 1))
  }

  println(icount("Alice"))
  println(icount("Rabbit"))

  // Q. Grouping
  val words = Array("Marry", "had", "a", "little", "lamb", "its", "fleece", "was", "white", "as", "snow", "and", "everywhere", "that", "Mary", "went", "the", "lamb", "was", "sure", "to", "go")
  // group by first letter
  val group = words.groupBy(_.substring(0, 1))
  val group2 = words.groupBy(_.length)

  // Tuples
  "New York".partition(_.isUpper) // (String, String) = (NY,ew ork)

  val z = ArrayBuffer(1, 2, -3, 5, 0, 10, 6, -2, -6, 13, 18, 7, -11)
  val (neg, pos) = z.partition(_ < 0)
  val result = pos
  result += neg(0)
  println(result)

  val symbols = Array("<", "-", ">")
  val counts = Array(2, 10, 2)
  val pairs = symbols.zip(counts)

  for ((s, n) <- pairs) print(s * n)

}
