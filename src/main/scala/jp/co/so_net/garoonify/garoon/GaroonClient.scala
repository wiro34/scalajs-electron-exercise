package jp.co.so_net.garoonify.garoon

import akka.actor.{Props, Actor}
import akka.util.Timeout

class GaroonClientActor extends Actor {

  import GaroonActorProtocol._

  def receive = {
    case TakeSchedule(date) =>
      println(date.toString)

      val request = """
      <parameters text="Test"
                  start="2015-10-20T00:00:00Z" end="2015-10-20T23:59:59Z"
                  title_search="true" customer_search="false"
                  memo_search="false" follow_search="false"
                  all_repeat_events="false">
      </parameters>
      """
  }
}

object GaroonClientRepository {
  //  private[this] val repository = Akka.system.actorOf(Props[GaroonClientActor])
}

//trait ChatRoomRepository {
//  val repository = ChatRoomRepository
//}
