import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { UserQueryService } from 'src/app/services/user_query/user-query.service';
import { MatDialog } from '@angular/material/dialog';
import { ReplyConsultationModalComponent } from '../reply-consultation-modal/reply-consultation-modal.component';

@Component({
  selector: 'app-consultations-table',
  templateUrl: './consultations-table.component.html',
  styleUrls: ['./consultations-table.component.css']
})
export class ConsultationsTableComponent implements OnInit, AfterViewInit {
  consultations: MatTableDataSource<any>;
  displayedColumns: string[] = ['fullName', 'zone', 'date', 'createdDateTime', 'phone', /* 'generalQuery', */ 'isAnswered', 'action', 'answeredByUser', 'answeredDateTime'];

  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private userQueryService: UserQueryService,
    private dialog: MatDialog) {
    this.consultations = new MatTableDataSource<any>([]);
  }

  ngOnInit(): void {
    this.loadConsultations();
  }

  ngAfterViewInit(): void {
    this.consultations.sort = this.sort;
    this.consultations.paginator = this.paginator;
  }

  loadConsultations(): void {
    this.userQueryService.getUserQuerys().subscribe(consultations => {
      consultations.sort((a, b) => new Date(b.createdDateTime ?? 0).getTime() - new Date(a.createdDateTime ?? 0).getTime());
      this.consultations.data = consultations;
      this.consultations.sort = this.sort;
    });
  }

  openReplyModal(consultation: any): void {
    const dialogRef = this.dialog.open(ReplyConsultationModalComponent, {
      width: '400px',
      data: { consultation: consultation }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.loadConsultations();
      }
    });
  }
}
