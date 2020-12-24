/*
In Java, as well as in Scala, a class can only have ONE superclass (single inheritance)

But what if a class has several natural supertypes to which it confirm or from
which it wants to inherit code?

Here, you can use `traits`

A trait is declared like an abstract class, just with `trait` instead of `abstract class`

Example:
  class Square extends Shape with Planar with Movable
  
Traits resemble interfaces in Java, but are more powerful because
they can contain fields and concrete methods.

On the other hand, traits can't have (value) parameters, only classes can
*/

trait Planar {
  def height: Int
  def width: Int
  def surface = height * width
}
