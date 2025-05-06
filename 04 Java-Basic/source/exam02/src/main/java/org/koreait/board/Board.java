package org.koreait.board;

import lombok.*;

public class Board {
    private long seq;       // 게시글 번호
    private String poster;  // 작성자
    private String subject; // 글 제목
    private String content; // 글 내용

    private Board() {}

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "Board{" +
                "seq=" + seq +
                ", poster='" + poster + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public static class Builder {
        private Board instance = new Board();

        public Builder seq(long seq) {
            instance.seq = seq;
            return this;
        }

        public Builder poster(String poster) {
            instance.poster = poster;
            return this;
        }

        public Builder subject(String subject) {
            instance.subject = subject;
            return this;
        }

        public Builder content(String content) {
            instance.content = content;
            return this;
        }

        public Board build() {
            return instance;
        }
    }
}
