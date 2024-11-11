import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Zone } from 'src/app/models/Zone';
import { UserQueryService } from 'src/app/services/user_query/user-query.service';
import { ZoneService } from 'src/app/services/zone/zone.service';


@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  contactForm: FormGroup;
  zones: Zone[] = [];
  isSubmitted: boolean = false;
  isError: boolean = false;

  constructor(
    private fb: FormBuilder,
    private zoneService: ZoneService,
    private userQueryService: UserQueryService
  ) {
    this.contactForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      zoneId: ['', Validators.required],
      date: ['', Validators.required],
      generalQuery: ['', Validators.required],
      phone: [
        '',
        [
          Validators.required,
          Validators.pattern('^[0-9]{10}$')
        ]
      ]
    });
  }

  ngOnInit(): void {
    this.loadZones();
  }

  loadZones(): void {
    this.zoneService.getZones().subscribe((zones) => {
      this.zones = zones;
    });
  }

  onSubmit(): void {
    if (this.contactForm.valid) {
      const formData = this.contactForm.value;
      this.userQueryService.sendContactQuery(formData).subscribe(response => {
        this.isSubmitted = true;
        this.isError = false;
        this.contactForm.reset();
        setTimeout(() => {
          this.isSubmitted = false;
        }, 5000);
      })
      error: (error: any) => {
        this.isError = true;
        this.isSubmitted = false;

        setTimeout(() => {
          this.isError = false;
        }, 5000);
      }
    }
  }
}
