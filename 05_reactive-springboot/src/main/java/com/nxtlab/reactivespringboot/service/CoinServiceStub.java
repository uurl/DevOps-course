package com.nxtlab.reactivespringboot.service;

import com.nxtlab.reactivespringboot.model.Coins;
import com.nxtlab.reactivespringboot.model.SingleTicker;
import com.nxtlab.reactivespringboot.model.Tickers;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Profile("test")
public class CoinServiceStub implements CoinService {

    @Override
    public Mono<Coins> getCoins() {
        return Mono.just(Coins
                .builder()
                .success("true")
                .build());
    }

    @Override
    public Mono<SingleTicker> getTicker(String id) {
        return Mono.just(SingleTicker
                .builder()
                .success("true")
                .build());
    }

    @Override
    public Mono<Tickers> getTickers() {
        return Mono.just(Tickers
                .builder()
                .success("true")
                .build());
    }
}
