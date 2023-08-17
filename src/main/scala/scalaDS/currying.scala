package scalaDS

object currying extends App{

  def add(x:Int):Int => Int = x => x*2

  println(add(11))

}
