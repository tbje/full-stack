package example

//import scala.jdk.CollectionConverters._

object Client {

  def main(args: Array[String]): Unit = {
    val zones = new java.util.HashSet[String](3)
    //zones.removeAll(Set("").asJava) // Call this first and no issue
    zones.remove("")
    zones.remove("1") // only if remove is called twice
  }


}
