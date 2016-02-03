package utls

import java.text.SimpleDateFormat
import scala.collection.mutable.ListBuffer
import scala.io.Source

/**
  * Created by mhl on 03.02.16.
  */

class Session(_date: String, _open: Float, _close: Float, _high: Float, _low: Float) {
  val date = new SimpleDateFormat("yyyy-mm-dd").parse(_date)
  val open = _open
  val close = _close
  val high = _high
  val low = _low

  override def toString = s"Session($date, $open, $close, $high, $low)"
}
object SessionLoader {
  def load(filename : String) : List[Session] = {
    val src = Source.fromFile(filename)
    val cols = src.getLines().map(_.split(",")).toArray.drop(1)
    val lis : ListBuffer[Session] = ListBuffer.empty
    for(col <- cols) {
      lis += new Session(col(0), col(1).toFloat, col(2).toFloat, col(3).toFloat, col(4).toFloat)
    }
    lis.toList
  }
}
