package io.atom.electron

import scala.scalajs.js
import scala.scalajs.js.Dynamic.{global => g}

@js.native
trait Tray extends js.Object with EventEmitter {

  def setToolTip(tooltip: String): Unit = js.native

  def setContextMenu(contextMenu: Menu): Unit = js.native

}
