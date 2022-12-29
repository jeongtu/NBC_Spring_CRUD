package com.sparta.boardjwt1.entity;

import com.sparta.boardjwt1.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Board extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    public Board(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.author = boardRequestDto.getAuthor();
        this.content = boardRequestDto.getContent();
        this.password = boardRequestDto.getPassword();
    }

    public void updateBoard(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.author = boardRequestDto.getAuthor();
        this.content = boardRequestDto.getContent();
        this.password = boardRequestDto.getPassword();
    }

    public Boolean checkPassword(BoardRequestDto boardRequestDto) {
        return getPassword().equals(boardRequestDto.getPassword());
    }
}
