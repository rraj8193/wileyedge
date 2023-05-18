In a nutshell, generics enable types (classes and interfaces) to be parameters when defining classes, interfaces and methods. Much like the more familiar formal parameters used in method declarations, type parameters provide a way for you to re-use the same code with different inputs. The difference is that the inputs to formal parameters are values, while the inputs to type parameters are types.

-> Stronger type checks at compile time.
	A Java compiler applies strong type checking to generic code and issues errors if the 	code violates type safety. Fixing compile-time errors is easier than fixing runtime 	errors, which can be difficult to find.

-> Elimination of casts.
	The following code snippet without generics requires casting:

	List list = new ArrayList();
	list.add("hello");
	String s = (String) list.get(0);

	When re-written to use generics, the code does not require casting:

	List<String> list = new ArrayList<String>();
	list.add("hello");
	String s = list.get(0);   // no cast

-> Enabling programmers to implement generic algorithms.
	By using generics, programmers can implement generic algorithms that work on collections 	of different types, can be customized, and are type safe and easier to read.
	
(X) Why can't we use objects in classes?
ans:- 
	public class Box {
	    private Object object;
	
	    public void set(Object object) { this.object = object; }
	    public Object get() { return object; }
	}
	
	Since its methods accept or return an Object, you are free to pass in whatever you 	want, provided that it is not one of the primitive types. There is no way to verify, 	at 	compile time, how the class is used. One part of the code may place an Integer in 	the box and expect to get Integers out of it, while another part of the code may 	mistakenly 	pass in a String, resulting in a runtime error.
	
	Solution to the problem lies in the generics.
	
		public class Box<T> {
	    // T stands for "Type"
	    private T t;
	
	    public void set(T t) { this.t = t; }
	    public T get() { return t; }
	}
	
	As you can see, all occurrences of Object are replaced by T. A type variable can be any 	non-primitive type you specify: any class type, any interface type, any array type, or 	even another type variable.
	
	This same technique can be applied to create generic interfaces.


(X) Terminology:-
	Type Parameter and Type Argument Terminology: Many developers use the terms "type 	parameter" and "type argument" interchangeably, but these terms are not the same. When 	coding, one provides type arguments in order to create a parameterized type. Therefore, 	the T in Foo<T> is a type parameter and the String in Foo<String> f is a type argument. 	
	Box<Integer> integerBox;
	
	Like any other variable declaration, this code does not actually create a new Box 	object. It simply declares that integerBox will hold a reference to a "Box of Integer", 	which is how Box<Integer> is read.
	
(X) Multiple Type Parameters

	public interface Pair<K, V> {
	    public K getKey();
	    public V getValue();
	}
	
	public class OrderedPair<K, V> implements Pair<K, V> {
	
	    private K key;
	    private V value;
	
	    public OrderedPair(K key, V value) {
		this.key = key;
		this.value = value;
	    }
	
	    public K getKey()	{ return key; }
	    public V getValue() { return value; }
	}
	The following statements create two instantiations of the OrderedPair class:

	Pair<String, Integer> p1 = new OrderedPair<String, Integer>("Even", 8);
	Pair<String, String>  p2 = new OrderedPair<String, String>("hello", "world");
	
	K and V can be any non-primitive datatypes.
	
	OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>(...));

(X) Raw Type Generics:-
	
	If the actual type argument is omitted, you create a raw type of Box<T>:

	Box rawBox = new Box();
	
	Therefore, Box is the raw type of the generic type Box<T>. However, a non-generic class or interface 	type is not a raw type.
	
	Raw types show up in legacy code because lots of API classes (such as the Collections classes) were not 	generic prior to JDK 5.0. When using raw types, you essentially get pre-generics behavior — a Box gives 	you Objects. For backward compatibility, assigning a parameterized type to its raw type is allowed:
	
	Box<String> stringBox = new Box<>();
	Box rawBox = stringBox;               // OK
	
	But if we assign a raw type to a parameterized type, you get a warning:
	
	Box rawBox = new Box();           // rawBox is a raw type of Box<T>
	Box<Integer> intBox = rawBox;     // warning: unchecked conversion
	
	We also get a warning if you use a raw type to invoke generic methods defined in the corresponding 	generic type:
	
	Box<String> stringBox = new Box<>();
	Box rawBox = stringBox;
	rawBox.set(8);  // warning: unchecked invocation to set(T)
	
