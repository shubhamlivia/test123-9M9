package scalaPractice

import scala.annotation.tailrec

object Trait1 extends App{

trait Shape {
  def area: Double
  def perimeter: Double
}

class Rectangle(width:Double, height:Double ) extends Shape{
  override def area: Double = width * height
  override def perimeter: Double  = 2 * width * height
}

class Circle(radius: Double) extends Shape {
  override def area: Double = math.Pi * (radius * radius)
  override def perimeter: Double = 2 * math.Pi * radius
}

class Triangle(width:Double, height: Double) extends Shape{
  override def area: Double = 0.5 * height * width
  override def perimeter: Double = width + (2 * Math.sqrt((0.25 * width * width) + (height + height)))

}

  val rectangle  = new Rectangle(5,10)
  println("Rectangle Area: " + rectangle.area)
  println("Rectangle Perimeter: " + rectangle.perimeter)

  val x = 1 :: 2 :: 3 :: Nil
  println(x)

  val y = Nil

  println(y)

  val x11:Option[Int] = Some(121)
  println(x11)


  val list = List(1,2,3,4,5)

  val yy = for(xyz <- list) yield xyz * 2
  println(yy)

  for(i<- list)
    {
      println(i *2)
    }

}
