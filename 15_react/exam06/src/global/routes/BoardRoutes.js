import React from 'react';
import { Routes, Route } from 'react-router-dom';
import loadable from '@loadable/component';
// import WritePage from '../../board/pages/WritePage';
// import ViewPage from '../../board/pages/ViewPage';
// import ListPage from '../../board/pages/ListPage';
// import ListMainPage from '../../board/pages/ListMainPage';
// import MainLayout from '../layouts/MainLayout';

const WritePage = loadable(() => import('../../board/pages/WritePage'));
const ViewPage = loadable(() => import('../../board/pages/ViewPage'));
const ListPage = loadable(() => import('../../board/pages/ListPage'));
const ListMainPage = loadable(() => import('../../board/pages/ListMainPage'));
const MainLayout = loadable(() => import('../layouts/MainLayout'));

const BoardRoutes = () => {
    return (
        <Routes>
            <Route path='/board/' element={<MainLayout />}>
                <Route index element={<ListPage />} />
                <Route path="write/:bid" element={<WritePage />} />
                <Route path="view/:seq" element={<ViewPage />} />
                <Route path='list'>
                    <Route index element={<ListMainPage />} />
                    <Route path=":bid" element={<ListPage />} />
                </Route>
            </Route>
        </Routes>
    )
}

export default React.memo(BoardRoutes);