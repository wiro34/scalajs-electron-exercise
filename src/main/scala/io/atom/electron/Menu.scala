package io.atom.electron

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}
import js.Dynamic

@js.native
trait Menu extends js.Object with EventEmitter {
  def buildFromTemplate(template: js.Array[js.Object with scala.scalajs.js.Dynamic]): ContextMenu = js.native

  def append(menuItem: MenuItem): Unit = js.native
}

//case class MenuTemplate(label: String, typ: String) extends js.Object

@js.native
trait ContextMenu extends js.Object with EventEmitter {

}

@js.native
trait MenuItem extends js.Object {

}
