package syntax.parameters.implicits.scala

import java.util.TimeZone

import commons.scala.User

object ImplicitParameters extends App {

  trait Controller {

    def service: Service

    /**
      * A showcase of implicit parameters in their simplest form.
      * Whoever calls this method (call site), need an implicit object of type `User` which will be
      * passed implicitly to this function.
      *
      * Passed implicit parameter will be available implicitly, so when this function
      * calls another function that also needs an implicit `User` parameter, passed parameter will be used.
      *
      * @param department  Department to search in.
      * @param currentUser Current user, call-site will have to make sure an implicit param o
      * @return All purchases or exception.
      */
    def allPurchases(department: String)(implicit currentUser: User, timeZone: TimeZone) = {
      // Note that parameter `currentUser` is passed implicitly when calling `service.findPurchasesByDepartment`
      // Same goes for `timeZone` when calling `service.findPurchasesByDepartment(department)`
      if (service.userHasAccessTo(department)) service.findPurchasesByDepartment(department)
      else throw new IllegalAccessException("Access to feature forbidden!")
    }
  }

  trait Service {
    def userHasAccessTo(department: String)(implicit currentUser: User): Boolean

    def findPurchasesByDepartment(department: String)(implicit timeZone: TimeZone): Any
  }

  Array(1, 2).sorted(Ordering.Int)

}
