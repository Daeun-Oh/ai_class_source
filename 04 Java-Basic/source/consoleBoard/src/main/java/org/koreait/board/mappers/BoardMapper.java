package org.koreait.board.mappers;

import org.koreait.board.entities.Board;
import org.koreait.global.paging.SearchForm;

import java.util.List;
import java.util.Optional;

public interface BoardMapper {
    int register(Board board);
    int update(Board board);
    int delete(long id);

    Optional<Board> get(long id);
    List<Board> getList(SearchForm search);
}
