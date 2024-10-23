import { Component } from '@angular/core';

@Component({
  selector: 'app-inflables',
  templateUrl: './inflables.component.html',
  styleUrls: ['./inflables.component.css']
})
export class InflablesComponent {
  categories = [
    {
      name: 'Acuáticos',
      inflables: [
        { name: 'Deslizador', description: 'Deslizador acuático para una experiencia refrescante.', image: 'assets/inflables/deslizador/1.jpeg' },
        { name: 'Rampa Acuática Arco', description: 'Rampa acuática con arco, ideal para el verano.', image: 'assets/inflables/rampa_acuatica_arco/1.jpeg' },
        { name: 'Rampa Acuática', description: 'Rampa acuática emocionante para toda la familia.', image: 'assets/inflables/rampa_acuatica/1.jpeg' },
        { name: 'Tobogán Acuático', description: 'Tobogán acuático para disfrutar al máximo.', image: 'assets/inflables/tobogan_acuatico/1.jpeg' }
      ]
    },
    {
      name: 'Gigantes',
      inflables: [
        { name: 'Demoledor', description: 'Un inflable gigante de desafío tipo demoledor.', image: 'assets/inflables/demoledor/1.jpeg' },
        { name: 'Arcoiris', description: 'Inflable gigante con temática de arcoiris.', image: 'assets/inflables/arcoiris/1.jpeg' },
        { name: 'Carrera de Obstáculos', description: 'Una emocionante carrera de obstáculos inflable.', image: 'assets/inflables/carrera_de_obstaculos/1.jpeg' },
        { name: 'Barco Pirata', description: 'Un barco pirata inflable para aventuras sin igual.', image: 'assets/inflables/barco_pirata/1.jpeg' }
      ]
    },
    {
      name: 'Castillos',
      inflables: [
        { name: 'Hombre Araña', description: 'Castillo inflable del Hombre Araña, ideal para los fanáticos del superhéroe.', image: 'assets/inflables/hombre_arania/1.jpeg' },
        { name: 'Princesas', description: 'Castillo inflable con temática de princesas, perfecto para las niñas.', image: 'assets/inflables/princesas/1.jpeg' },
        { name: '3x6', description: 'Castillo inflable de tamaño 3x6 metros.', image: 'assets/inflables/3x6/1.jpeg' },
        { name: '4x5', description: 'Castillo inflable de tamaño 4x5 metros.', image: 'assets/inflables/4x5/1.jpeg' },
        { name: '2x2', description: 'Castillo inflable compacto de tamaño 2x2 metros.', image: 'assets/inflables/2x2/1.jpeg' }
      ]
    },
    {
      name: 'Juegos',
      inflables: [
        { name: 'Metegol', description: 'Juego de metegol inflable para divertirse en grupo.', image: 'assets/inflables/metegol/1.jpg' },
        { name: 'Tejo', description: 'Juego de tejo inflable, ideal para cualquier edad.', image: 'assets/inflables/tejo/1.jpeg' },
        { name: 'Sapo', description: 'Juego inflable del sapo, clásico y divertido.', image: 'assets/inflables/sapo/1.jpg' },
        { name: 'Pool', description: 'Mesa de pool inflable, diversión garantizada.', image: 'assets/inflables/pool/1.jpg' },
        { name: 'Ping Pong', description: 'Mesa de ping pong inflable para competencias amistosas.', image: 'assets/inflables/ping_pong/1.jpg' },
        { name: 'Yenga', description: 'Juego de Yenga inflable, diversión y equilibrio.', image: 'assets/inflables/yenga/1.jpeg' }
      ]
    }
  ];

  selectedCategory = this.categories[0];

  selectCategory(category: any) {
    this.selectedCategory = category;
  }
}
