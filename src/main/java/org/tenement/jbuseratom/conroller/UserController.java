package org.tenement.jbuseratom.conroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.tenement.jbuseratom.entity.User;
import org.tenement.jbuseratom.exception.ValidationException;
import org.tenement.jbuseratom.service.UserService;
import org.tenement.jbuseratom.utils.ValidationUtils;
import org.tenement.jbuseratom.validator.UserValidator;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;

    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor trimEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimEditor);
        dataBinder.addValidators(userValidator);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.fetchAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserByUserId(@PathVariable("userId") Long userId) {
        User user = userService.fetchUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/user/create")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.error("Errors in saving user {}, {}", user, bindingResult);
            throw new ValidationException("Error validating user", ValidationUtils.getFieldErrors(bindingResult,"user."));
        }
        user.setCreationDate(new Date());
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

}
