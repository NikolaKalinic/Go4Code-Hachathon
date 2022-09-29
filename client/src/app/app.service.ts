import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserDto } from './DTO/User.dto';
import { Post } from './model/Post.model';
import { User } from './model/User.model';

@Injectable({
  providedIn: 'root',
})
export class AppService {
  constructor(private http: HttpClient) {}

  getAllPosts() {
    return this.http.get<Post[]>(`http://localhost:8080/api/posts`);
  }

  login(userDto:UserDto){
     return this.http.post<any>(`http://localhost:8080/api/login`,userDto);
  }
}
