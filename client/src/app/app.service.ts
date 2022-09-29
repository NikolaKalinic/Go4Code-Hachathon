import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BehaviorSubject } from 'rxjs';
import { UserDto } from './DTO/User.dto';
import { Post } from './model/Post.model';
import { User } from './model/User.model';
import { Comment } from './model/Comment.model';
import { PostDto } from './DTO/post.dto';

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

  getPostById(id: number) {
    return this.http.get<Post>(`http://localhost:8080/api/posts/${id}`);
  }

  getCommentsByPostId(id: number) {
    return this.http.get<Comment[]>(
      `http://localhost:8080/api/post/${id}/comments`
    );
  }

  login(userDto: UserDto) {
    return this.http.post<any>(`http://localhost:8080/api/login`, userDto);
  }

  register(user: User){
    return this.http.post<any>(`http://localhost:8080/api/users`, user)
  }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  addPost(post: PostDto): Observable<Post> {
    return this.http
      .post<Post>(`http://localhost:8080/api/posts`, post, this.httpOptions);
  }
}
