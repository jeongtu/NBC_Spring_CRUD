package com.sparta.board.service;


import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.dto.DtoBase;
import com.sparta.board.dto.ResultDto;
import com.sparta.board.entity.Board;
import com.sparta.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto) {
        Board saveBoard = new Board(boardRequestDto);
        boardRepository.save(saveBoard);
        return new BoardResponseDto(saveBoard);
    }

    @Transactional
    public List<BoardResponseDto> getBoards() {
        List<Board> boards = boardRepository.findAllByOrderByModifiedAtDesc();
        List<BoardResponseDto> lists = new ArrayList<>();

        for(Board board : boards) {
            lists.add(new BoardResponseDto(board));
        }
        return lists;
    }

    @Transactional
    public BoardResponseDto getBoardOne(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않음")
        );
        return new BoardResponseDto(board);
    }

    @Transactional
    public DtoBase updateBoard(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않음")
        );
        if(board.checkPassword(boardRequestDto)) {
            board.updateBoard(boardRequestDto);
            return new BoardResponseDto(board);
        } else {
            return new ResultDto(119,"패스워드가 일치하지 않음");
        }
    }

    @Transactional
    public DtoBase deleteBoard(Long id, BoardRequestDto boardRequestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않음")
        );
        if(board.checkPassword(boardRequestDto)) {
            boardRepository.deleteById(id);
            return new ResultDto(0,"삭제 성공");
        } else {
            return new ResultDto(119,"비밀번호가 일치하지 않음");
        }
    }
}
