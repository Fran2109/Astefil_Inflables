import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  private articles = [
    {
      id: 1,
      name: 'Deslizador',
      description: 'Deslizador acuático para una experiencia refrescante.',
      images: [
        'assets/inflables/deslizador/1.jpeg',
        'assets/inflables/deslizador/2.jpeg',
        'assets/inflables/deslizador/3.jpeg'
      ],
      categoryId: 1
    },
    {
      id: 2,
      name: 'Rampa Acuática Arco',
      description: 'Rampa acuática con arco, ideal para el verano.',
      images: [
        'assets/inflables/rampa_acuatica_arco/1.jpeg',
        'assets/inflables/rampa_acuatica_arco/2.jpeg',
        'assets/inflables/rampa_acuatica_arco/3.jpeg'
      ],
      categoryId: 1
    },
    {
      id: 3,
      name: 'Rampa Acuática',
      description: 'Rampa acuática emocionante para toda la familia.',
      images: [
        'assets/inflables/rampa_acuatica/1.jpeg',
        'assets/inflables/rampa_acuatica/2.jpeg',
        'assets/inflables/rampa_acuatica/3.jpeg'
      ],
      categoryId: 1
    },
    {
      id: 4,
      name: 'Tobogán Acuático',
      description: 'Tobogán acuático para disfrutar al máximo.',
      images: [
        'assets/inflables/tobogan_acuatico/1.jpeg',
        'assets/inflables/tobogan_acuatico/2.jpeg',
        'assets/inflables/tobogan_acuatico/3.jpeg'
      ],
      categoryId: 1
    },
    {
      id: 5,
      name: 'Demoledor',
      description: 'Un inflable gigante de desafío tipo demoledor.',
      images: [
        'assets/inflables/demoledor/1.jpeg',
        'assets/inflables/demoledor/2.jpeg',
        'assets/inflables/demoledor/3.jpeg'
      ],
      categoryId: 2
    },
    {
      id: 6,
      name: 'Arcoiris',
      description: 'Inflable gigante con temática de arcoiris.',
      images: [
        'assets/inflables/arcoiris/1.jpeg',
        'assets/inflables/arcoiris/2.jpeg',
        'assets/inflables/arcoiris/3.jpeg'
      ],
      categoryId: 2
    },
    {
      id: 7,
      name: 'Carrera de Obstáculos',
      description: 'Una emocionante carrera de obstáculos inflable.',
      images: [
        'assets/inflables/carrera_de_obstaculos/1.jpeg',
        'assets/inflables/carrera_de_obstaculos/2.jpeg',
        'assets/inflables/carrera_de_obstaculos/3.jpeg'
      ]
    },
    {
      id: 8,
      name: 'Barco Pirata',
      description: 'Un barco pirata inflable para aventuras sin igual.',
      images: [
        'assets/inflables/barco_pirata/1.jpeg',
        'assets/inflables/barco_pirata/2.jpeg',
        'assets/inflables/barco_pirata/3.jpeg'
      ],
      categoryId: 2
    },
    {
      id: 9,
      name: 'Hombre Araña',
      description: 'Castillo inflable del Hombre Araña, ideal para los fanáticos del superhéroe.',
      images: [
        'assets/inflables/hombre_arania/1.jpeg',
        'assets/inflables/hombre_arania/2.jpeg',
        'assets/inflables/hombre_arania/3.jpeg'
      ],
      categoryId: 3
    },
    {
      id: 10,
      name: 'Princesas',
      description: 'Castillo inflable con temática de princesas, perfecto para las niñas.',
      images: [
        'assets/inflables/princesas/1.jpeg',
        'assets/inflables/princesas/2.jpeg',
        'assets/inflables/princesas/3.jpeg'
      ],
      categoryId: 3
    },
    {
      id: 11,
      name: '3x6',
      description: 'Castillo inflable de tamaño 3x6 metros.',
      images: [
        'assets/inflables/3x6/1.jpeg',
        'assets/inflables/3x6/2.jpeg',
        'assets/inflables/3x6/3.jpeg'
      ],
      categoryId: 3
    },
    {
      id: 12,
      name: '4x5',
      description: 'Castillo inflable de tamaño 4x5 metros.',
      images: [
        'assets/inflables/4x5/1.jpeg',
        'assets/inflables/4x5/2.jpeg'
      ],
      categoryId: 3
    },
    {
      id: 13,
      name: '2x2',
      description: 'Castillo inflable compacto de tamaño 2x2 metros.',
      images: [
        'assets/inflables/2x2/1.jpeg',
        'assets/inflables/2x2/2.jpeg',
        'assets/inflables/2x2/3.jpeg'
      ],
      categoryId: 3
    },
    {
      id: 14,
      name: 'Metegol',
      description: 'Juego de metegol inflable para divertirse en grupo.',
      images: [
        'assets/inflables/metegol/1.jpg',
        'assets/inflables/metegol/2.jpg',
        'assets/inflables/metegol/3.jpg'
      ],
      categoryId: 4
    },
    {
      id: 15,
      name: 'Tejo',
      description: 'Juego de tejo inflable, ideal para cualquier edad.',
      images: [
        'assets/inflables/tejo/1.jpeg'
      ],
      categoryId: 4
    },
    {
      id: 16,
      name: 'Sapo',
      description: 'Juego inflable del sapo, clásico y divertido.',
      images: [
        'assets/inflables/sapo/1.jpg',
        'assets/inflables/sapo/2.jpg',
        'assets/inflables/sapo/3.jpg'
      ],
      categoryId: 4
    },
    {
      id: 17,
      name: 'Pool',
      description: 'Mesa de pool inflable, diversión garantizada.',
      images: [
        'assets/inflables/pool/1.jpg',
        'assets/inflables/pool/2.jpg',
        'assets/inflables/pool/3.jpg'
      ],
      categoryId: 4
    },
    {
      id: 18,
      name: 'Ping Pong',
      description: 'Mesa de ping pong inflable para competencias amistosas.',
      images: [
        'assets/inflables/ping_pong/1.jpg',
        'assets/inflables/ping_pong/2.jpg',
        'assets/inflables/ping_pong/3.jpg'
      ],
      categoryId: 4
    },
    {
      id: 19,
      name: 'Yenga',
      description: 'Juego de Yenga inflable, diversión y equilibrio.',
      images: [
        'assets/inflables/yenga/1.jpeg',
        'assets/inflables/yenga/2.jpeg',
        'assets/inflables/yenga/3.jpeg'
      ],
      categoryId: 4
    }
  ];

  getArticlesByCategoryId(categoryId: number) {
    return this.articles.filter(article => article.categoryId === categoryId);
  }

  getArticleById(articleId: number) {
    return this.articles.find(article => article.id === articleId);
  }
  constructor() { }
}
