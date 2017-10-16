package syntax.semicolons.scala

import commons.scala._

object Semicolons extends App {
  val message = "Error occurred!"
  val shouldNotifyUser = config.notificationEnabled
  if (shouldNotifyUser) notifyUser(currentUser, message)
}
