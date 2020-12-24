/*
So far we've executed all Scala code from the REPL or the worksheet, but it's also possible to create standalone applications.
Each such applications would contain an object and that object contains a main method.
Let;s look at this with the mandatory Hello World program with name, scala.
So, you would drive an object, name it Hello.
It has a main method, then, as in Java, that main method will have to take an array of strings.
You can ignore that for the time being. And the body of the main method would be a printIn with hello world.
Once you compile this program, you can start it from the command line simply with scala and then Hello.
Or you could also use Java and Hello, that would do the same thing in this case. So let me demonstrate that in Eclipse.
So we create in the week three package this time not a worksheet but a Scala object. Call it Hello.
*/

object Hello {
  def main(args: Array[String]) = println("hello world")
}

// once the program is compiled, you can start it from the command line with:
// > scala Hello
