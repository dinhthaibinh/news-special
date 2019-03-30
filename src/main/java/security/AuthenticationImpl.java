package security;

import model.RoleModel;
import model.UserModel;
import model.request.Auth;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleService;
import service.impl.UserService;

public class AuthenticationImpl implements Authentcation {
    private String userName;
    private String password;
    private IUserService userService = new UserService();
    private IRoleService roleService = new RoleService();

    public AuthenticationImpl() {
    }

    public AuthenticationImpl(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    @Override
    public String urlRedirect() {
        UserModel userModel =  userService.findUserNameAndPass(new Auth(userName, password));
        if (userModel!=null){
            RoleModel role= roleService.findRole(userModel.getRoleId());
            if (role.getRoleName().equals("ADMIN")){
                return "/admin";
            }else if(role.getRoleName().equals("USER")){
                return "/home";
            }
        }else{
            return "/login?message=userNameOrPasswordInvalist";
        }
        return null;
    }
}
