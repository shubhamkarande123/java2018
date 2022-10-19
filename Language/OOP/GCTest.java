class SomeResource implements AutoCloseable{

	private String id;

	static{
		System.out.println("SomeResource class initialized");
	}

	SomeResource(String name){
		id = name;
		System.out.printf("%s resource acquired%n", id);
	}

	public void consume(){
		System.out.printf("%s resource consumed%n", id);
	}

	public void close(){
		if(id != null){
			System.out.printf("%s resource released%n", id);
			id = null;
		}
	}

	//invoked by GC when this object is reclaimed
	public void finalize(){
		close();
	}

}

class GCTest{
	
	private static void run(){
		SomeResource b = new SomeResource("second");
		b.consume();
	}

	public static void main(String[] args){
		SomeResource a = new SomeResource("first");
		run();
		System.gc(); //request garbage collection (GC)
		a.consume();
		a.close();
		//try-with-resource - will invoke close method of an AutoCloseable object
		try(SomeResource c = new SomeResource("third")){
			c.consume();
		}
	}
}


