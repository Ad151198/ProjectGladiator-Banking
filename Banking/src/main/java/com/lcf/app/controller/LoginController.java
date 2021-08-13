/*
 * package com.lcf.app.controller;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.lcf.app.beans.LoginCredentials; import
 * com.lcf.app.services.LoginService;
 * 
 * @CrossOrigin(origins="*")
 * 
 * @RestController
 * 
 * @RequestMapping("/banking/lcf/home-page") public class LoginController {
 * 
 * @Autowired private LoginService loginService;
 * 
 * @PostMapping("/login") public boolean login(@RequestBody LoginCredentials
 * log) { long userId = log.getCustomerId(); String password =
 * log.getLoginPassword(); boolean flag = loginService.login(userId, password);
 * System.out.println(flag); return flag; }
 * 
 * public LoginCredentials getLoginCredentialsById(long id) {
 * 
 * LoginCredentials loginObj = loginService.getLoginCredentialsById(id); return
 * loginObj; }
 * 
 * public boolean netBankingRegistration(LoginCredentials loginObj) {
 * 
 * boolean flag= loginService.netBankingRegistration(loginObj); return flag;
 * 
 * }
 * 
 * }
 */