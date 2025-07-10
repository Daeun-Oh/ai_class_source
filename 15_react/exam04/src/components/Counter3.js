import React, { useReducer, useCallback } from 'react';

// dispatch: Reducer로 액션(action)을 보내 상태 변경을 요청하는 함수 (액션(action)을 발생시키는 함수)

function reducer(state, action) {
  // console.log('state:', state, 'action:', action);
  switch (action.type) {
    case 'INCREASE':
      return { ...state, number: state.number + 1 };
    case 'DECREASE':
      return { ...state, number: state.number - 1 };
    default:
      return state;
  }
}

const Counter3 = () => {
  const [state, dispatch] = useReducer(reducer, { number: 0 });

  const { number } = state;

  const onIncrease = useCallback(() => {
    dispatch({ type: 'INCREASE' });
  }, []);

  const onDecrease = useCallback(() => {
    dispatch({ type: 'DECREASE' });
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

export default React.memo(Counter3);
