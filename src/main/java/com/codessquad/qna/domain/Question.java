package com.codessquad.qna.domain;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 20)
    private String writer;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false)
    private String contents;


    public long getId() {
        return id;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getWriter() {
        return writer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    @Override
    public String toString() {
        return "Question{" +
                "writer='" + writer + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}