(X) Warnings :-
	Note: Example.java uses unchecked or unsafe operations.
	Note: Recompile with -Xlint:unchecked for details.
	
(X) Generic methods:-

	The reason for using the generic methods is that while handling different types of data we have to use operator overloading which 	is a kind of redundant task and we have to write code multiple times but using generic methods gives us ease of handling 	different datatypes from a single method. ( Ref: GenericOverOverloading.java )
	
	However, overloading methods based on only different genric type argument throws error asErasure of method print(List<Integer>) 	is the same as another method in type GenericOverOverloading. Which indicates that it causes problem in because of legacy code 	where there is no concept of generics.
	For example below given code throws the same error.
	
	public static void print(List<Integer> list) {
		System.out.println("Overloaded as Integer method called");
		System.out.println(list);
	}
	
	public static void print(List<String> list) {
		System.out.println("Overloaded as String method called");
		System.out.println(list);
	}
	
	
	Beside that it also give us an upperhand over implementing custom function having different datatypes than in-built datatypes.
	( Ref: GenericMethod1.java)
	
(X) Bounded Type Parameters

	=> In all the above discussed cases, there is no restriction while passing the type arguments in the generic class or generic 	methods, but sometimes we want to bound the type of type arguments. For example, we might want that the generic class or method 	only accept the argument which are in number format such as Integer, Long, Float, Double e.t.c.
	=> Bounded type parameter help us in doing that. We can bound the type parameters for the specific types or subtypes based on the 	class hierachy.
	
	(Ref: BoundedTypeParameter.java and BoundTypeMethod.java) 
	
	
(X) Multiple Bound
	=> We can also bound any type argument with multiple datatypes but it should be in order of class and then interface.
	class Box<T extends A & B & C>{ ..... } or,
	public static <T extends A & B & C> boolean method(){.....}
	
	
(X) Logical Operators on Generics:-
	
	When we use genric classes or methods we cannot use logical operator directly on them. As relational operators works mostly on 	primitive datatypes and not on the object type. So in order to make comparisons between the generic objects we have to use 	comparable interface.
	
	(Ref : GenericComparison.java)
	
	
(X) Generic Inheritance and Subtypes
	
	=> It is impotant for us to understand inheritance as compatiblity of type arguments depends on it. 
	
	public void someMethod(Number n) { /* ... */ }

	someMethod(new Integer(10));   // OK
	someMethod(new Double(10.1));   // OK
	
	But, 
	
	public void boxTest(Box<Number> n) { /* ... */ }
	
	boxTest(Box<Number>); //OK
	boxTest(Box<Integer>); // compiler error
	
	So, here we can say that whether Number or Integer are having some relation but the same not goes with Box<Number> and 	Box<Integer>, they both inherits the object class.
	
	interface PayloadList<E,P> extends List<E> {
	  	void setPayload(int index, P val);
		  ...
	}
	
	The following parameterizations of PayloadList are subtypes of List<String>:
	
	PayloadList<String,String>
	PayloadList<String,Integer>
	PayloadList<String,Exception>
	
	
