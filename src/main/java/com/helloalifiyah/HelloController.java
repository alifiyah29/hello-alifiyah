package com.helloalifiyah;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        Runnable task = () -> {
            try {
                Thread.sleep(23300); // 23.3 seconds
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
    
        Thread thread = new Thread(task);
        thread.start();
    
        try {
            thread.join(); // Waits for the thread to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    
        return "Hello Alifiyah";
    }
    
}
