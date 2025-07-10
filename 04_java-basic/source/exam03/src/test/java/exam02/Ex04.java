package exam02;

import board.entities.BoardData;
import board.mappers.BoardMapper;
import global.configs.DBConnection;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class Ex04 {
    private BoardMapper mapper;

    @BeforeEach
    void init() {
        SqlSession session = DBConnection.getInstance().getSession();;
        mapper = session.getMapper(BoardMapper.class);
    }

    @Test
    void test1() {
        BoardData item = new BoardData();
        item.setPoster("작성자3");
        item.setSubject("제목3");
        item.setContent("내용3");
        int affectedRows = mapper.register(item);
        System.out.println(item);
    }

    /**
     * 게시글 번호로 조회
     */
    @Test
    void test2() {
        BoardData item = mapper.get(1L).orElse(null);
        System.out.println(item);

        //List<BoardData> items = mapper.getList();
        //items.forEach(System.out::println);
    }

    @Test
    void test3() {
        BoardData item = new BoardData();
        item.setSeq(1L);
        item.setSubject("(수정)제목1");
        mapper.update(item);
    }

    @Test
    void test4() {
        BoardData params = new BoardData();
        //params.setPoster("작성자1");
        params.setSeq(2L);
        params.setSubject("%제목%");

        List<BoardData> items = mapper.getList(params);
        items.forEach(System.out::println);
    }

    @Test
    void test5() {
        List<BoardData> items = mapper.getList2(List.of(1L, 2L));
        items.forEach(System.out::println);
    }
}
