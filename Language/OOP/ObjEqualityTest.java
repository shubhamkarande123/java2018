class ObjEqualityTest{

	public static void main(String[] args){
		Interval a = new Interval(3, 5);
		Interval b = new Interval(4, 30);
		Interval c = new Interval(2, 65);
		Interval d = b;
		Interval e = Interval.add(a, b);
		System.out.printf("Interval a = %s%n", a);
		System.out.printf("Interval b = %s%n", b);
		System.out.printf("Interval c = %s%n", c);
		System.out.printf("Interval d = %s%n", d);
		System.out.printf("Interval e = %s%n", e);
		System.out.printf("a is identical to b: %b%n", a == b);
		System.out.printf("a is identical to c: %b%n", a == c);
		System.out.printf("d is identical to b: %b%n", d == b);
		System.out.printf("a is equal to b: %b%n", a.hashCode() == b.hashCode() && a.equals(b));
		System.out.printf("a is equal to c: %b%n", a.hashCode() == c.hashCode() && a.equals(c));
		System.out.printf("d is equal to b: %b%n", d.hashCode() == b.hashCode() && d.equals(b));
	}
}