(X) Type Inference and Generic Methods:
	
	Generic Methods introduced you to type inference, which enables you to invoke a generic method as you would an ordinary 	method, without specifying a type between angle brackets. Consider the following example, BoxDemo, which requires the Box class:
	
	public class BoxDemo {
	
	  public static <U> void addBox(U u, 
	      java.util.List<Box<U>> boxes) {
	    Box<U> box = new Box<>();
	    box.set(u);
	    boxes.add(box);
	  }
	
	  public static <U> void outputBoxes(java.util.List<Box<U>> boxes) {
	    int counter = 0;
	    for (Box<U> box: boxes) {
	      U boxContents = box.get();
	      System.out.println("Box #" + counter + " contains [" +
	             boxContents.toString() + "]");
	      counter++;
	    }
	  }
	
	  public static void main(String[] args) {
	    java.util.ArrayList<Box<Integer>> listOfIntegerBoxes =
	      new java.util.ArrayList<>();
	    BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
	    BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
	    BoxDemo.addBox(Integer.valueOf(30), listOfIntegerBoxes);
	    BoxDemo.outputBoxes(listOfIntegerBoxes);
	  }
	}
	The following is the output from this example:
	
	Box #0 contains [10]
	Box #1 contains [20]
	Box #2 contains [30]
	The generic method addBox defines one type parameter named U. Generally, a Java compiler can infer the type parameters of a 	generic method call. Consequently, in most cases, you do not have to specify them. For example, to invoke the generic method 	addBox, you can specify the type parameter with a type witness as follows:
	
	BoxDemo.<Integer>addBox(Integer.valueOf(10), listOfIntegerBoxes);
	Alternatively, if you omit the type witness,a Java compiler automatically infers (from the method's arguments) that the type 	parameter is Integer:
	
	BoxDemo.addBox(Integer.valueOf(20), listOfIntegerBoxes);
	
	
(X) Type Inference and Generic Constructors of Generic and Non-Generic Classes

	Note that constructors can be generic (in other words, declare their own formal type parameters) in both generic and non-generic 	classes. Consider the following example:

	class MyClass<X> {
	  <T> MyClass(T t) {
	    // ...
	  }
	}
	Consider the following instantiation of the class MyClass:
	
	new MyClass<Integer>("")
	
	This statement creates an instance of the parameterized type MyClass<Integer>; the statement explicitly specifies the type 	Integer for the formal type parameter, X, of the generic class MyClass<X>. Note that the constructor for this generic class 	contains a formal type parameter, T. The compiler infers the type String for the formal type parameter, T, of the constructor of 	this generic class (because the actual parameter of this constructor is a String object).
	(Ref: GenericConstructor.java)

(X)	Target Types
	The Java compiler takes advantage of target typing to infer the type parameters of a generic method invocation. The target 	type 	of an expression is the data type that the Java compiler expects depending on where the expression appears. Consider the 	method Collections.emptyList, which is declared as follows:
	
	static <T> List<T> emptyList();
	Consider the following assignment statement:
	
	List<String> listOne = Collections.emptyList();
	This statement is expecting an instance of List<String>; this data type is the target type. Because the method emptyList returns 	a value of type List<T>, the compiler infers that the type argument T must be the value String. This works in both Java SE 7 and 	8. Alternatively, you could use a type witness and specify the value of T as follows:
	
	List<String> listOne = Collections.<String>emptyList();
	However, this is not necessary in this context. It was necessary in other contexts, though. Consider the following method:
	
	void processStringList(List<String> stringList) {
	    // process stringList
	}
	Suppose you want to invoke the method processStringList with an empty list. In Java SE 7, the following statement does not 	compile:
	
	processStringList(Collections.emptyList());
	The Java SE 7 compiler generates an error message similar to the following:
	
	List<Object> cannot be converted to List<String>
	The compiler requires a value for the type argument T so it starts with the value Object. Consequently, the invocation of 	Collections.emptyList returns a value of type List<Object>, which is incompatible with the method processStringList. Thus, in 	Java SE 7, you must specify the value of the value of the type argument as follows:
	
	processStringList(Collections.<String>emptyList());
	
(X) Wildcards

	In generic code, the question mark (?), called the wildcard, represents an unknown type. The wildcard can be used in a variety of 	situations: as the type of a parameter, field, or local variable; sometimes as a return type (though it is better programming 	practice to be more specific). The wildcard is never used as a type argument for a generic method invocation, a generic class 	instance creation, or a supertype.
	
(X) Upper Bounded Wildcards

	To write the method that works on lists of Number and the subtypes of Number, such as Integer, Double, and Float, you would 	specify List<? extends Number>. The term List<Number> is more restrictive than List<? extends Number> because the former matches 	a list of type Number only, whereas the latter matches a list of type Number or any of its subclasses.
	
	( Ref: Upper Bounded Wildcards)
	
(X) Unbounded Wildcards

	The unbounded wildcard type is specified using the wildcard character (?), for example, List<?>. This is called a list of unknown 	type. There are two scenarios where an unbounded wildcard is a useful approach:

	If you are writing a method that can be implemented using functionality provided in the Object class.
	When the code is using methods in the generic class that don't depend on the type parameter. For example, List.size or 	List.clear. In fact, Class<?> is so often used because most of the methods in Class<T> do not depend on T.
	Consider the following method, printList:

	public static void printList(List<Object> list) {
	    for (Object elem : list)
	        System.out.println(elem + " ");
	    System.out.println();
	}
	The goal of printList is to print a list of any type, but it fails to achieve that goal — it prints only a list of Object 	instances; it cannot print List<Integer>, List<String>, List<Double>, and so on, because they are not subtypes of List<Object>. 	To write a generic printList method, use List<?>:

	public static void printList(List<?> list) {
	    for (Object elem: list)
	        System.out.print(elem + " ");
	    System.out.println();
	}

(X) Lower Bound Wildcard	
	
	A lower bounded wildcard is expressed using the wildcard character ('?'), following by the super keyword, followed by its lower 	bound: <? super A>.

	Note: You can specify an upper bound for a wildcard, or you can specify a lower bound, but you cannot specify both

	To write the method that works on lists of Integer and the supertypes of Integer, such as Integer, Number, and Object, you would 	specify List<? super Integer>. The term List<Integer> is more restrictive than List<? super Integer> because the former matches a 	list of type Integer only, whereas the latter matches a list of any type that is a supertype of Integer.
	
	Although Integer is a subtype of Number, List<Integer> is not a subtype of List<Number> and, in fact, these two types are not 	related. The common parent of List<Number> and List<Integer> is List<?>.
	
	In order to create a relationship between these classes so that the code can access Number's methods through List<Integer>'s 	elements, use an upper bounded wildcard:

	List<? extends Integer> intList = new ArrayList<>();
	List<? extends Number>  numList = intList;  // OK. List<? extends Integer> is a subtype of List<? extends Number>
	
(X) Wildcard Capture

		In some cases, the compiler infers the type of a wildcard. For example, a list may be defined as List<?> but, when evaluating 	an expression, the compiler infers a particular type from the code. This scenario is known as wildcard capture.
	
	For the most part, you don't need to worry about wildcard capture, except when you see an error message that contains the phrase 	"capture of".
	
	The WildcardError example produces a capture error when compiled:
	
	import java.util.List;
	
	public class WildcardError {
	
	    void foo(List<?> i) {
	        i.set(0, i.get(0));
	    }
	}
	
	
(X) Guidelines

	An "In" Variable
		An "in" variable serves up data to the code. Imagine a copy method with two arguments: copy(src, dest). The src argument 		provides the data to be copied, so it is the "in" parameter.
	An "Out" Variable
		An "out" variable holds data for use elsewhere. In the copy example, copy(src, dest), the dest argument accepts data, so it 		is 	the "out" parameter.
	
	Wildcard Guidelines: 
		An "in" variable is defined with an upper bounded wildcard, using the extends keyword.
		An "out" variable is defined with a lower bounded wildcard, using the super keyword.
		In the case where the "in" variable can be accessed using methods defined in the Object class, use an unbounded wildcard.
		In the case where the code needs to access the variable as both an "in" and an "out" variable, do not use a wildcard.
		
		
(X) Type Erasure
	Generics were introduced to the Java language to provide tighter type checks at compile time and to support generic programming. 	To implement generics, the Java compiler applies type erasure to:
	
		Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded. The produced 		bytecode, therefore, contains only ordinary classes, interfaces, and methods.
		Insert type casts if necessary to preserve type safety.
		Generate bridge methods to preserve polymorphism in extended generic types.
	Type erasure ensures that no new classes are created for parameterized types; consequently, generics incur no runtime overhead.































