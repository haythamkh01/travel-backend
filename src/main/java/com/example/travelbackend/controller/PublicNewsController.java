package com.example.travelbackend.controller;

import com.example.travelbackend.dto.NewsResponse;
import com.example.travelbackend.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class PublicNewsController {

    private final NewsService newsService;

    // List (paged) — newest first
    @GetMapping("/all")
    public Page<NewsResponse> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        var pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        return newsService.findAll(pageable);
    }

    // Single item by id
    @GetMapping("/{id}")
    public NewsResponse get(@PathVariable Long id) {
        return newsService.findById(id);
    }
}
