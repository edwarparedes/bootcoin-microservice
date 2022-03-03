package com.nttdata.bootcoin.controller;

import com.nttdata.bootcoin.entity.Bootcoin;
import com.nttdata.bootcoin.service.IBootcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bootcoin")
public class BootcoinController {

    @Autowired
    IBootcoinService service;

    @GetMapping
    public Flux<Bootcoin> getBootcoins(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Bootcoin>> getBootcoinById(@PathVariable("id") String id){
        return service.getBootcoinById(id)
                .map(savedMessage -> ResponseEntity.ok(savedMessage))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/phone/{phone}")
    public Mono<ResponseEntity<Bootcoin>> findByPhoneNumberId(@PathVariable("phone") String phone){
        return service.getBootcoinByPhoneNumber(phone)
                .map(savedMessage -> ResponseEntity.ok(savedMessage))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    Mono<Bootcoin> postBootcoin(@RequestBody Bootcoin bootcoin){
        return service.save(bootcoin);
    }

    @PutMapping
    Mono<Bootcoin> updBootcoin(@RequestBody Bootcoin bootcoin){
        return service.update(bootcoin);
    }

    @DeleteMapping("/{id}")
    void dltBootcoin(@PathVariable("id") String id){
        service.delete(id);
    }

}
