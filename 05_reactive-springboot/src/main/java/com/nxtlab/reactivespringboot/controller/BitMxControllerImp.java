package com.nxtlab.reactivespringboot.controller;

import com.nxtlab.reactivespringboot.exception.BookNotFoundException;
import com.nxtlab.reactivespringboot.model.CommonResponse;
import com.nxtlab.reactivespringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nxtlab.reactivespringboot.model.Book;
import com.nxtlab.reactivespringboot.model.SingleTicker;
import com.nxtlab.reactivespringboot.service.CoinService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Profile("prod")
@RestController
@RequestMapping("bitmx/api")
public class BitMxControllerImp implements BitMxController {

	@Autowired
	private CoinService service;

	@Autowired
	private BookRepository repository;

	@Override
	@GetMapping("/book")
	public Flux<Book> getBooks() {
		return repository.findAll()
				.onErrorMap(error -> {
						throw new BookNotFoundException("Books not found", error);
				}).log();
	}

	@Override
	@GetMapping("/book/{id}")
	public Mono<SingleTicker> getBook(@PathVariable String id) {
		return service.getTicker(id)
				.onErrorMap(error -> {
					throw new BookNotFoundException("Book with ID: " + id + ", not found", error);
				}).log();
	}

	@Override
	@GetMapping("/book/{id}/status")
	public Mono<CommonResponse> getBookStatus(@PathVariable String id) {

		return service.getTicker(id)
			.flatMap(ticker -> {

				CommonResponse commonResponse = CommonResponse
						.builder()
						.build();

				commonResponse.setSuccess(true);
				if(ticker.getPayload().getAsk() > ticker.getPayload().getLast()) {
					commonResponse.setMessage("Recommend to sell");
				} else if(ticker.getPayload().getLast() > ticker.getPayload().getBid()) {
					commonResponse.setMessage("Recommend to buy");
				} else {
					commonResponse.setMessage("Recommend to hold");
				}

				return Mono.just(commonResponse);
			}).onErrorMap(error -> {
				throw new BookNotFoundException("Book with ID: " + id + ", not found", error);
			}).log();
	}
}
