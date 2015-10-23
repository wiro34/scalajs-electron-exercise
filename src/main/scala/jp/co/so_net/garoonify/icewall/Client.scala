package jp.co.so_net.garoonify.icewall

import jp.co.so_net.garoonify.util.HttpClient


object Client {
  def login(username: String, password: String) = {
    HttpClient.get("")
//    val httpClient = new HttpClient
//    val response: Response = httpClient.get("http://www.google.com/")
//    println(response.status)
//    println(response.body.asString)
//    val googleTop = Http(request OK as.String)
//    println(googleTop())
  }
}
