case class Student(name: String, address: Seq[Address])
case class Address(city: String, state: String)

// https://www.journaldev.com/8270/scala-extractors-apply-unapply-and-pattern-matching
object City {
  def unapply(s: Student): Option[Seq[String]] =
    Some(
      for (c <- s.address)
        yield c.state)
}
class StringSeqContains(value: String) {
  def unapply(in: Seq[String]): Boolean =
    in contains value
}
object PatternMatch {
  def main(args: Array[String]) {

    val stud = List(Student("Harris", List(Address("LosAngeles", "California"))),
      Student("Reena", List(Address("Houston", "Texas"))),
      Student("Rob", List(Address("Dallas", "Texas"))),
      Student("Chris", List(Address("Jacksonville", "Florida"))))

    val texas: StringSeqContains = new StringSeqContains("Texas")
    val students = stud collect {
      case student @
        City(texas()) =>
        student.name
    }
    println(students)
  }
}