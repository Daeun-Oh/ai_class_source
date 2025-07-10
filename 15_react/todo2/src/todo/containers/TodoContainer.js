import { useState } from 'react';
import TodoForm from '../components/TodoForm';

const TodoContainer = () => {
  const [form, setForm] = useState({});

  return (
    <>
      <TodoForm />
    </>
  );
};

export default TodoContainer;
