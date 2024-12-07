@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`
<div class="mx-auto p-4 py-md-5">
    <main>
        <h1><a href="${NamedRoutes.postsPath()}">Все посты</a> </h1>
        <h2>${page.getPost().getId()} ${page.getPost().getName()}</h2>
        <div>${page.getPost().getBody()}</div>
    </main>
</div>
`
)