object overrides {
  println("Welcome to the Scala Worksheet")
}

abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2 //scala checks if there is in fact a def to override
  def bar = 3 
}
