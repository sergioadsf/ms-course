package br.com.conectasol.payroll.services;

import org.springframework.stereotype.Service;

import br.com.conectasol.payroll.entities.Payment;
import br.com.conectasol.payroll.entities.Worker;
import br.com.conectasol.payroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	private WorkerFeignClient workerFeignClient;

	public PaymentService(WorkerFeignClient workerFeignClient) {
		super();
		this.workerFeignClient = workerFeignClient;
	}

	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
