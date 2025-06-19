import { useState, useCallback } from 'react';

// useCallback 사용 목적
// 1. 불필요한 함수 재생성을 방지하여 렌더링 성능 최적화
// 2. 동일한 함수 참조를 유지해야 하는 경우 (ex. 자식 컴포넌트에 props로 전달 시)

const Counter2 = () => {
  const [number, setNumber] = useState(0);

  // 아래 코드의 문제점: 컴포넌트가 렌더링될 때마다 새로운 함수 객체가 생성됨
  // const onIncrease = () => setNumber(number + 1);
  // const onDecrease = () => setNumber(number - 1);

  // 아래 코드의 문제점: number는 최초의 값만 기억해 계속 0으로 고정됨
  // const onIncrease = useCallback(() => setNumber(number + 1), []);
  // const onDecrease = useCallback(() => setNumber(number - 1), []);

  // 아래 코드의 문제점: 의존성 배열에 number를 포함하면, number가 변경될 때마다 콜백 함수가 새로 만들어짐 → useCallback의 이점이 사라짐
  // const onIncrease = useCallback(() => setNumber(number + 1), [number]); // [number]: number가 바뀔 때만 콜백 함수 재생성
  // const onDecrease = useCallback(() => setNumber(number - 1), [number]); // [number]: number가 바뀔 때만 콜백 함수 재생성

  // 최적 코드: 최신 상태를 안전하게 사용하는 콜백 형태로 정의하고, 의존성 배열을 비워 함수 재생성 방지
  const onIncrease = useCallback(() => {
    setNumber((number) => number + 1);
  }, []);
  const onDecrease = useCallback(() => {
    setNumber((number) => number - 1);
  }, []);

  return (
    <>
      <h1>{number}</h1>
      <button type="button" onClick={onDecrease}>
        -1
      </button>
      <button type="button" onClick={onIncrease}>
        +1
      </button>
    </>
  );
};

export default Counter2;