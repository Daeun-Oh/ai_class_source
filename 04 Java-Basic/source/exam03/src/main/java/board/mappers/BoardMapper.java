package board.mappers;

import board.entities.BoardData;

import java.util.List;
import java.util.Optional;

public interface BoardMapper {
    int register(BoardData data);
    int update(BoardData data);
    Optional<BoardData> get(long seq);
    List<BoardData> getList(BoardData data);
    List<BoardData> getList2(List<Long> seq);
}
