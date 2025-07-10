import React, { Component } from 'react';

class MyComponent2 extends Component {
  render() {
    // console.log('props', this.props); // props 확인
    // console.dir(Object.getOwnPropertyDescriptors(this.props));
    // console.log('extensible', Object.isExtensible(this.isExtensible));
    // console.log('isFrozen', Object.isFrozen(this.isFrozen));

    // const style = {
    //     backgroudColor: this.props.color,
    // }

    const color = this.props.color;

    return (
      <h1 style={{ backgroundColor: color }}>나의 멋진 컴포넌트2 (클래스)</h1>
    );
  }
}

export default MyComponent2;
