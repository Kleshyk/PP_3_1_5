package testgroup.BOOT_prilozhenie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import testgroup.BOOT_prilozhenie.model.Role;
import testgroup.BOOT_prilozhenie.model.User;
import testgroup.BOOT_prilozhenie.service.RoleService;
import testgroup.BOOT_prilozhenie.service.UserService;

import java.util.List;

@RestController
public class MyRestController {

    private final UserService userService;
    private final RoleService roleService;

    public MyRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/getAuthorizedUser")
    public ResponseEntity<?> getAuthorizedUser() {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByUsername(userDetails.getUsername());
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/admin/AllUsers")
    public ResponseEntity<Iterable<User>> AllUsers() {
        final List<User> userList = userService.allUsers();

        return userList != null && !userList.isEmpty()
                ? new ResponseEntity<>(userList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<Iterable<Role>> getAllRoles() {
        return ResponseEntity.ok().body(roleService.getAllRoles());
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        final User userList = userService.getById(id);

        return userList != null
                ? new ResponseEntity<>(userList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/admin/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.add(user);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/admin/edit")
    public ResponseEntity<User> editUser(@RequestBody User user) {
        userService.edit(user);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
        userService.delete(userService.getById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
