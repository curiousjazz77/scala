/*
Every reference clas type also has a null value
The type null is Null.
Null is a subtype of every class that inherits from Object

It is INCOMPATIBLE with subtypes of AnyVal
*/

val x = null              // x: null
val y: String = null.     // y: String
val z: Int = null         // error: type mismatch
