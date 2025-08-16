package com.example.travelbackend.dto;

import com.example.travelbackend.entity.News;
import java.time.Instant;

public record NewsResponse(
        Long id,
        String title,
        String content,
        String imageUrl,
        Instant createdAt
) {
    public static NewsResponse from(News news) {
        return new NewsResponse(
                news.getId(),
                news.getTitle(),
                news.getContent(),
                news.getImageUrl(),
                news.getCreatedAt()
        );
    }
}
