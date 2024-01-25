import { Component } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Router } from '@angular/router';
import { Employee } from '../employee';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent {

  employee: Employee = new Employee();
  msg1:string="";
  msg2:string=""

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
  }

  saveEmployee() {
    this.employeeService.createEmployee(this.employee).subscribe(
      data => {
        console.log(data);
        if((this.employee.role.toLowerCase()==="admin" || this.employee.role.toLowerCase()==="employee"))
        {
          
            this.showSuccessAlert();
            this.router.navigate(['/adminMenu']);
        }
        else{
          this.msg1="Role Must be Admin or Employee";
          
          //alert("Role Must be Admin or Employee");
        }
      },
      error => console.log(error),
      () => {
        //this.goToEmployeeList();
      }
    );
  }

  goToEmployeeList() {
    this.router.navigate(['/adminMenu']);
  }

  onSubmit() {
    // Logic for handling form submission
    // You can access form data using properties bound with ngModel
    if (!this.employee.name || !this.employee.mail_id || !this.employee.role || !this.employee.category || !this.employee.gender) {
      alert('Please fill in all required fields!');
    } else {
      this.saveEmployee();
    }
  }


  showSuccessAlert(): void {
    alert('Employee added successfully!');
  }



}
