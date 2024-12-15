package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.LoginPage;
import exercise.dto.MainPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");
        var encryptedPass = encrypt(password);
        var user = UsersRepository.findByName(name);
        if (!UsersRepository.existsByName(name) || !encryptedPass.equals(user.get().getPassword())) {
            var page = new LoginPage(name, "Wrong username or password");
            ctx.render("build.jte", model("page", page)).status(422);
            return;
        }
        ctx.sessionAttribute("currentUser", name);
        ctx.redirect(NamedRoutes.rootPath());
//        if (encryptedPass.equals(user.getPassword())) {
//            ctx.sessionAttribute("currentUser", name);
//            ctx.redirect(NamedRoutes.rootPath());
//        } else {
//            var page = new LoginPage(name, "Wrong username or password");
//            ctx.render("build.jte", model("page", page)).status(422);
//        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void index(Context ctx) {
        var name = ctx.sessionAttribute("currentUser") == null ? null : ctx.sessionAttribute("currentUser");
        var page = new MainPage(name);
        ctx.render("index.jte", model("page", page));
    }
    // END
}
