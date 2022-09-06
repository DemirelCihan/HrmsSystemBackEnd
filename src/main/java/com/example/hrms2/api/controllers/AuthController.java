package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.AuthService;
import com.example.hrms2.core.results.ErrorDataResult;
import com.example.hrms2.entities.concretes.Candidate;
import com.example.hrms2.entities.concretes.CompanyPersonnel;
import com.example.hrms2.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
private AuthService authService;
@Autowired
    public AuthController(AuthService authService){
    this.authService = authService;
}
@PostMapping("/registerCompanyPersonnel")
    public ResponseEntity<?> registerCompanyPersonnel(@Valid @RequestBody CompanyPersonnel companyPersonnel, String confirmPassword){
    return ResponseEntity.ok(authService.registerCompanyPersonnel(companyPersonnel,confirmPassword));
    /*ResponseEntity sınıfı HttpEntity classına ek olarak builder tasarım desenini kullanarak
    * isteğe yanıt olarak header bilgisi,HTTP durum kodu gibi bilgileri eklemeyi sağlar.*/

}
    @PostMapping("/registerCandidate")
    public ResponseEntity<?> registerCandidate(@Valid @RequestBody Candidate candidate, String confirmPassword){
    return ResponseEntity.ok(authService.registerCandidate(candidate,confirmPassword));
    }

    @PostMapping("/registerEmployer")
    public ResponseEntity<?> registerEmployer(@Valid @RequestBody Employer employer, String confirmPassword){
    return ResponseEntity.ok(authService.registerEmployer(employer,confirmPassword));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors = new HashMap<String , String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());

        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors);

        return errors;
    }

}
