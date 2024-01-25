import { Component, DoCheck } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-employee-menu',
  templateUrl: './employee-menu.component.html',
  styleUrls: ['./employee-menu.component.css'],
})
export class EmployeeMenuComponent implements DoCheck {
  employeeId: any;
  menu1:boolean=false;
  name:any;

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}
  ngDoCheck(): void {
    let currentroute=this.router.url;
    if(currentroute=="/employeeMenu"){
     this.menu1=true;
    }else{
      this.menu1=false;
    }
  }
  ngOnInit() {
    this.employeeId = this.authService.id;
    this.name=sessionStorage.getItem("emp");

    if (this.employeeId !== null || this.employeeId !== undefined) {
      this.isLoggedIn = true;
    }
  }

  isLoggedIn: boolean = false;

  signOut() {
    this.authService.id = '';
    this.router.navigate(['/signOut']);
  }
}
