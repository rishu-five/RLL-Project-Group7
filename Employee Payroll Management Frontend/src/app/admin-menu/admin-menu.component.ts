import { Component, DoCheck } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css'],
})
export class AdminMenuComponent implements DoCheck {
  employeeId: any;
  menu1:boolean=false;
  name:any;
  
  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}
  ngDoCheck(): void {
    let currentroute=this.router.url;
    if(currentroute=="/adminMenu"){
     this.menu1=true;
    }else{
      this.menu1=false;
    }
  }

  ngOnInit() {
    this.employeeId = this.authService.id;
    this.name=localStorage.getItem("admin");
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
