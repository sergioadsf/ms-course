package br.com.conectasol.payroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.conectasol.payroll.entities.Worker;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {

	@GetMapping("/{id}")
	ResponseEntity<Worker> findById(@PathVariable("id") Long id);

}
