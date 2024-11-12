import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { UserService } from 'src/app/services/user/user.service';
import { CreateEmployeeComponent } from '../create-employee/create-employee.component';
import { MatDialog } from '@angular/material/dialog';
import { EditEmployeeComponent } from '../edit-employee/edit-employee.component';
import { ConfirmDeleteEmployeeComponent } from '../confirm-delete-employee/confirm-delete-employee.component';

@Component({
  selector: 'app-employees-table',
  templateUrl: './employees-table.component.html',
  styleUrl: './employees-table.component.css'
})
export class EmployeesTableComponent implements OnInit, AfterViewInit {
  employees = new MatTableDataSource<any>();
  displayedColumns: string[] = ['id', 'username', 'actions'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private userService: UserService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.loadEmployees();
  }

  ngAfterViewInit(): void {
    this.employees.paginator = this.paginator;
    this.employees.sort = this.sort;
  }

  loadEmployees(): void {
    this.userService.getAllEmployes().subscribe((data) => {
      this.employees.data = data;
    });
  }

  openAddEmployeeModal(): void {
    const dialogRef = this.dialog.open(CreateEmployeeComponent, {
      width: '400px'
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.loadEmployees();
      }
    });
  }

  openEditEmployeeModal(employee: any): void {
    const dialogRef = this.dialog.open(EditEmployeeComponent, {
      width: '400px',
      data: { employee }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.loadEmployees();
      }
    });
  }

  openDeleteEmployeeModal(employee: any): void {
    const dialogRef = this.dialog.open(ConfirmDeleteEmployeeComponent, {
      width: '400px',
      data: { employee }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.loadEmployees();
      }
    });
  }
}