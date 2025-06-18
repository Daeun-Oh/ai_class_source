import { useState } from "react";

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

  const [items, setItems] = useState(initialItems);  // 함수 객체 자체를 넣어 줘야, 딱 한 번만 호출 (initialItems() -> initialItems)

  const [title, setTitle] = useState('');  // useState(''): 빈 상태면 undefined

  const onClick = () => {
    setItems((prev) => prev.concat({id: prev.length + 1, title}));
  };

  return (
    <>
      <input type="text" onChange={(e) => setTitle(e.target.value)} value={title} />
      <button type="button" onClick={onClick}>등록</button>

      <ul>
        {items.map(({id, title}) => <li key={id}>{title}</li>)}
      </ul>
    </>
  );
};

export default Todo;