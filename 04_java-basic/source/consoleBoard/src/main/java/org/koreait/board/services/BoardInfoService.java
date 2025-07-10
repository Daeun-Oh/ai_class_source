package org.koreait.board.services;

import org.koreait.board.entities.Board;
import org.koreait.board.exception.BoardNotFoundException;
import org.koreait.board.mappers.BoardMapper;
import org.koreait.global.paging.SearchForm;

import java.util.List;

public class BoardInfoService {
    private final BoardMapper mapper;

    public BoardInfoService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public Board get(long id) {
        return mapper.get(id).orElseThrow(BoardNotFoundException::new);
    }

    public List<Board> getList(SearchForm search) {
        int page = Math.max(search.getPage(), 1);   // 요청한 페이지가 1보다 작으면 1로 보정
        int limit = search.getLimit();              // limit: 한 페이지에 보여줄 데이터 수
        limit = limit < 1 ? 10 : limit;             // limit가 1보다 작으면 10으로 설정
        int offset = (page - 1) * limit;            // DB에서 데이터를 가져올 때 건너뛸 데이터 수 설정 (페이징 처리 때문에)

        search.setPage(page);
        search.setLimit(limit);
        search.setOffset(offset);

        return mapper.getList(search);
    }
}
