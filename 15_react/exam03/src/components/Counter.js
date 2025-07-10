import { useState } from 'react';

const Counter = () => {
  const [number, setNumber] = useState(0);
  let cnt = 0;

  console.log('호출!', number);

  const onPlus = () => {
    setNumber(number + 1);

    console.log('cnt', cnt);
    cnt++;
  };

  return (
    <>
      <h1>{number}</h1>
      {/* setNumber(함수)엔 값을 넣을 수도 있지만, 함수 객체도 매개변수로 넣을 수 있다! */}
      <button
        type="button"
        onClick={() => setNumber((prevNumber) => prevNumber - 1)}
      >
        -1
      </button>
      <button type="button" onClick={onPlus}>
        +1
      </button>
    </>
  );
};

export default Counter;
