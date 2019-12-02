package com.nxtlab.reactivespringboot.controller;

import com.nxtlab.reactivespringboot.model.Book;
import com.nxtlab.reactivespringboot.model.CommonResponse;
import com.nxtlab.reactivespringboot.model.SingleTicker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BitMxController {

	Flux<Book> getBooks();
	Mono<SingleTicker> getBook(String id);
	Mono<CommonResponse> getBookStatus(String id);
}
