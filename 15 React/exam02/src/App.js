import logo from './logo.svg';
import './App.css';

function App() {
  let name = 0;
  name = name ?? '홍길동';
  return name && <h1 className='greet'>{name}님, 반갑습니다.</h1>;
}

export default App;
