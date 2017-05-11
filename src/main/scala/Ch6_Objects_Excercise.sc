
object Conversions {
  def inchesToCentimeters(in: Int) = in * 2.54

  def gallonsToLiters(gal: Int) = gal * 3.78

  def milesToKilometers(mil: Int) = mil * 1.6
}

class UnitConversion(val mul: Double) {
  def convert(toConvert: Int) = mul * toConvert
}

object MilesToKilometers extends UnitConversion(1.6) {
  def apply(toConvert: Int) = convert(toConvert)
}

object GallonsToLiters extends UnitConversion(3.78) {
  def apply(toConvert: Int) = convert(toConvert)
}

object InchesToCentimeters extends UnitConversion(2.54) {
  def apply(toConvert: Int) = convert(toConvert)
}

object test extends App {
  println(Conversions)
  var x = MilesToKilometers(3)

}

object origin extends java.awt.Point {

}

var y = origin.getX
var z = origin.getY

origin.x = 10
var u = origin.getX

class Point(val x: Int, val y: Int) {

}

object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}

val p = new Point(2, 4)
val p2 = Point(2, 4)

object Reverser {
  def reverse(str: String) = str.split(" ").reverse.mkString(" ")
}

Reverser.reverse("Hello World")

object Suits extends Enumeration {
  type Suits = Value
  val Clubs = Value("♣")
  val Diamonds = Value("♦")
  val Hearts = Value("♥")
  val Spades = Value("♠")

  override def toString = {
    val str = for (c <- Suits.values) yield s"$c"
    str.mkString("")
  }

}

import Suits._

def isRed(suit: Suits) = suit == Hearts

Suits.toString
isRed(Suits.Hearts)


