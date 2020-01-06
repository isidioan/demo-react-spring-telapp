package com.iioannou.taap.service;

import com.iioannou.taap.domain.CallerD;
import com.iioannou.taap.repository.CallerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author ioannou
 */
@RestController
@RequestMapping("/api")
public class CallerService {

    private final CallerRepository repository;

    public CallerService(CallerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/callers/all")
    public Collection<CallerD> findAllCallers() {
        return Collections.unmodifiableCollection(repository.findAllCallers());
    }

    @GetMapping("/caller/{filterAttribute}")
    public Collection<CallerD> findByAttribute(@PathVariable String filterAttribute) {
        return Collections.unmodifiableCollection(repository.findFilteredByFirstnameOrLastnameOrEmail(filterAttribute));
    }

    @GetMapping("/caller/{callerId}/contacts")
    public Collection<CallerD> findContactedUsers(@PathVariable Long callerId) {
        List<CallerD> contacts = new ArrayList<>();
        repository.findContactedUsersOfCaller(callerId).stream().filter(id -> id != null).forEach(record -> {
            CallerD callerD = repository.findCallerById(record);
            contacts.add(callerD);
        });
        return Collections.unmodifiableCollection(contacts);
    }


}
