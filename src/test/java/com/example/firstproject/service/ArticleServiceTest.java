package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {

    @Autowired ArticleService articleService;
    @Test
    void index() {
        // 예상 시나리오
        Article a = new Article(1L, "가가가가", "1234");
        Article b = new Article(2L, "나나나나", "2345");
        Article c = new Article(3L, "다다다다", "3456");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c));


        // 실제 결과
        List<Article> articles = articleService.index();

        // 비교
        assertEquals(expected.toString(), articles.toString());
    }

    @Test
    void showSuccess() {
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1234");

        // 실제 결과
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected.toString(), article.toString());

    }
    @Test
    void showFail() {
        Long id = 4L;
        Article expected = null;

        // 실제 결과
        Article article = articleService.show(id);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void createSuccess() {
        // 예상
        ArticleForm dto = new ArticleForm(null, "가가가가1", "12345");
        Article expected = new Article(4L, "가가가가1", "12345");

        // 실제 결과
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void createFail() {
        // 예상
        ArticleForm dto = new ArticleForm(1L, "가가가가1", "12345");
        Article expected = null;

        // 실제 결과
        Article article = articleService.create(dto);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void updateSuccess() {
        // 예상
        Long id = 1L;
        ArticleForm dto = new ArticleForm(null, "가가가가1", "12345");
        Article expected = new Article(1L, "가가가가1", "12345");

        // 실제 결과
        Article article = articleService.update(dto, id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void updateFail() {
        // 예상
        Long id = 4L;
        ArticleForm dto = new ArticleForm(null, "가가가가1", "12345");
        Article expected = null;

        // 실제 결과
        Article article = articleService.update(dto, id);

        // 비교
        assertEquals(expected, article);
    }

    @Test
    @Transactional
    void deleteSuccess() {
        // 예상
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1234");

        // 실제 결과
        Article article = articleService.delete(id);

        // 비교
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void deleteFail() {
        // 예상
        Long id = 4L;
        Article expected = null;

        // 실제 결과
        Article article = articleService.delete(id);

        // 비교
        assertEquals(expected, article);
    }
}