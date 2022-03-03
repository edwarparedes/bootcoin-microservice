package com.nttdata.bootcoin.service;

import com.nttdata.bootcoin.entity.Bootcoin;
import com.nttdata.bootcoin.repository.IBootcoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BootcoinServiceImpl implements IBootcoinService {

    @Autowired
    IBootcoinRepository repository;



    @Override
    public Flux<Bootcoin> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Bootcoin> getBootcoinById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Bootcoin> getBootcoinByPhoneNumber(String phone) {
        return repository.findByPhoneNumber(phone);
    }

    @Override
    public Mono<Bootcoin> save(Bootcoin bootcoin) {
        return repository.save(bootcoin);
    }

    @Override
    public Mono<Bootcoin> update(Bootcoin bootcoin) {
        return repository.save(bootcoin);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id).subscribe();
    }
}
