import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent {
  constructor(
    private authService: AuthenticationService,
    private employeeService: EmployeeService
  ) {}

  registerForm = new FormGroup({
    employee_id: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    confirmPassword: new FormControl('', Validators.required),
  });

  register() {
    if (this.registerForm.invalid) {
      alert('Please fill all required fields.');
      return;
    }

    const employeeId = this.registerForm.value.employee_id;
    this.employeeService.getEmployee(employeeId).subscribe(
      (employeeData) => {
        // Check if employee data exists or is valid
        if (employeeData) {
          // Check if passwords match
          if (this.registerForm.value.password === this.registerForm.value.confirmPassword) {
            const authData = {
              password: this.registerForm.value.password,
              employee: employeeData,
            };
            this.authService.register(authData);
            alert('Registered successfully!');
          } else {
            alert('Passwords do not match.');
          }
        } else {
          alert('Invalid Employee ID.');
        }
      },
      (error) => {
        console.error('Error fetching employee data:', error);
        alert('Error fetching employee data. Please try again.');
      }
    );
  }
}
