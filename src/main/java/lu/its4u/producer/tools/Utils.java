package lu.its4u.producer.tools;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
	static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public static Date randomDate() {
		long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
		long maxDay = LocalDate.of(2023, 12, 31).toEpochDay();
		long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
		LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
		ZoneId defaultZoneId = ZoneId.systemDefault();
		return Date.from(randomDate.atStartOfDay(defaultZoneId).toInstant());
	}

	public static String generateRandomWord(int wordLength) {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		int length = wordLength;
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		return sb.toString();

	}
}
