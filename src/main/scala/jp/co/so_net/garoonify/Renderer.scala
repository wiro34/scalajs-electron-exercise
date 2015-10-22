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

import scala.scalajs.js.annotation.JSExport

@JSExport
object Renderer {
  val system = ActorSystem("tutorial-app")

  @JSExport
  def main(): Unit = {
          system.actorOf(Props(new TrayActor))
  }
}
