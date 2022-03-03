package com.nttdata.bootcoin.service;

import com.nttdata.bootcoin.entity.Bootcoin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBootcoinService {

    Flux<Bootcoin> getAll();

    Mono<Bootcoin> getBootcoinById(String id);

    Mono<Bootcoin> getBootcoinByPhoneNumber(String phone);

    Mono<Bootcoin> save(Bootcoin bootcoin);

    Mono<Bootcoin> update(Bootcoin bootcoin);

    void delete(String id);
}
