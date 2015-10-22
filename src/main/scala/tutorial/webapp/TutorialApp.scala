//package tutorial.webapp
//
//import scala.scalajs.js
//import js.Dynamic.{global => g}
//import org.scalajs.dom
//import org.scalajs.dom.html
//import dom.document
//import akka.actor._
//import scala.concurrent.duration._
//import akka.util.Timeout
//import io.atom.electron._
//
//trait DOMElement[A <: html.Element] { this: Actor =>
//  val id: String
//  val element = document.getElementById(id).asInstanceOf[A]
//
//  element.addEventListener("click", (m: dom.Event) => {
//    println("on click!")
//    self ! m
//  })
//  //element.addEventListener("change", (m: dom.Event) => self ! m)
//  //element.addEventListener("keyup", (m: dom.Event) => self ! m)
//}
//
//class TweetActor(val id: String = "body") extends Actor with DOMElement[html.Body] {
//  def receive = {
//    case e: dom.Event =>
//      println("OK")
//  }
//}
//
//object TutorialApp extends js.JSApp {
//  val system = ActorSystem("tutorial-app")
//
//  def main(): Unit = {
//    system.actorOf(Props(new TweetActor))
//    println("Hello world!")
//
//    val app = g.require("app").asInstanceOf[App]
//    val menu = g.require("menu").asInstanceOf[Menu]
//    val tray = g.require("tray").asInstanceOf[Tray]
//    val iconPath = app.getPath("icon.png")
////    var appIcon = new Tray(iconPath.toString());
////    var contextMenu = Menu.buildFromTemplate([
////      { label: 'Item1', type: 'radio' },
////      { label: 'Item2', type: 'radio' },
////      { label: 'Item3', type: 'radio', checked: true },
////      { label: 'Item4', type: 'radio' }
////      ]);
////    appIcon.setToolTip('This is my application.');
////    appIcon.setContextMenu(contextMenu);
//
//  }
//
//  def require[A](moduleName: String): A = g.require(moduleName).asInstanceOf[A]
//}
