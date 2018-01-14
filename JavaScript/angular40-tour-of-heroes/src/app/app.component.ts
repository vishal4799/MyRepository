import { Component } from '@angular/core';
import { HeroService } from 'app/hero.service';
import { Hero, Movies } from './hero';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  movies : Movies;
  totalMovies : Number;
  response : String;
  constructor(private heroService : HeroService){}
  title = 'Tour of Heroes';
  getHTTP(){
    // this.heroService.getHTTP().subscribe(data => this.movies = data);
    // this.totalMovies = this.movies.total;
    this.heroService.getHTTP().subscribe(data => this.response = JSON.stringify(data));
    //this.heroService.getHTTP().subscribe(data => this.response = data);
  }  
}
