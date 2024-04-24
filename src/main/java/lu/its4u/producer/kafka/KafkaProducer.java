package lu.its4u.producer.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lu.its4u.kafka.dto.Voiture;

@Component

public class KafkaProducer {
	@Value("${kafka.topic.name}")
	private String topic;

	private final KafkaTemplate<String, Voiture> kafkaTemplate;

	@Autowired
	public KafkaProducer(KafkaTemplate<String, Voiture> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(Voiture voiture) {
		this.kafkaTemplate.send(this.topic, voiture);
	}

}
