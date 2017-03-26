class Time(val hours: Int, val minutes: Int) {

  // Auxiliary constructor
  def this(hours: Int) {
    this(hours, 0)
  }

  if (!(hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59)) {
    throw new IllegalArgumentException("Invalid time")
  }

  override def toString: String = f"${hours}:${minutes}%02d"

  def isBefore(other: Time) = hours < other.hours || (hours == other.hours && minutes < other.minutes)

}

val time = new Time(10, 43)
val before = new Time(10, 42)
val after = new Time(11, 43)

before.isBefore(time)
after.isBefore(time)

//val invalid = new Time(24, 0)

val noon = new Time(12)