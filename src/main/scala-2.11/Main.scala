/**
  * Created by mhl on 03.02.16.
  */

import javax.script.ScriptEngineManager

object Main {
  def main(args: Array[String]): Unit = {
    val sem = new ScriptEngineManager
    val engine = sem.getEngineByName("nashorn")
    engine.eval("function hello(){print('Hello');}")
    engine.eval("hello();")
  }
}
