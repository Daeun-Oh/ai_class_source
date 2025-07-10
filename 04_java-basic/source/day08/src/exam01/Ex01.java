package exam01;

@MyAnno(value="안녕1", min=20, max={30, 50, 60})
public class Ex01 {

    @MyAnno(value="안녕2")
    public Ex01() { // 생성자

    }

    @MyAnno("안녕3")
    void method() {

    }
}