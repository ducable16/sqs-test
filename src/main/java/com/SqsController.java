package com;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SqsController {

    private final SqsSender sender;
    private final SqsReceiver receiver;

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestParam String message) {
        sender.sendMessage(message);
        return ResponseEntity.ok("Message sent!");
    }

    @GetMapping("/receive")
    public ResponseEntity<String> receive() {
        receiver.receiveMessages();
        return ResponseEntity.ok("Messages received!");
    }
}

