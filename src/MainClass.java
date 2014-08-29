import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MainClass {

	/**
	 * @param args
	 */

	public static final HashMap<WeekDay, String> map2 = new HashMap<WeekDay, String>();
	
	

	public enum Weekend {
		SATURDAY(20), SUNDAY(30);
		public int id;

		private Weekend(int id) {
			this.id = id;
		}

		public int getId() {
			return id;
		}
	}

	public static void main(String[] args) {

		switch (WeekDay.MONDAY) {
		case MONDAY:
			System.out.println("You've chosen Monday: " + WeekDay.MONDAY);
			break;

		default:
			break;
		}

		
		// although enums can be compared by '==' operator, it's not recommended as 
		// comparing Objects should always be done by .equals()
		if (Weekend.SUNDAY == Weekend.valueOf("SUNDAY")) {
			System.out.println("Compared success");
		}
		
		
		// the use of .valueOf()
		switch (Weekend.valueOf("SUNDAY")) {
		case SATURDAY:
			System.out
					.println("You've chosen Saturday: " + Weekend.SATURDAY.id);
			break;

		case SUNDAY:

			System.out.println(Weekend.SUNDAY);
			break;

		default:
			break;
		}

		 useValues();

		useEnumMap();
		
		
		map2.put(WeekDay.MONDAY, "gOOD");
	}

	private static void useValues() {
		// demonstrate the use of .values()
		for (WeekDay day: WeekDay.values()) {
		 System.out.println("from values(): " + day + day.ordinal());
		 }
	}

	private static void useEnumMap() {
		EnumMap<WeekDay, String> map1 = new EnumMap<WeekDay, String>(
				WeekDay.class);
		map1.put(WeekDay.FRIDAY, "Happy friday!");
		map1.put(WeekDay.TUESDAY, "You get tired of work on Tuesday.");
		map1.put(WeekDay.WEDNESDAY, "Ok, hump day");
		
		
		Iterator<WeekDay>  enumKeySet = map1.keySet().iterator();
		while (enumKeySet.hasNext()) {
			WeekDay day = enumKeySet.next();
			
			System.out.println("Key from EnumMap: " + day + ". " + map1.get(day));
		}
	}

}
