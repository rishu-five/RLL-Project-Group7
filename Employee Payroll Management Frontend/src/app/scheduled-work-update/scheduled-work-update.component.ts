import { ChangeDetectorRef, Component } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { EmployeeService } from '../employee.service';
import { ScheduleWorkService } from '../schedule-work.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-scheduled-work-update',
  templateUrl: './scheduled-work-update.component.html',
  styleUrls: ['./scheduled-work-update.component.css']
})
export class ScheduledWorkUpdateComponent {

  constructor(
    private schedule_work_service: ScheduleWorkService,
    private employeeService: EmployeeService, private router:Router,
  ) {}

  WorkScheduled: any;
  employee: any;
  showForm:boolean = false;
  errorMsgClass:string = "error";

  ngOnInit() {
    this.getAllScheduledWorks();
  }

  WorkScheduleForm = new FormGroup({
    employee_id: new FormControl('', [Validators.required]),
    id: new FormControl(''),
    date_assigned: new FormControl('', [Validators.required]),
    is_work_assigned: new FormControl('', [Validators.required]),
    work_description: new FormControl('', [Validators.required]),
  });

  getAllScheduledWorks(){
    this.schedule_work_service.getScheduledWorks().subscribe(
      (data)=>{this.WorkScheduled = data}
    )
  }

  updateWork(data: any) {
    this.showForm = true;

    // // Disable the employee_id control
    // this.WorkScheduleForm.get('employee_id')?.disable();
    // this.WorkScheduleForm.get('id')?.disable()

    this.WorkScheduleForm.patchValue({
      employee_id: data.employee_id,
      id:data.id,
      date_assigned: data.date_assigned,
      is_work_assigned: data.is_work_assigned,
      work_description: data.work_description,
    });
  }

  closeForm(){
    this.showForm = false;
  }

  saveUpdatedWork() {
    const employeeId = this.WorkScheduleForm.value.employee_id;
  
    this.employeeService.getEmployee(employeeId).subscribe((employeeData) => {
      this.employee = employeeData;
  
      this.WorkScheduled = {
        employee: this.employee,
        date_assigned: this.WorkScheduleForm.value.date_assigned,
        is_work_assigned: this.WorkScheduleForm.value.is_work_assigned,
        work_description: this.WorkScheduleForm.value.work_description,
      };
  
      this.schedule_work_service.updateWork(this.WorkScheduleForm.value.id, this.WorkScheduled).subscribe(
        (res) => {
          console.log("Updated...");
          window.alert('Work updated successfully!'); // Display alert upon successful update
        },
        (error) => {
          console.error("Error updating work:", error);
          // Handle error if needed
        }
      );
    });
  
    this.closeForm();
    alert("work updated successfully!");
    this.router.navigate(['/adminMenu']);
  }
  
  clearForm() {
    this.WorkScheduleForm.patchValue({
      employee_id: null,
      date_assigned: null,
      is_work_assigned: null,
      work_description: null,
    });
    this.employee = null;
  }


  deleteWork(id: any) {
    this.schedule_work_service.deleteWork(id)
    console.log("Deleted...");
    alert("Work deleted");
    this.router.navigate(['/adminMenu']);
  }



}
