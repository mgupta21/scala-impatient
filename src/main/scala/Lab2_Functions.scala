/**
  * Created by mgupta on 2/1/17.
  */
object Lab2_Functions extends App {

  def vowels(s: String) = {
    var result = ""
    for (ch <- s) if (isVowel(ch)) result += ch
    result
  }

  def vowels2(s: String) = for (ch <- s if isVowel(ch)) yield ch

  def vowels3(s: String): String = {
    if (s.length == 0) ""
    else {
      if (isVowel(s(0))) vowels3(s) else vowels(s.tail)
    }
  }

  def vowels4(s: String) = {
    var i = 0
    var result = ""
    while (i < s.length) {
      if (isVowel(s(i))) result += s(i)
      i += 1
    }
    result
  }

  def isVowel(ch: Char) = "aeiou".contains(ch)

  println(vowels("Nicaragua"))
  println(vowels2("Nicaragua"))
  println(vowels3("Nicaragua"))
  println(vowels4("Nicaragua"))

  def vowels2(s: String, vowelsChars: String, ignoreCase: Boolean = true) = for (ch <- (if (ignoreCase) s.toLowerCase() else s) if isVowel(ch, vowelsChars)) yield ch

  def isVowel(ch: Char, vowelsChars: String) = vowelsChars.contains(ch)

  println(vowels2("Übeltätergehör", "aeiouüäö")) // üeäeeö
  println(vowels2("Übeltätergehör", "aeiouüäö", false)) // eäeeö

}
