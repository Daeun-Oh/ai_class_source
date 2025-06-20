import React, { useState, useCallback, useMemo } from 'react';

// 차곡차곡 숫자를 쌓아서 평균을 구하는 코드

const getAverage = (items) => {
  if (items.length === 0) return 0;

  const total = items.reduce((a, b) => a + b);

  const avg = Math.round((total / items.length) * 10) / 10;

  return avg;
};

const Average = () => {
  const [items, setItems] = useState([]);
  const [number, setNumber] = useState('');

  const onChange = useCallback((e) => {
    try {
      setNumber(Number(e.target.value.trim()));
    } catch (e) {}
  }, []);

  const onSubmit = useCallback(
    (e) => {
      e.preventDefault();
      setItems((items) => items.concat(number));
    },
    [number],
  );

  // 최적 방법: items가 변경될 때만 평균을 구함
  const avg = useMemo(() => getAverage(items), [items]);

  return (
    <>
      <form onSubmit={onSubmit} autoComplete="off">
        <input type="number" onChange={onChange} value={number} />
        <button type="submit">등록</button>
      </form>
      <ul>
        {items.map((item, i) => (
          <li key={i + '-' + item}>{item}</li>
        ))}
      </ul>
      {/* 아래 코드의 문제점: 입력 필드의 상태(number)가 바뀔 때마다 getAverage 함수가 다시 실행됨 */}
      {/* <div>평균: {getAverage(items)}</div> */}
      <div>평균: {avg}</div>
    </>
  );
};

export default React.memo(Average);
