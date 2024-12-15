@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page = null

@template.layout.page(
content = @`
@if(page != null && page.getError() != null)
<div class="mx-auto p-4 py-md-5">
    <p>${page.getError()}</p>
</div>
@endif
<div class="mx-auto p-4 py-md-5">
    <form action="${NamedRoutes.loginPath()}" method="post">
        <div class="mb-3">
            <label class="form-label">
                Имя
                <input type="text" class="form-control" name="name" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">
                Пароль
                <input type="password" class="form-control" required name="password" />
            </label>
        </div>
        <input type="submit" class="btn btn-primary" value="Зарегистрировать" />
    </form>
</div>
`
)