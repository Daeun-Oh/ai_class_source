import styles from './CSSModule.module.scss';
console.log('styles', styles);

const CSSModule = () => {
    return (
      <div className={`${styles.wrapper} ${styles.inverted}`}>
        안녕하세요, 저는 <span className="something">CSSModule</span>!
        반갑습니다.
      </div>
    );
};

export default CSSModule;