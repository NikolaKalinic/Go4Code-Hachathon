import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { UserDto } from './DTO/User.dto';
import { Post } from './model/Post.model';
import { User } from './model/User.model';

@Injectable({
  providedIn: 'root',
})
export class AppService {
  private currentUser = new BehaviorSubject<User | null>(null);

  cast = this.currentUser.asObservable();

  public loggedUser: User | null;
  constructor(private http: HttpClient) {
    this.loggedUser = null;
  }

  editUser(newUser: any) {
    this.currentUser.next(newUser);
  }

  getAllPosts() {
    return this.http.get<Post[]>(`http://localhost:8080/api/posts`);
  }


  getPostById(id:number){
    return this.http.get<Post>(`http://localhost:8080/api/posts/${id}`);
  }

  getCommentsByPostId(id:number){
    return this.http.get<Comment[]>(`http://localhost:8080/api/post/${id}/comments`);
  }

  login(userDto:UserDto){
     return this.http.post<any>(`http://localhost:8080/api/login`,userDto);
  }
}

