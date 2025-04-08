const todo = {
    items: [], // 스케줄 목록
    /**
     * 스케줄 페이지 접근 시 초기에 할 작업
     */
    init() {
        // 스케줄 목록 출력
        this.render();
    },
    /**
     * 스케줄 등록 처리
     * 
     * @param {*} item 
     */
    add(item) {
        
    },
    /**
     * 스케줄 삭제 처리
     * 
     * @param {*} seq : 스케줄 등록 번호 
     */
    remove(seq) {

    },
    /**
     * 스케줄 목록 출력
     */
    render() {

    }
}

window.addEventListener("DOMContentLoaded", function() {
    todo.init();    // 스케줄 목록 초기화
    const quill = new Quill('#todo-content', {
        theme: 'bubble', 
    });

    /**
     * 스케줄 등록 처리
     * 
     * 1. 유효성 검사 - 필수 항목 (날짜, 제목, 내용)
     *               - 검증 실패 시: Error 메시지 출력, 실행 중단
     * 2. 스케줄을 등록하는 처리
     * 3. 등록이 완료되면 입력한 내용 초기화
     */
    frmRegist.addEventListener("submit", function(e) {
        e.preventDefault(); // 기본 동작 차단

        // 1. 유효성 검사 S

        // 에러 메시지 초기화 (기존의 메시지가 남아 있지 않게)
        const errorEls = frmRegist.querySelectorAll(".alert");
        errorEls.forEach(el => el.parentElement.removeChild(el));
        // ---

        // 필수 항목 검사
        const requiredFields = {
            date: '날짜를 입력하세요.',
            title: '제목을 입력하세요',
        }

        const errors = [], item = { seq: Date.now() };  // 현재 시간 기준의 난수

        for (const [field, message] of Object.entries(requiredFields)) {
            // 모두 '문자'가 맞는가 ? 맞으면 문자열(value)에서 공백을 제거하라 : 아니면 문자열(value)을 ''로 초기화하라
            // --> 이 프로그램에선 무조건 문자열일 수밖에 없긴 함. 미래를 위해 작성해 보는 것.
            const value = typeof frmRegist[field].value === 'string' ? frmRegist[field].value.trim() : '';
            if (!value) {   // 문자열이 비어 있으면 에러 메시지 추가
                errors.push(message);
            } else {
                item[field] = value;
            }
        }
        
        if (!quill.getText().trim()) {
            errors.push('내용을 입력하세요.');
        } else {
            item.content = quill.root.innerHTML.trim();
        }
        // ---

        // 검증이 실패한 경우
        if (errors.length > 0) {
            errors.reverse();   // 배열의 내용 거꾸로 뒤집기
            errors.forEach(m => {
                const errorEl = document.createElement("div");
                errorEl.className = 'alert alert-danger';
                errorEl.setAttribute("role", "alert");
                errorEl.append(m);
                frmRegist.prepend(errorEl);
            });
            return;
        }
        // ---
        // 유효성 검사 E

        // 2. 스케줄 등록 처리 S
        //todo.add(item);
        // 스케줄 등록 처리 E

        // 3. 입력 내용 초기화 S
        frmRegist.date.value = '';
        frmRegist.title.value = '';
        quill.root.innerHTML = '';
        // 입력 내용 초기화 E
    });
});