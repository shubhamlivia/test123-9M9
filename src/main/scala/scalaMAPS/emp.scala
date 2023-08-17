package scalaMAPS

object emp extends App{
  class Employee(val id: Int, val name: String)

  class SeparateChainingHashTable(size: Int) {
    private val table: Array[List[Employee]] = Array.fill(size)(List.empty)

    private def hashFunction(key: Int): Int = key % size

    def insert(employee: Employee): Unit = {
      val key = hashFunction(employee.id)
      val bucket = table(key)
      table(key) = employee :: bucket
    }

    def search(id: Int): Option[Employee] = {
      val key = hashFunction(id)
      table(key).find(_.id == id)
    }

    def display(): Unit = {
      for (i <- 0 until size) {
        println(s"Index $i:")
        for (employee <- table(i)) {
          println(s"\t${employee.id}, ${employee.name}")
        }
      }
    }
  }

  // Usage example:
  val hashTable = new SeparateChainingHashTable(5)

  hashTable.insert(new Employee(101, "John"))
  hashTable.insert(new Employee(102, "Emily"))
  hashTable.insert(new Employee(201, "Michael"))
  hashTable.insert(new Employee(103, "Sarah"))
  hashTable.insert(new Employee(202, "David"))

  hashTable.display()

  val employee = hashTable.search(107)
  employee.foreach(emp => println(s"Found employee: ${emp.id}, ${emp.name}"))

}
