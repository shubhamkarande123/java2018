class Interval implements Comparable<Interval>{

	private int min, sec;

	public Interval(int m, int s){
		min = m + s / 60;
		sec = s % 60;
	}

	public int minutes(){
		return min;
	}

	public int seconds(){
		return sec;
	}

	public int time(){
		return 60 * min + sec;
	}

	public static Interval add(Interval lhs, Interval rhs){
		return new Interval(lhs.min + rhs.min, lhs.sec + rhs.sec);
	}

	public String toString(){
		if(sec < 10)
			return min + ":0" + sec;
		return min + ":" + sec;
	}

	public int hashCode(){
		return 1000 * (60 * min + sec);
	}

	public boolean equals(Object other){
		if(other instanceof Interval){
			Interval that = (Interval)other;
			return min == that.min && sec == that.sec;
		}
		return false;
	}

	public int compareTo(Interval that){
		return this.time() - that.time();
	}
}




