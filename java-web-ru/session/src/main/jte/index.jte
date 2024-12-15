@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
    content = @`
        @if(page.getName() != null)
            <div class="mx-auto p-4 py-md-5">
                <main>
                    ${page.getName().toString()}
                    <form action="${NamedRoutes.logoutPath()}" method="post">
                        <input type="submit" class="btn btn-primary" value="Выйти" />
                    </form>
                </main>
            </div>
        @endif

        @if(page.getName() == null)
            <div class="mx-auto p-4 py-md-5">
                <main>
                    <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
                </main>
            </div>
        @endif
    `
)