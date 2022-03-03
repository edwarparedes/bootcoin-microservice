package com.nttdata.bootcoin.repository;

import com.nttdata.bootcoin.entity.Bootcoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface IBootcoinRepository extends ReactiveMongoRepository<Bootcoin, String> {
    Mono<Bootcoin> findByPhoneNumber(String phone);
}
