package lu.its4u.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lu.its4u.kafka.dto.Voiture;
import lu.its4u.producer.kafka.KafkaProducer;
import lu.its4u.producer.service.VoitureService;

@RestController
public class MainController {

	@Autowired
	private KafkaProducer kafkaProducer;

	@Autowired
	private VoitureService voitureService;

	@GetMapping(value = { "/send" }, produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> main(final HttpServletRequest request, @RequestParam(name = "count", required = false, defaultValue = "1") int count) {
		try {
			for (Voiture voiture : voitureService.createRandom(count)) {
				kafkaProducer.send(voiture);
			}

			return new ResponseEntity<String>("Sent " + count + " Voitures(s) correcly", HttpStatus.OK);
		} catch (

		Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
