package lu.its4u.producer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lu.its4u.kafka.dto.Voiture;
import lu.its4u.producer.tools.Utils;

@Service
public class VoitureService {

	public List<Voiture> createRandom(int count) {
		List<Voiture> list = new ArrayList<Voiture>();
		for (int i = 0; i < count; i++) {
			list.add(new Voiture(System.currentTimeMillis(), Utils.generateRandomWord(10), Utils.generateRandomWord(10), Utils.randomDate().getTime()));
		}
		return list;

	}
}
