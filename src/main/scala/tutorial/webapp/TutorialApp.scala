package tutorial.webapp

import scala.scalajs.js
import org.scalajs.dom
import org.scalajs.dom.html
import dom.document
import akka.actor._
import scala.concurrent.duration._
import akka.util.Timeout

class TweetActor(val id: String = "tweettext") extends Actor {
  def receive = {
    case e: dom.Event =>
      println("OK")
  }
}

object TutorialApp extends js.JSApp {
  val system = ActorSystem("tutorial-app")

  def main(): Unit = {
    system.actorOf(Props(classOf[TweetActor]))
    println("Hello world!")
  }
}
