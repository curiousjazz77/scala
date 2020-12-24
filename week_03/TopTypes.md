At the top of the hierarchy:

  - Any - the base type of all types; Methods: '==', '!=', 'equals', 'hashCode', 'toString'

  - AnyRef - The base type of all reference types; Alias of `java.lang.Object`

  - AnyVal - The base type of all primitive types
  
  
  
The Nothing Type
- Nothing is at the bottom of Scala's type hierarchy. It's a subtype of every other type.
- There is no value of type Nothing
- Why is that useful?
    - to signal abnormal termination
    - As an element type of empty collections (see next session)


What is the type of `if (true) 1 else false` ? AnyVal
