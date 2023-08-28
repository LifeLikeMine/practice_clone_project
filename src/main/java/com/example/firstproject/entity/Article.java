package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자
@ToString
@Getter
@Entity // 해당 객체로 테이블을 만든다.
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db가 id를 자동 생성 어노테이션
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article){
        if(article.title != null)
            this.title = article.title;
        if(article.content != null)
            this.content = article.content;
    }

}
