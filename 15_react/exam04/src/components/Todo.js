import { useState, useEffect, useRef } from "react";

// 편법으로 0 ~ 9 배열 만들기
// i => ({}) : 여기서 소괄호로 감싸지 않으면 함수 블록으로 인식해 undefined 10개가 생성됨.
function initialItems() {
  console.log("initialItems() 호출!")
  return [...(new Array(10)).keys()].map(i  => ({id: i + 1, title: `할일${i}`}))
}

const Todo = () => {
  // const [items, setItems] = useState([
  //   { id: 1, title: '할일1' },
  //   { id: 2, title: '할일2' },
  //   { id: 3, title: '할일3' },
  // ]);

  const [items, setItems] = useState(initialItems); // 함수 객체 자체를 넣어 줘야, 딱 한 번만 호출 (initialItems() -> initialItems)

  const [title, setTitle] = useState(''); // useState(''): 빈 상태면 undefined

  const [cnt, setCnt] = useState(0);

  useEffect(() => {
    console.log('컴포넌트가 마운트되었을 때 한 번 실행');

    return () => {
      console.log('뒷정리 함수 - 컴포넌트가 언마운트 되었을 때 호출');
    };
  }, []); // [] - 실행 기준, 비어 있으면 마운트 되었을 때 1번 실행

  useEffect(() => {
    console.log('숫자가 변경되었습니다.', cnt);

    return () => {
      console.log('뒷정리 함수 - 앞선 작업의 정리 부분을 정의');
    };
  }, [cnt]);

  const onClick = () => {
    setItems((prev) => prev.concat({ id: prev.length + 1, title }));
  };

  const onRefresh = () => {
    setCnt(cnt + 1);
  };

  return (
    <>
      <input
        type="text"
        onChange={(e) => setTitle(e.target.value)}
        value={title}
      />
      <button type="button" onClick={onClick}>
        등록
      </button>

      <ul>
        {items.map(({ id, title }) => (
          <li key={id}>{title}</li>
        ))}
      </ul>

      <button type="button" onClick={onRefresh}>
        화면 갱신
      </button>
    </>
  );
};

export default Todo;