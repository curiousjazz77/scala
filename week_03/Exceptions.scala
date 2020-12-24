object scratch {

  def error(msg: String) = throw new Error(msg)
  
  error("test") //java.lang.Error thrown
}
