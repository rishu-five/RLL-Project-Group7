import { Component } from '@angular/core';
import { EmployeeService } from './../employee.service';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent {
  employeeId!: number;
  newPassword!: string;

  constructor(private employeeService: EmployeeService) { }

  onChangePassword(): void {
    this.employeeService.changeEmployeePassword(this.employeeId, this.newPassword)
      .subscribe(
        response => {
          console.log('Password changed successfully!', response);
          this.showSuccessAlert();
        },
        error => {
          console.error('Error occurred while changing password:');
          
        }
      );
      alert('Password changed successfully');
  }

  showSuccessAlert(): void {
    alert('Password changed successfully!');
  }
}
