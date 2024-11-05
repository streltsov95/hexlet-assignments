@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <main>
            <h1>Пользователи</h1>
            <table class="table table-striped">
                @for(var user : page.getUsers())
                <tr>
                    <td>
                        ${user.getId()}
                    </td>
                    <td>
                        <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                    </td>
                </tr>
                @endfor
            </table>
        </main>
    `
)