import styles from './MyComponent1.module.scss';
import { useState } from 'react';
import classNames from 'classnames';

const cx = classNames.bind(styles);

const MyComponent1 = () => {
  const [visible, setVisible] = useState(false);

  const onToggle = () => setVisible(!visible);

  return (
    <>
      <button type="button" onClick={onToggle}>
        토글
      </button>
      <h1 className={cx('one', 'two', { [styles.hidden]: !visible })}>보일까말까?</h1>
    </>
  );
};

export default MyComponent1;
