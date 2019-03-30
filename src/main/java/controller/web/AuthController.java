package controller.web;

import model.RoleModel;
import model.UserModel;
import model.request.Auth;
import security.Authentcation;
import security.AuthenticationImpl;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleService;
import service.impl.UserService;
import utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class AuthController extends HttpServlet {
    private IUserService userService ;
    private IRoleService roleService;


    public AuthController(){
        this.userService = new UserService();
        this.roleService = new RoleService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        if (message != null && message.equals("userNameOrPasswordInvalues")){
            req.setAttribute("message", "Đăng nhập sai rồi kìa! Nhìn Gì >.<");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userName = req.getParameter("userName");
//        String password = req.getParameter("password");

        Auth auth = FormUtil.mapToModel(Auth.class, req);
        UserModel userModel = userService.findUserNameAndPass(auth);
        String url =Authentcation.newModel(auth.getUserName(), auth.getPassword()).urlRedirect();
        resp.sendRedirect(url);
    }
}
