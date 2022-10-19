enum RoomType {ECONOMY, BUSINESS, EXECUTIVE, DELUXE;}

class SwitchEnumTest{

	private static double getPayment(RoomType room, int stay){
		float rate = 0;
		switch(room){
			case ECONOMY:
				rate = 525;
				break;
			case BUSINESS:
				rate = 750;
				break;
			case EXECUTIVE:
				rate = 950;
				break;
			default:
				rate = 1225;
		}
		return 1.05 * rate * stay;
	}

	public static void main(String[] args){
		int days = args.length > 0 ? Integer.parseInt(args[0]) : 3;
		System.out.printf("Total payment for ECONOMY type room is %.2f%n", getPayment(RoomType.ECONOMY, days));
		System.out.printf("Total payment for BUSINESS type room is %.2f%n", getPayment(RoomType.BUSINESS, days));
		System.out.printf("Total payment for EXECUTIVE type room is %.2f%n", getPayment(RoomType.EXECUTIVE, days));
		System.out.printf("Total payment for DELUXE type room is %.2f%n", getPayment(RoomType.DELUXE, days));
		//System.out.printf("Total payment for CHEAP type room is %.2f%n", getPayment(RoomType.CHEAP, days));
	}
}



