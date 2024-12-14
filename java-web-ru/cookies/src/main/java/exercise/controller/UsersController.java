package exercise.controller;

import exercise.dto.users.UserPage;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import exercise.repository.UserRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import static io.javalin.rendering.template.TemplateUtil.model;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        var token = Security.generateToken();
        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        ctx.cookie("token", token);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        var cookieToken = ctx.cookie("token");
        var userId = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(userId)
                .orElseThrow(() -> new NotFoundResponse("User with id = " + userId + " not found"));
        var userToken = user.getToken();
        if (cookieToken.equals(userToken)) {
            var page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        } else {
            ctx.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
