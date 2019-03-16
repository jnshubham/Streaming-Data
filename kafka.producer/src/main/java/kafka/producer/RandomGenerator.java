package kafka.producer;

import java.time.LocalDate;
import java.util.Random;

public class RandomGenerator {
	
	public LocalDate getRandDate(long daysToSub) {
		Random random = new Random();
		int minDay = (int) LocalDate.now().minusDays(daysToSub).toEpochDay();
		int maxDay = (int) LocalDate.now().minusDays(-daysToSub).toEpochDay();
		long randomDay = minDay + random.nextInt(maxDay - minDay);
		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		return randomDate;
	}
	
	public int getRandInt(int min, int max) {
		Random r = new Random();
		return r.nextInt(max-min) + min;
	}
}
