package com.lansrod.scala.annotations

object AnnotationsAffectingCodeGeneration extends App {

  /*Some annotations like @inline affect the generated code (i.e. your jar file might have different bytes than if you hadn’t used the annotation).
   *Inlining means inserting the code in a method’s body at the call site. The resulting bytecode is longer, but hopefully runs faster.
   *Using the annotation @inline does not ensure that a method will be inlined, but it will cause the compiler to do it
   *if and only if some heuristics about the size of the generated code are met.
   */

  //Java Annotations
  //When writing Scala code which interoperates with Java, there are a few differences in annotation syntax to note.
  //Note: Make sure you use the -target:jvm-1.8 option with Java annotations.

  //Java has user-defined metadata in the form of annotations.
  //A key feature of annotations is that they rely on specifying name-value pairs to initialize their elements.
  //For instance, if we need an annotation to track the source of some class we might define it as

  //@interface Source {
  //  public String URL();
  //  public String mail();
  //}

  //And then apply it as follows

  //  @Source(URL = "http://coders.com/",
  //        mail = "support@coders.com")
  //public class MyClass extends HisClass ...

  //An annotation application in Scala looks like a constructor invocation, for instantiating a Java annotation one has to use named arguments:

  //  @Source(URL = "http://coders.com/",
  //        mail = "support@coders.com")
  //class MyScalaClass ...

  //This syntax is quite tedious if the annotation contains only one element (without default value) so, by convention,
  //if the name is specified as value it can be applied in Java using a constructor-like syntax:

  //  @interface SourceURL {
  //    public String value();
  //    public String mail() default "";
  //}

  //And then apply it as follows

  //  @SourceURL("http://coders.com/")
  //public class MyClass extends HisClass ...

  //In this case, Scala provides the same possibility

  //  @SourceURL("http://coders.com/")
  //class MyScalaClass ...

  //The mail element was specified with a default value so we need not explicitly provide a value for it.
  //However, if we need to do it we can not mix-and-match the two styles in Java:

  //  @SourceURL(value = "http://coders.com/",
  //           mail = "support@coders.com")
  //public class MyClass extends HisClass ...

  //Scala provides more flexibility in this respect

  //@SourceURL("http://coders.com/",
  //           mail = "support@coders.com")
  //    class MyScalaClass ...

}


