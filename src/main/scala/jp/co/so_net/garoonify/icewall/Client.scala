package jp.co.so_net.garoonify.icewall

import akka.actor.{Props, Actor}
import jp.co.so_net.garoonify.Akka
import node.http.{RequestOption, Http}

import scala.concurrent.Future
import scala.scalajs.js
import js.Dynamic.{global => g}

object HttpClientProtocol {

  case class Respond(body: String)

}

trait HttpClient {
  this: Actor =>

  import HttpClientProtocol._

  val http = g.require("http")

  def get(url: String) = {
    val buffer = new StringBuilder
    http.get(url, (res: Response) => {
      res.setEncoding("utf8")
      res.on("data", (chunk: String) => buffer.append(chunk))
      res.on("end", () => {
        self ! Respond(buffer.mkString)
      })
    })
  }
}

@js.native
trait Response extends js.Object {
  def setEncoding(encoding: String): Unit = js.native

  def on(event: String, callback: js.Function1[String, Any]): Unit = js.native

  def on(event: String, callback: js.Function0[Any]): Unit = js.native
}

object IceWallProtocol {

  case class Login(username: String, password: String)

}

class IceWallClientActor extends Actor with HttpClient {

  import HttpClientProtocol._
  import IceWallProtocol._

  def receive = {
    case Login(username, password) =>
      get("http://www.google.co.jp/")

    case Respond(body) =>
      println("Respond!")
      println(body)
  }
}

object IceWallClient {

  import IceWallProtocol._

  val icewallActor = Akka.system.actorOf(Props(classOf[IceWallClientActor]))

  def login(username: String, password: String) = icewallActor ! Login(username, password)

}

@js.native
trait Request extends js.Object {
}
