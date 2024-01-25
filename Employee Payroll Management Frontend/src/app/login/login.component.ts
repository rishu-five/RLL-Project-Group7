import { EmployeeService } from './../employee.service';
import { FormControl, FormGroup,Validators } from '@angular/forms';
import { AuthenticationService } from './../authentication.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  

  EmployeeID: any;

  ngOnInit(): void {
    this.authService.employeeId$.subscribe((employeeId) => {
      this.EmployeeID = employeeId;
    });
  }

  loginForm = new FormGroup({
    employee_id: new FormControl('', Validators.required), // Mark as required
    password: new FormControl('', Validators.required), // Mark as required
  });

  // Add an error message property
  errorMessage: string = '';

  constructor(
    private authService: AuthenticationService,
    private employeeService: EmployeeService,
    private router: Router
  ) {}

  login() {
    if (this.loginForm.invalid) {
      // Check if form is invalid
      this.errorMessage = 'Please enter Employee ID and Password.';
      return;
    }

    const employeeId = this.loginForm.value.employee_id;
    const password = this.loginForm.value.password;
    console.log(employeeId, password);

    this.employeeService.getEmployee(employeeId).subscribe(
      (employeeData) => {
        const authData = {
          password: password,
          employee: employeeData,
        };

        this.authService.login(authData);
        
        if (employeeData.role.toLowerCase() === 'admin') {
          this.router.navigate(['/adminMenu']);
          localStorage.setItem("admin",employeeData.name);
        } else if (employeeData.role.toLowerCase() === 'employee') {
          this.router.navigate(['/employeeMenu']);
          sessionStorage.setItem("emp",employeeData.name);
        }
      },
      (employeeError) => {
        console.error('Employee retrieval error:', employeeError);
        this.errorMessage = 'Incorrect Employee ID or Password.'; // Set error message for incorrect credentials
      }
    );
  }
}
