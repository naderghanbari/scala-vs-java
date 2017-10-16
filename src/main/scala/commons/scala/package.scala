package commons

package object scala {

  case class Config(notificationEnabled: Boolean)

  case class User(firstName: String, lastName: String) {
    def fullName: String = s"$firstName $lastName"
  }

  val config = Config(notificationEnabled = true)
  val currentUser = User("Jane", "Doe")

  def notifyUser(user: User, message: String): Unit = println(s"Notified ${user.fullName} with [$message]")

}
