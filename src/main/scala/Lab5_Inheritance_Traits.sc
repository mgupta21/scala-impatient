import java.awt._
import java.io.FileInputStream

import scala.sys.process.processInternal.InputStream

val rectangle = new Rectangle(5, 10, 20, 30)
rectangle.translate(10, 20)
rectangle

val egg = new geom.Ellipse2D.Double(5, 10, 20, 30)

// egg.translate(10, 20) // translate method not available on Ellipse2D

trait RectangleLike {
  def setFrame(x: Double, y: Double, w: Double, h: Double): Unit

  def getX: Double

  def getY: Double

  def getWidth: Double

  def getHeight: Double

  def translate(dx: Double, dy: Double) {
    setFrame(getX + dx, getX + dy, getWidth, getHeight)
  }

  override def toString = f"(${getX}, ${getY}, ${getHeight}, ${getWidth})"

}

val egg2 = new geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
egg2.translate(10, 20)
egg2

// Buffering
// java
// new BufferedReader(new InputStreamReader(new FileInputStream("/usr/share/dict/words")))

trait Logged {
  def log(msg: String) {}
}

trait ConsoleLogger extends Logged {
  override def log(msg: String) {
    println(msg)
  }
}


trait Buffered extends InputStream with Logged {
  val SIZE = 1024
  private var end = 0
  private val buffer = new Array[Byte](SIZE)
  private var pos = 0

  override def read() = {
    if (pos == end) {
      log("Buffer was empty")
      end = super.read(buffer, 0, SIZE)
      pos = 0
    }
    if (pos == end) -1 else {
      pos += 1
      buffer(pos - 1)
    }
  }

}

var file = new FileInputStream("src/main/resources/alice.txt") with Buffered with ConsoleLogger
file.read()
file.read()
