import { Component } from '@angular/core';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent {
  testimonials = [
    { message: '¡Los inflables fueron un éxito total en la fiesta de mi hijo! Todos los niños se divirtieron mucho.', author: 'Carla G.' },
    { message: 'Excelente servicio y muy buena calidad de los inflables. Definitivamente los volvería a contratar.', author: 'Javier M.' },
    { message: 'Todo salió perfecto, el inflable estaba impecable y el personal fue muy amable.', author: 'Laura R.' }
  ];
}
