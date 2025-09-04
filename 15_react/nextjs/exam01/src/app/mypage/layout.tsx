export default function MyPageLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <>
      <aside>마이페이지 사이드 메뉴</aside>
      <section>{children}</section>
    </>
  )
}
