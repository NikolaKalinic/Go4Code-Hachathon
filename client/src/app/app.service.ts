import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Post } from './model/Post.model';

@Injectable({
  providedIn: 'root',
})
export class AppService {
  constructor(private http: HttpClient) {}

  getAllPosts() {
    return this.http.get<Post[]>(`http://localhost:8080/api/posts`);
  }

  getPostById(id:number){
    return this.http.get<Post>(`http://localhost:8080/api/posts/${id}`);
  }
}
