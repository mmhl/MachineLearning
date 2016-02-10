/**
  * Created by mhl on 03.02.16.
  */

import java.io.File

import utls.JSExecutor

object Main {
  def main(args: Array[String]): Unit = {

    val js = new JSExecutor
    js.loadScript(new File("/home/mhl/Sources/MachineLearning/src/main/scala-2.11/utls/dataProviders/js/scripts.js"))
    js.addBinding("document", "Hello World")
    val result = js.invoke("fun1")
    Console println result
  }
}
