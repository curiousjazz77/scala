/*
In Java, as well as in Scala, a class can only have ONE superclass

But what if a class has several natural supertypes to which it confirm or from
which it wants to inherit code?

Here, you can use `traits`

A trait is declared like an abstract class, just with `trait` instead of `abstract class`
*/

trait Planar {
  def height: Int
  def width: Int
  def surface = height * width
}
