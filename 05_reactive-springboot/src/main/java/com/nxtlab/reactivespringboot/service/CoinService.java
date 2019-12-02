package com.nxtlab.reactivespringboot.service;

import com.nxtlab.reactivespringboot.model.Coins;
import com.nxtlab.reactivespringboot.SingleTicker;
import com.nxtlab.reactivespringboot.model.Tickers;

import reactor.core.publisher.Mono;

public interface CoinService {

	Mono<Coins> getCoins();
	Mono<SingleTicker> getTicker(String id);
	Mono<Tickers> getTickers();	
}
