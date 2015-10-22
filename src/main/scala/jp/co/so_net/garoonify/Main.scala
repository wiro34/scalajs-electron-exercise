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

object Main extends js.JSApp {
  def main(): Unit = {
    val app = g.require("app").asInstanceOf[App]
//    val menu = g.require("menu").asInstanceOf[Menu]
//    val tray = g.require("tray").asInstanceOf[js.Dynamic]
//    val iconPath = "src/electron/icon.png"

//    val system = ActorSystem("tutorial-app")

    // Report crashes to our server.
    g.require("crash-reporter").start()

    // Keep a global reference of the window object, if you don't, the window will
    // be closed automatically when the JavaScript object is GCed.
    var mainWindow: BrowserWindow = null

    // Quit when all windows are closed.
    //    app.on("window-all-closed", { () =>
    //      // On OS X it is common for applications and their menu bar
    //      // to stay active until the user quits explicitly with Cmd + Q
    //      if (Process.platform != "darwin") {
    //        app.quit()
    //      }
    //    });

    // This method will be called when Electron has finished
    // initialization and is ready to create browser windows.
    app.on("ready", () => {
      //      app.dock.hide()
//      system.actorOf(Props(new TrayActor))

//      val appIcon = js.Dynamic.newInstance(tray)(iconPath).asInstanceOf[Tray]
//      val template = js.Array(
//        js.Dynamic.literal(label = "Item1", `type` = "radio")
//      )
//      var contextMenu = menu.buildFromTemplate(template)
//      appIcon.setToolTip("This is my application.");
//      appIcon.setContextMenu(contextMenu);

      // Create the browser window.
      mainWindow = BrowserWindow(width = 800, height = 600)

      // and load the index.html of the app.
      mainWindow.loadUrl("file://" + g.__dirname + "/index.html")

      // Open the devtools.
      mainWindow.openDevTools()

      // Emitted when the window is closed.
      val _ = mainWindow.on("closed", () =>
        // Dereference the window object, usually you would store windows
        // in an array if your app supports multi windows, this is the time
        // when you should delete the corresponding element.
        mainWindow = null
      )
    })
  }
}
