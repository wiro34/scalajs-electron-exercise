package io.atom.electron

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}

@js.native
trait Dock extends js.Object with EventEmitter {
  def hide(): Unit = js.native
}

//@js.native
//object Dock extends js.Object  {
//  def hide(): Unit = js.native
//
//  // TODO
//  // app.setUserTasks(tasks)
//  // app.commandLine.appendSwitch(switch, [value])
//  // app.commandLine.appendArgument(value)
//  // app.dock.bounce([type])
//  // app.dock.cancelBounce(id)
//  // app.dock.setBadge(text)
//  // app.dock.getBadge()
//  // app.dock.hide()
//  // app.dock.show()
//  // app.dock.setMenu(menu)
//
//}