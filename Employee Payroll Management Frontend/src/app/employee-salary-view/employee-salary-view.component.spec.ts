import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeSalaryViewComponent } from './employee-salary-view.component';

describe('EmployeeSalaryViewComponent', () => {
  let component: EmployeeSalaryViewComponent;
  let fixture: ComponentFixture<EmployeeSalaryViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmployeeSalaryViewComponent],
    });
    fixture = TestBed.createComponent(EmployeeSalaryViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
