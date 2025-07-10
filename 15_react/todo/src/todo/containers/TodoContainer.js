import { useState } from 'react';
import { produce } from 'immer';
import TodoForm from '../components/TodoForm';
import TodoItems from '../components/TodoItems';

const TodoContainer = () => {
  // 이건 비효율적임
  //   const [todo, setTodo] = useState();
  //   const [todoContent, setTodoContent] = useState();
  const [form, setForm] = useState({}); // {} : null / 아무것도 안 넣으면 : undefined (오류 발생)
  const [items, setItems] = useState([
    { id: 1, title: '할일1', content: '할일1 내용', checked: false },
    { id: 2, title: '할일2', content: '할일2 내용', checked: true },
    { id: 3, title: '할일3', content: '할일3 내용', checked: false },
  ]);
  const [errors, setErrors] = useState({});

  const onSubmit = (e) => {
    e.preventDefault();

    // -- 유효성 검사 S --

    // if (!form?.title || !form?.title?.trim()) {
    //   // undefined, null 또는 공백 문자만 있는 경우
    //   errors.title = '제목을 입력하세요.';
    // }
    // if (!form?.content || !form?.content?.trim()) {
    //   errors.content = '내용을 입력하세요.';
    // }

    let hasErrors = false;

    const requiredFields = {
      title: '제목을 입력하세요.',
      content: '내용을 입력하세요.',
    };
    const errors = {};
    for (const [field, message] of Object.entries(requiredFields)) {
      if (!form[field] || !form[field]?.trim()) {
        errors[field] = message;
        hasErrors = true;
      }
    }

    // 유효성 검사 실패 시 다음 로직 실행 X
    setErrors(errors);
    if (hasErrors) return;

    // -- 유효성 검사 E --

    // items.push(form); -> 새로운 객체가 아니라서(주소가 같아서) 변화 감지 X
    // setItems(items);

    // setItems(items.concat({ ...form, id: Date.now() }));
    setItems(
      produce((draft) => {
        draft.push({ ...form, id: Date.now() });
      }),
    );

    // 양식 초기화
    setForm({});
  };

  const onChange = (e) => {
    // form[e.target.name] = e.target.value;
    //   -> 얕은 복사: 객체의 주솟값을 비교. 메모리에서 한번 만들어진 form={...} 객체는 값을 직접 바꿔도 주소는 바뀌지 않음.
    setForm({ ...form, [e.target.name]: e.target.value });
    //   -> 깊은 복사: 새로운 객체를 생성하고, 안에 있는 값만 비교.
  };

  // change 이벤트 핸들러 함수: 텍스트에 변화가 생길 때마다 호출
  //   const onChange = (e) => {
  //     console.log('e.target', e.target);
  //     setTodo(e.target.value);
  //   };

  //   const onChange2 = (e) => {
  //     setTodoContent(e.target.value);
  //   };

  // 체크박스 토글 처리
  const onToggle = (id) => {
    setItems((prevItems) =>
      prevItems.map((item) =>
        item.id === id ? { ...item, checked: !item.checked } : item,
      ),
    );
  };

  // 스케줄 삭제 처리 - 해당 id를 제외한 나머지 목록으로 새로운 객체 반환
  const onRemove = (id) => {
    // setItems((prevItems) => prevItems.filter((item) => item.id !== id));
    const index = items.findIndex((item) => item.id === id);
    setItems(produce((draft) => {
      draft.splice(index, 1, 0);
    })); // 불변성 유지가 알아서 됨
  };

  // 선택된 스케줄 일괄 삭제 처리
  const onRemoveAll = () => {
    setItems(items.filter(({ checked }) => !checked));
  };

  return (
    <>
      <TodoForm
        onSubmit={onSubmit}
        onChange={onChange}
        form={form}
        errors={errors}
      />
      <TodoItems
        items={items}
        onToggle={onToggle}
        onRemove={onRemove}
        onRemoveAll={onRemoveAll}
      />
    </>
  );
};

export default TodoContainer;
