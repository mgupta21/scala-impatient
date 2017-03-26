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

val noon1 = new Time(12)


class Time2(h: Int, m: Int) {
  private var minutesSinceMidNight = h * 60 + m;

  if (minutesSinceMidNight < 0 || minutesSinceMidNight > 24 * 60) {
    throw new IllegalArgumentException("Invalid time")
  }

  def <(other: Time2) = this - other < 0

  def -(other: Time2) = minutesSinceMidNight - other.minutesSinceMidNight


  def hours = minutesSinceMidNight / 60;

  def minutes = minutesSinceMidNight % 60;

  def minutes_=(newValue: Int) {
    if (newValue < 0 || newValue >= 60) {
      throw new IllegalArgumentException("Invalid Minutes")
    }
    minutesSinceMidNight = h * 60 + newValue
  }

  override def toString: String = f"${hours}:${minutes}%02d"
}

object Time2 {
  def apply(h: Int, m: Int) = new Time2(h, m)

  def apply(h: Int) = new Time2(h, 0)
}

val noon = new Time2(12, 0)
noon.hours

// Uniform Access
noon.minutes
noon.minutes = 45

noon

val morning = Time2(10) // Using companion
// operators
morning < noon
noon - morning

//noon.minutes = -999
