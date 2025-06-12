import MyComponent from './components/MyComponent';
import MyComponent2 from './components/MyComponent2';
import Counter from './components/Counter';

const App = () => {
  return (
    // html 문법이 아님. 소괄호 안은 객체.
    <>
      <MyComponent color="green" />
      <MyComponent2 color="yellow" />
      <Counter />
    </>
  );
};

export default App;
