package com.iioannou.taap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.iioannou.taap.domain.CallD;
import com.iioannou.taap.domain.CallerD;
import com.iioannou.taap.entity.Caller;
import com.iioannou.taap.repository.CallerRepository;
import com.iioannou.taap.util.RecordMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

/**
 * @author ioannou
 */
@Component
public class Initializer implements CommandLineRunner {

    @Value("classpath:data/callers_mock_data.json")
    Resource callersFile;

    @Value("classpath:data/calls_mock_data.json")
    Resource callsFile;

    private final CallerRepository repository;

    public Initializer(CallerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (repository.findAllCallers().isEmpty()) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            List<CallerD> callerDS = mapper.readValue(callersFile.getFile(), new TypeReference<List<CallerD>>() {
            });

            List<CallD> callDS = mapper.readValue(callsFile.getFile(), new TypeReference<List<CallD>>() {
            });

            for (CallerD c : callerDS) {
                Caller entity = RecordMapper.convertToEnt(c);
                callDS.stream().filter(call -> call.getCallerId().equals(c.getId()))
                      .map(RecordMapper::convertToEnt)
                      .forEach(entity::addCallContact);
                repository.save(entity);

            }
        }

        repository.findAll().forEach(System.out::println);
    }
}
