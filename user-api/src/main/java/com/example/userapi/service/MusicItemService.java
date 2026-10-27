package com.example.userapi.service;

import com.example.userapi.dto.MusicIDCustomerName;
import com.example.userapi.entity.MusicItems;
import com.example.userapi.dto.MusicItemsRequest;
import com.example.userapi.Mapper.MusicMapper;
import com.example.userapi.exception.CustomerException;
import com.example.userapi.repository.CustomerRepository;
import com.example.userapi.repository.MusicItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MusicItemService {
    private final MusicItemRepository musicItemRepository;
    private final CustomerRepository customerRepository;
    private final MusicMapper musicMapper;

    public MusicItems createMusicItem(MusicItemsRequest request) {
        var customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new CustomerException(
                        "Customer not found: " + request.getCustomerId(),
                        HttpStatus.NOT_FOUND));
        MusicItems musicItems = musicMapper.toEntity(request);
        return musicItemRepository.save(musicItems);
    }

  public List<MusicItems> searchMusicItemsByCustomerId(Long customerId) {
      var customer = customerRepository.findById(customerId)
              .orElseThrow(() -> new CustomerException(
                      "Customer not found: " + customerId,
                      HttpStatus.NOT_FOUND));
      return customer.getInstrument();
  }

    public String getCustomerName(Long customerId) {
        var customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerException(
                        "Customer not found: " + customerId,
                        HttpStatus.NOT_FOUND));
        log.info("this is customer-" +customer);
        return customer.getName();
    }


    public MusicIDCustomerName musicIDCustomerName(Long customerID) {
    return musicItemRepository.findSummaryById(customerID).orElseThrow(() ->
                new IllegalArgumentException("Order not found")
        );
    }
}
