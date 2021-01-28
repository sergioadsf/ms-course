package br.com.conectasol.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.conectasol.hrworker.entities.Worker;
import br.com.conectasol.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	private Environment environment;

	private WorkerRepository repository;

	public WorkerResource(Environment environment, WorkerRepository repository) {
		this.environment = environment;
		this.repository = repository;
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		return ResponseEntity.ok(this.repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable("id") Long id) {
		
		logger.info("PORT = "+environment.getProperty("local.server.port"));
		
		Optional<Worker> optional = this.repository.findById(id);
		return ResponseEntity.ok(optional.get());
	}
	
	
}
