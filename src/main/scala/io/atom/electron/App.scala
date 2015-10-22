package io.atom.electron

import scala.scalajs.js
import js.Dynamic.{global => g}

@js.native
trait App extends js.Object with EventEmitter {
  def quit(): Unit = js.native

  def getAppPath(): Unit = js.native

  def getPath(name: String): String = js.native

  def setPath(name: String, path: String): Unit = js.native

  def getVersion(): String = js.native

  def getName(): String = js.native

  def addRecentDocument(path: String): Unit = js.native

  def clearRecentDocuments(): Unit = js.native

  def dock(): Dock = js.native

  // TODO
  // app.setUserTasks(tasks)
  // app.commandLine.appendSwitch(switch, [value])
  // app.commandLine.appendArgument(value)
  // app.dock.bounce([type])
  // app.dock.cancelBounce(id)
  // app.dock.setBadge(text)
  // app.dock.getBadge()
  // app.dock.hide()
  // app.dock.show()
  // app.dock.setMenu(menu)

}