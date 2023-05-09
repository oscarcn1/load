package com.nuuptech.load.controller;

import java.text.DecimalFormat;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private List<byte[]> bigList = new ArrayList<>();

    @GetMapping("/consume-cpu")
    public String consumeCpu() {
        for(int i = 0; i < 1000000000; i++) {
            double j = Math.pow(i, 3);
        }
        return "CPU process completed";
    }

    @GetMapping("/consume-memory")
    public String consumeMemory() {
        byte[] bigObject = new byte[1024 * 1024 * 10]; // Crea un objeto grande de 10 MB
        bigList.add(bigObject); // Agrega el objeto a la lista
        long memoryUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double totalMemoryInMB = (double) memoryUsed / (1024 * 1024);
        return "10 MB object added to the list. Memory used: " + new DecimalFormat("#.##").format(totalMemoryInMB) + " Mb";
    }

    @GetMapping("/sleep-miliseconds")
    public String sleepMilieconds() throws InterruptedException {
        Thread.sleep(600);
        return "Responding after sleep";
    }

}
