package node.http

import scala.scalajs.js

@js.native
trait Http extends js.Object {

  def request(options: RequestOption, callback: js.Function1[Any, Unit]): ClientRequest = js.native

  def request(options: RequestOption): ClientRequest = js.native

}


case class RequestOption(host: String,
                         port: Int = 80,
                         method: String = "GET",
                         path: String = "/")
//case class RequestOption(host: String,
//                         hostname: Option[String] = None,
//                         port: Int = 80,
//                         localAddress: String = "0.0.0.0",
//                         method: String = "GET",
//                         path: String = "/",
//                         headers: RequestHeaders = RequestHeaders(),
//                         auth: Option[String] = None)

case class RequestHeaders(contentType: String = "text/plain")

@js.native
trait ClientRequest extends js.Object {
  def end(): Unit = js.native

  def on(event: String, listener: js.Function3[Any, Any, Any, Unit]): ClientRequest = js.native

}
