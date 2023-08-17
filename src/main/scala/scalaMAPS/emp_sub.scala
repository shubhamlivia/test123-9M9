package scalaMAPS

object emp_sub extends App{
  class Employee(val id: Int, val name: String)

  class OpenAddressingHashTable(size: Int) {
    private val table: Array[Option[Employee]] = Array.fill(size)(None)

    private def hashFunction(key: Int): Int = key % size

    def insert(employee: Employee): Unit = {
      var key = hashFunction(employee.id)
      var index = key

      while (table(index).isDefined) {
        index = (index + 1) % size
        if (index == key) {
          // Hash table is full
          throw new Exception("Hash table is full")
        }
      }

      table(index) = Some(employee)
    }

    def search(id: Int): Option[Employee] = {
      var key = hashFunction(id)
      var index = key

      while (table(index).isDefined) {
        if (table(index).exists(_.id == id)) {
          return table(index)
        }

        index = (index + 1) % size
        if (index == key) {
          // Reached the original index, item not found
          return None
        }
      }

      None
    }

    def display(): Unit = {
      for (i <- 0 until size) {
        table(i) match {
          case Some(employee) => println(s"Index $i: ${employee.id}, ${employee.name}")
          case None => println(s"Index $i: Empty")
        }
      }
    }
  }

  // Usage example:
  val hashTable = new OpenAddressingHashTable(5)

  hashTable.insert(new Employee(101, "John"))
  hashTable.insert(new Employee(102, "Emily"))
  hashTable.insert(new Employee(201, "Michael"))
  hashTable.insert(new Employee(103, "Sarah"))
  hashTable.insert(new Employee(202, "David"))

  hashTable.display()

  val employee = hashTable.search(107)
  employee.foreach(emp => println(s"Found employee: ${emp.id}, ${emp.name}"))

}
