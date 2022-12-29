package com.sparta.boardjwt1.controller;

import com.sparta.boardjwt1.dto.BoardRequestDto;
import com.sparta.boardjwt1.dto.BoardResponseDto;
import com.sparta.boardjwt1.dto.DtoBase;
import com.sparta.boardjwt1.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping()
    public BoardResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto) {
        return boardService.createBoard(boardRequestDto);
    }

    @GetMapping
    public List<BoardResponseDto> getBoard() {
        return boardService.getBoards();
    }

    @GetMapping("/{id}")
    public BoardResponseDto getBoardOne(@PathVariable Long id) {
        return boardService.getBoardOne(id);
    }

    @PutMapping("/{id}")
    public DtoBase updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {
        return boardService.updateBoard(id,boardRequestDto);
    }

    @DeleteMapping("/{id}")
    public DtoBase deleteBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto) {
        return boardService.deleteBoard(id,boardRequestDto);
    }
}
