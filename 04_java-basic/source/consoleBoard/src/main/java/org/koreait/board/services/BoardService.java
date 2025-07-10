package org.koreait.board.services;

import org.koreait.board.mappers.BoardMapper;
import org.koreait.global.configs.DBConnection;
import org.koreait.global.services.Bean;
import org.koreait.global.services.Configuration;

@Configuration
public class BoardService {
    @Bean
    public BoardMapper boardMapper() {
        return DBConnection.getInstance().getSession().getMapper(BoardMapper.class);
    }

    @Bean
    public BoardInfoService infoService() {
        return new BoardInfoService(boardMapper());
    }


    public void common() {

    }
}
