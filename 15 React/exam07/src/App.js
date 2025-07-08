import ColorBox from './components/ColorBox';
import SelectColors from './components/SelectColors';
import { ColorProvider } from './contexts/color';

const App = () => {
  return (
    <>
      {/* ColorProvider: 값 교체 -> 하위에서도 가능 */}
      <ColorProvider>
        <ColorBox />
        <SelectColors /> 
      </ColorProvider>
    </>
  );
};

// import ColorBox from './components/ColorBox';
// import ColorContext from './contexts/color';

// const App = () => {
//   return (
//     <>
//       {/* Provider: 값 교체 -> 상위에서만 가능 */}
//       <ColorContext.Provider value={{ color: 'red' }}>
//         <ColorBox />
//       </ColorContext.Provider>
//     </>
//   );
// };

// import ColorBox from './components/ColorBox';
// import ColorContext from './contexts/color';

// const App = () => {
//   return (
//     <>
//       {/* Provider: 값 교체 */}
//       <ColorContext.Provider value={{ color: 'red' }}>
//         <ColorBox />
//       </ColorContext.Provider>
//     </>
//   );
// };

// import ColorBox from './components/ColorBox';
// import RenderPropsEx from './components/RenderPropsEx';
// import ColorContext from './contexts/color';

// const App = () => {
//   return (
//     <>
//       {/* <ColorBox /> */}
//       {/* <RenderPropsEx>{value => (ColorBox)}</RenderPropsEx> */}
//       <ColorContext.Consumer>
//          <ColorBox />
//       </ColorContext.Consumer>
//     </>
//   );
// };

export default App;
