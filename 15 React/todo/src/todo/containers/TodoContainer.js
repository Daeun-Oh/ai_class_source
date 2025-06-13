import { useState } from 'react';
import TodoForm from '../components/TodoForm';
import TodoItems from '../components/TodoItems';

const TodoContainer = () => {
  // 이건 비효율적임
  //   const [todo, setTodo] = useState();
  //   const [todoContent, setTodoContent] = useState();
  const [form, setForm] = useState({});

  const onSubmit = (e) => {
    e.preventDefault();
    console.log('form', form);
  };

  const onChange = (e) => {
    form[e.target.name] = e.target.value;
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  // change 이벤트 핸들러 함수: 텍스트에 변화가 생길 때마다 호출
  //   const onChange = (e) => {
  //     console.log('e.target', e.target);
  //     setTodo(e.target.value);
  //   };

  //   const onChange2 = (e) => {
  //     setTodoContent(e.target.value);
  //   };

  return (
    <>
      <TodoForm onSubmit={onSubmit} onChange={onChange} />
      <TodoItems />
      todo: {form.title} / todoContent: {form.content}
    </>
  );
};

export default TodoContainer;
