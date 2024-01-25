import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LeaveService } from '../leave.service';

@Component({
  selector: 'app-leave',
  templateUrl: './leave.component.html',
  styleUrls: ['./leave.component.css']
})
export class LeaveComponent {

  data: any; 

  leave = { 
    employee_id: '',
    leaveType:'',
    startDate: '',
    endDate: '',
    reason: ''
  };

  leaveList: any[] = [];
  isEditMode = false;
  id: any;
  editdetails: any;

  constructor(
    private leaveService: LeaveService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loadLeaveList();
  }

  submitLeaveApplication() {
    this.data = {
      leaveType: this.leave.leaveType,
      startDate: this.leave.startDate,
      endDate: this.leave.endDate,
      reason: this.leave.reason,
      employee: {
        id: parseInt(this.leave.employee_id)
      }
    };

    this.leaveService.applyForLeave(this.data).subscribe(
      (res) => {
        this.loadLeaveList();
        alert('Leave added successfully!');
      },
      (error) => {
        this.loadLeaveList();
      }
    );

    this.clearForm();
    alert("Leave added successfully");
  }

  updateLeave() {
    this.data = {
      leaveType: this.leave.leaveType,
      startDate: this.leave.startDate,
      endDate: this.leave.endDate,
      reason: this.leave.reason,
      employee: {
        id: parseInt(this.leave.employee_id)
      }
    };

    this.leaveService.updateLeave(this.id, this.data).subscribe(
      (res) => {
        this.loadLeaveList();
        alert('Leave updated successfully!');
      },
      (error) => {
        this.loadLeaveList();
        alert('Error updating leave!');
      }
    );

    this.cancelUpdate();
  }

  deleteLeave(id: number) {
    this.leaveService.deleteLeave(id).subscribe(
      (res) => {
        this.loadLeaveList();
        alert('Leave deleted successfully!');
      },
      (error) => {
        this.loadLeaveList();
        alert('Error deleting leave!');
      }
    );
  }

  clearForm() {
    this.leave = { 
      employee_id: '',
      leaveType: '',
      startDate: '',
      endDate: '',
      reason: ''
    };
  }

  loadLeaveList() {
    this.leaveService.getAllLeaves().subscribe(
      (data: any[]) => {
        this.leaveList = data;
      },
      (error) => {
        console.log('Error fetching leave list:', error);
      }
    );
  }

  editLeave(leaveItem: any) {
    this.leave = { ...leaveItem };
    this.editdetails = {...leaveItem};
    this.id = this.editdetails.id;
    this.isEditMode = true;
  }

  cancelUpdate() {
    this.isEditMode = false;
    this.leave = { 
      employee_id: '',
      leaveType: '',
      startDate: '',
      endDate: '',
      reason: ''
    };
  }
}
