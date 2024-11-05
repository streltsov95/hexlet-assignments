@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <main>
            <h2>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h2>
            <div>${page.getUser().getEmail()}</div>
        </main>
    `
)