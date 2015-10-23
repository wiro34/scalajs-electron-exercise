package jp.co.so_net.garoonify.util

import node.http.{Http, RequestOption}

import scala.scalajs.js
import js.Dynamic.{global => g}
import scala.concurrent.{Promise, Future}
import org.scalajs.dom.{XMLHttpRequest, Event}

object HttpClient2 {
  val http = g.require("http").asInstanceOf[Http]

  def get(url: String): Future[XMLHttpRequest] = apply("GET", url)

  def post(url: String, data: String): Future[XMLHttpRequest] = apply("POST", url, Option(data))

  def apply(method: String, url: String, data: Option[String] = None): Future[XMLHttpRequest] = {
    val options = RequestOption(host = "")
    http.request(options)

//    val req = new XMLHttpRequest()
    val promise = Promise[XMLHttpRequest]
//
//    req.withCredentials = true
//
//    req.onreadystatechange = (e: Event) => {
//      if (req.readyState.toInt == 4) {
//        if (200 <= req.status && req.status < 300) {
//          promise.success(req)
//        } else {
//          promise.failure(AjaxException(req))
//        }
//      }
//    }
//
//    req.open(method, url, true)
//
//    data match {
//      case Some(d) => req.send(d)
//      case None => req.send()
//    }
//
    promise.future
  }
}
