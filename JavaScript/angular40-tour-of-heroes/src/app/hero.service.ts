import { Injectable } from '@angular/core';
import { Hero, Movies } from './hero';
import { HEROES } from './mock-heroes';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { MessageService } from './message.service';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable()
export class HeroService {
  response : String;
  constructor(
    private http: HttpClient,
    private messageService: MessageService) { }
  
  getHeroes(): Observable<Hero[]> {
    // Todo: send the message _after_ fetching the heroes
    this.messageService.add('HeroService: fetched heroes');
    return of(HEROES);
  }

  getHero(id: number): Observable<Hero> {
    // Todo: send the message _after_ fetching the hero
    this.messageService.add(`HeroService: fetched hero id=${id}`);
    return of(HEROES.find(hero => hero.id === id));
  }
  
  getHTTP():Observable<String> {
    //return this.http.get<Movies>('https://jsonmock.hackerrank.com/api/movies/search')
    //        .pipe(catchError(this.handleError<any>('getHeroes', Movies)));
    return this.http.get<String>('https://jsonmock.hackerrank.com/api/movies/search');
  }

  /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(`${operation} failed: ${error.message}`); // log to console instead
      console.error(error); // log to console instead

      
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
