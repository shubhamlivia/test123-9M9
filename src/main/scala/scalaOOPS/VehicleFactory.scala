/**
 * let's explore the Factory design pattern
 * We'll create a simple program to demonstrate a factory for creating different types of vehicles
 * 
 * This example demonstrates the Factory design pattern, where the factory (VehicleFactory) encapsulates
 * the logic for creating different types of objects (Car and Motorcycle) based on user input.
 * This pattern allows for centralized creation and decouples the client code from the
 * specific implementations of objects.
 */

package scalaOOPS

object VehicleFactory {
  def createVehicle(vehicleType: String):Vehicle = {
    vehicleType.toLowerCase() match {
      case "car" => new Car()
      case "motorcycle" => new MotorCycle()
      case _ => throw new IllegalArgumentException("Invalid Vehicle Type")
    }
  }

  def main(args: Array[String]): Unit = {
    val car: Vehicle = VehicleFactory.createVehicle("car")
    val motorcycle: Vehicle = VehicleFactory.createVehicle("motorcycle")

    car.drive()
    motorcycle.drive()
  }
}

trait Vehicle {
  def drive(): Unit
}

class Car extends Vehicle {
  override def drive() = println("Driving the Car")
}

class MotorCycle extends Vehicle {
  override def drive() = println("Riding the motorcycle")
}

