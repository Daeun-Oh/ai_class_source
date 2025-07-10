import React, { useState } from "react";
import loadable from '@loadable/component';

const SplitMe = loadable(() => import('./SplitMe'), {
  fallback: <div>로딩 중...</div>,
});

const WritePage = () => {
  const [visible, setVisible] = useState(false);

  return (
    <>
      <h1>글 작성...</h1>
      <button type="button" onClick={() => setVisible(true)}>
        보이기
      </button>

      {visible && <SplitMe />}
    </>
  );
};

// ✅ 그 다음 memo 처리 + export
export default React.memo(WritePage);



// const SplitMe = React.lazy(() => import('./SplitMe'));

// const WritePage = () => {
// 	const [visible, setVisible] = useState(false);

// 	return (
// 		<>
// 			<h1>글 작성...</h1>
// 			<button type="button" onClick={() => setVisible(true)}>
// 				보이기
// 			</button>

// 			<Suspense fallback={<div>로딩 중...</div>}>
// 				{visible && <SplitMe />}
// 			</Suspense>
// 		</>
// 	);
// };

// export default React.memo(WritePage);