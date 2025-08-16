package com.example.travelbackend.service;

import com.example.travelbackend.dto.NewsResponse;
import com.example.travelbackend.entity.News;
import com.example.travelbackend.files.ImageStorageService;
import com.example.travelbackend.repository.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;        // ✅ Spring Data Page
import org.springframework.data.domain.Pageable;   // ✅ Spring Data Pageable
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class NewsService {

    private final NewsRepository repo;
    private final ImageStorageService storage;

    @Transactional
    public NewsResponse create(String title, String content, MultipartFile image) throws Exception {
        News n = new News();
        n.setTitle(title.trim());
        n.setContent(content);
        if (image != null && !image.isEmpty()) {
            n.setImageUrl(storage.saveNewsImage(image));
        }
        return NewsResponse.from(repo.save(n));
    }

    @Transactional(readOnly = true)
    public Page<NewsResponse> findAll(Pageable pageable) {
        return repo.findAll(pageable).map(NewsResponse::from);
    }

    @Transactional(readOnly = true)
    public NewsResponse findById(Long id) {
        News n = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("News not found"));
        return NewsResponse.from(n);
    }
}
