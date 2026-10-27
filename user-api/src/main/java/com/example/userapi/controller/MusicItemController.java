package com.example.userapi.controller;

import com.example.userapi.dto.MusicIDCustomerName;
import com.example.userapi.dto.MusicItemsRequest;
import com.example.userapi.entity.MusicItems;
import com.example.userapi.service.MusicItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/music")
@RequiredArgsConstructor

public class MusicItemController {

    private final MusicItemService musicItemService;

    @PostMapping
    public ResponseEntity<MusicItems> createMusicItem(@Valid @RequestBody MusicItemsRequest musicItemRequestBody) {
        log.info("this is info");
        MusicItems musicItems = musicItemService.createMusicItem(musicItemRequestBody);

        return ResponseEntity.status(HttpStatus.CREATED).body(musicItems);

    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<MusicItems>> searchMusicItemsByCustomerId(@PathVariable Long customerId) {
        List<MusicItems> musicItems = musicItemService.searchMusicItemsByCustomerId(customerId);
        return ResponseEntity.ok(musicItems);
    }

  @GetMapping("/{customerId}/name")
      public ResponseEntity<String> getCustomerName(@PathVariable Long customerId)   {
          String customerName = musicItemService.getCustomerName(customerId);
                return ResponseEntity.ok(customerName);
  }

    @GetMapping("/{id}/summary")
    public ResponseEntity<MusicIDCustomerName> musicIDCustomerName(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                musicItemService.musicIDCustomerName(id)
        );
    }
}
