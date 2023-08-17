package scalaPractice

object CompanionObject extends App{

class Circle(radius: Double){
  import Circle._
  def area: Double = calculateArea(radius)
}

object Circle {
  def calculateArea(radius:Double): Double ={
    math.Pi * radius * radius
  }
}

  val circle = new Circle(5.0)
  println(circle.area)


  val x4= 99

  x4 match {
    case 1 => println("1")
    case 4 => println("4")
    case _ => println("None")
  }




}


