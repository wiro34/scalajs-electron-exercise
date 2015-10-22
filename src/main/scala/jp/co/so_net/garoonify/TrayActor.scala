package jp.co.so_net.garoonify

import scala.scalajs.js
import js.Dynamic.{global => g}
import org.scalajs.dom
import org.scalajs.dom.html
import dom.document
import akka.actor._
import scala.concurrent.duration._
import akka.util.Timeout
import io.atom.electron._

trait TrayMenu {
  val menu = g.require("menu").asInstanceOf[Menu]
  val tray = g.require("tray").asInstanceOf[js.Dynamic]
  val iconPath = "src/electron/icon.png"

  val appIcon = js.Dynamic.newInstance(tray)(iconPath).asInstanceOf[Tray]
  val template = js.Array(
    js.Dynamic.literal(label = "Item1", `type` = "radio")
  )
  var contextMenu = menu.buildFromTemplate(template)
  appIcon.setContextMenu(contextMenu)

//  appIcon.on()
}

class TrayActor extends Actor with TrayMenu {
  def receive = {
    case e: dom.Event =>
      println("OK")
  }
}

trait DOMElement[A <: html.Element] { this: Actor =>
  val id: String
  val element = document.getElementById(id).asInstanceOf[A]

  element.addEventListener("click", (m: dom.Event) => {
    println("on click!")
    self ! m
  })
  //element.addEventListener("change", (m: dom.Event) => self ! m)
  //element.addEventListener("keyup", (m: dom.Event) => self ! m)
}
