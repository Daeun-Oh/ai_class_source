package org.koreait.board.mappers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.koreait.board.entities.Board;
import org.koreait.global.configs.DBConnection;

public class BoardMapperTest {

    private BoardMapper mapper;

    @BeforeEach
    void init() {
        mapper = DBConnection.getInstance().getSession().getMapper(BoardMapper.class);
    }

    /**
     * 추가 테스트
     */
    @Test
    void test1() {
        Board board = new Board();
        board.setTitle("제목1");
        board.setContent("내용1");
        board.setWriterId(4);


        int affectedRows = mapper.register(board);
        System.out.println(affectedRows);
    }
}
