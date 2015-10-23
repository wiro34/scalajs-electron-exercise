package jp.co.so_net.garoonify

import java.util.Date

import akka.actor.{ActorRef, Actor}
import jp.co.so_net.garoonify.garoon.GaroonActorProtocol
import jp.co.so_net.garoonify.icewall.IceWallClient

object ScheduledActorProtocol {

  case class Update(target: String)

  case class Schedule(interval: Int)

}

class ScheduledActor(garoonClient: ActorRef) extends Actor {

  import ScheduledActorProtocol._
  import GaroonActorProtocol._
  import scala.concurrent.duration._

  val system = context.system
  implicit val executionContext = system.dispatcher

  def receive = {
    case Update(target) =>
      println("update " + target)
      garoonClient ! TakeSchedule(new Date(2015, 10, 26))
      IceWallClient.login("test", "test")

    case Schedule(interval) =>
      println("Scheduled!")
      system.scheduler.schedule(1.seconds, interval.minutes, self, Update("foo"))
  }
}


