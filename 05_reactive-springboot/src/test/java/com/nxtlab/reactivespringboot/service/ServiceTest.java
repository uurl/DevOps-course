package com.nxtlab.reactivespringboot.service;

import com.nxtlab.reactivespringboot.model.Coins;
import com.nxtlab.reactivespringboot.model.SingleTicker;
import com.nxtlab.reactivespringboot.model.Tickers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.cassandra.CassandraDataAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration(exclude={
        CassandraDataAutoConfiguration.class})
public class ServiceTest {

    @Autowired
    private CoinService coinService;

    @Before
    public void setup() {
    }

    @Test
    public void testGetCoins() {
        Mono<Coins> coinsMono = coinService.getCoins();
        assertNotNull(coinsMono);

        Coins coinList = coinsMono.block();
        assertNotNull(coinList);
        assertEquals(coinList.getSuccess(), "true");
    }

    @Test
    public void testGetTicker() {
        Mono<SingleTicker> tickerMono = coinService.getTicker("123");
        assertNotNull(tickerMono);

        SingleTicker ticker = tickerMono.block();
        assertNotNull(ticker);
        assertEquals(ticker.getSuccess(), "true");
    }

    @Test
    public void testGetTickers() {
        Mono<Tickers> tickersMono = coinService.getTickers();
        assertNotNull(tickersMono);

        Tickers tickers = tickersMono.block();
        assertNotNull(tickers);
        assertEquals(tickers.getSuccess(), "true");
    }
}
