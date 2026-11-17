package com.klu.contractdemo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionController {

    private final AdditionService additionService;

    public AdditionController(AdditionService additionService) {
        this.additionService = additionService;
    }

    @GetMapping(value = "/ms1/add",
            produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> add(
            @RequestParam int a,
            @RequestParam int b) {

        int sum = additionService.add(a, b);

        String result = "MS 1.1 - Addition = " + sum;

        return ResponseEntity.ok()
                .contentType(new MediaType(
                        "text", "plain",
                        java.nio.charset.StandardCharsets.UTF_8))
                .body(result);
    }
}
