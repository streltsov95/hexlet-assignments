@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
<div class="mx-auto p-4 py-md-5">
    <main>
        <h1>Все посты</h1>

        <table class="table table-striped">
            @for(var post : page.getPosts())
            <tr>
                <td>
                    <a href="/posts/${post.getId()}">${post.getName()}</a>
                </td>
            </tr>
            @endfor
        </table>

        <a href="/posts?page=${page.getPage() < 2 ? 1 : page.getPage() - 1}">Назад</a> <a href="/posts?page=${page.getPage() + 1}">Вперед</a>
    </main>
</div>
`
)