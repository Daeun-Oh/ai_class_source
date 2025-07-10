import { Routes, Route } from 'react-router-dom';
import MainPage from './main/pages/MainPage';
import MemberRoutes from './global/routes/MemberRoutes';
import BoardRoutes from './global/routes/BoardRoutes';
import MainLayout from './global/layouts/MainLayout';
import NotFoundPage from './global/pages/NotFoundPage';

const App = () => {
  return (
    <>
      <MemberRoutes />
      <BoardRoutes />
      <Routes>
        <Route path='/' element={<MainLayout />}>
          <Route index element={<MainPage />} />
          <Route path='*' element={<NotFoundPage />} />
        </Route>
      </Routes>
    </>
  );
};

export default App;