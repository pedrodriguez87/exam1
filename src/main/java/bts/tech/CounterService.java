package bts.tech;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CounterService {

    private int value;

    public int getValue() {
        return value;
    }

    public CounterService() {
        this.value = 0;
    }

    public int createCounter() {
        return this.value;
    }

    public int incrementCounter() {
        return this.value++;
    }



}
