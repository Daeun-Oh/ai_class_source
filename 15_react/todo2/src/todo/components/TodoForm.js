const TodoForm = ({ form, onChange }) => {
  return (
    <form>
      <div>
        <input
          type="text"
          onChange={onChange}
          name="title"
          placeholder="할일 제목"
          value={form?.title ?? ''}
        />
      </div>
      <div>
        <textarea
          onChange={onChange}
          name="content"
          placeholder="할일 내용"
          value={form?.content ?? ''}
        ></textarea>
      </div>
      <button type="submit">제출하기</button>
    </form>
  );
};

export default TodoForm;
