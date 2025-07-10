import { Component } from 'react';

class Counter2 extends Component {
  state = {
    number: 0,
  };

  render() {
    const { number } = this.state; // {...} : 비구조화 할당

    return (
      <>
        <h1>{number}</h1>
        {/* 함수를 절대 호출하면 안 되고, 함수 객체를 정의해야 한다. */}
        <button
          type="button"
          onClick={() => this.setState({ number: number - 1 })}
        >
          -1
        </button>
        <button
          type="button"
          onClick={() => this.setState({ number: number + 1 })}
        >
          +1
        </button>
      </>
    );
  }
}

export default Counter2;
