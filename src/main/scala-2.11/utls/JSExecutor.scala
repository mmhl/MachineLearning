package utls

import javax.script.{Invocable, ScriptContext, ScriptEngineManager, SimpleBindings}

/**
  * Created by mhl on 09.02.16.
  */
class JSExecutor {
  val engineManager = new ScriptEngineManager
  val engine = engineManager.getEngineByName("nashorn") // TODO: Code for changing between nashrorn and rhino

  def loadScript(file: java.io.File): Unit = {
    val content = scala.io.Source.fromFile(file).getLines().reduceLeft(_ + _)
    println(content)
    engine.eval(content)
  }

  def invoke(funName: String): Option[(Object, Class[_])] = {
    val invoke = engine
    invoke match {
      case inv: Invocable => val ret = inv.invokeFunction(funName, null)
        if (ret == null) None else Some(ret, ret.getClass)
      case _ => None
    }
  }

  def addBinding(name: String, value: Object): Unit = {
    val binding: SimpleBindings = new SimpleBindings()
    val bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE)
    bindings.put(name, value)
    engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE)
  }

}
