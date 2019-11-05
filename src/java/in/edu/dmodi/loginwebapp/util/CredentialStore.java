/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.edu.dmodi.loginwebapp.util;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Thiago Nascimento <nascimenthiago@gmail.com>
 */
public class CredentialStore {
    
    private static final Set<Credential> _users = new HashSet<>();
    
    static {
        _users.add(new Credential("admin", "admin", "admin", "admin", "admin", "admin@dmodi.com"));
        _users.add(new Credential("dmodi", "dmodi", "ops_user", "dmodi", "dmodi", "dmodi@dmodi.com"));
    }
    
    public static boolean containsUser(String user, String pwd, String role) {
        return _users.contains(new Credential(user, pwd, role));
    }
    
    public static int addUser(String user, String pwd, String rolename, String fname, String lname, String email) {
        _users.add(new Credential(user, pwd, rolename, fname, lname, email));
        return 1;
    }
}
