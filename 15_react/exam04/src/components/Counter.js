import { useState, useRef, useEffect } from 'react';

// useRef 사용 목적
// 1. 렌더링과 관계없는 지역 변수처럼 값 저장 (예: cntRef)
// 2. 실제 DOM 요소에 직접 접근 (예: h1Ref)

const Counter = () => {
  const [number, setNumber] = useState(0);

  const cntRef = useRef(0); // 렌더링과 무관한 값 저장
  const h1Ref = useRef();   // 실제 DOM 요소를 참조 (DOM 객체 선택)

  useEffect(() => {
    console.log('h1Ref.current', h1Ref.current);
    h1Ref.current.style.background = 'orange';
  }, [h1Ref]);

  const onIncrease = () => {
    setNumber(number + 1);
    console.log('cntRef.current', cntRef.current);
    cntRef.current++;
  };
  const onDecrease = () => setNumber(number - 1);

  return (
    <>
      <h1 ref={h1Ref}>{number}</h1>
      <button type="button" onClick={onDecrease}>
        -1
      </button>
      <button type="button" onClick={onIncrease}>
        +1
      </button>
    </>
  );
};

export default Counter;
