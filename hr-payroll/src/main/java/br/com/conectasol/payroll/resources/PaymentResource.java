package br.com.conectasol.payroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.conectasol.payroll.entities.Payment;
import br.com.conectasol.payroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

	private PaymentService service;

	public PaymentResource(PaymentService service) {
		this.service = service;
	}

	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable("workerId") long workerId, @PathVariable("days") int days) {
		return ResponseEntity.ok(service.getPayment(workerId, days));
	}
}
