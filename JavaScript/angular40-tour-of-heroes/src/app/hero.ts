export class Hero {
    id: number;
    name: string;
}
export class Movie{
    Poster :  String;
    Title :  String;
    Type :  String;
    Year : Number;
    imdbID :  String; 
}
export class Movies {
   page : Number;
   per_page : Number;
   total : Number;
   total_pages : Number;
   data : Movie[];
}