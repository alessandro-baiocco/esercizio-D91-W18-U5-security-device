package application.U5D10.services;

import application.U5D10.entities.User;
import application.U5D10.exceptions.UnauthorizedException;
import application.U5D10.payloads.UserLoginDTO;
import application.U5D10.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UsersService usersService;
    @Autowired
    private JWTTools jwtTools;

    public String authenticateUser(UserLoginDTO body){
        User user = usersService.findByEmail(body.email());


        if(body.password().equals(user.getPassword())){

            return jwtTools.createToken(user);
        }else {

            throw new UnauthorizedException("credenziali non valide!");
        }


    }





}
