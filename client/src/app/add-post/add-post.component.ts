import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { Post } from '../model/Post.model';
import { Router } from '@angular/router';
import { User } from '../model/User.model';
import { PostDto } from '../DTO/post.dto';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css'],
})
export class AddPostComponent implements OnInit {
  public newPost: PostDto;
  user: User | undefined;

  constructor(private appService: AppService, private router: Router) {
    this.newPost = new PostDto(
      JSON.parse(localStorage.getItem('user') || '{}'),
      '',
      ''
    );
  }

  ngOnInit(): void {}

  addPost() {
    this.user = JSON.parse(localStorage.getItem('user') || '{}');
    this.newPost.user.username = this.user?.username!;
    this.newPost.user.email = this.user?.email!;
    this.newPost.user.password = this.user?.password!;
    this.appService.addPost(this.newPost).subscribe((res: Post) => {
      this.router.navigate(['/main']);
    });

    this.newPost.user.username = '';
    this.newPost.user.password = '';
    this.newPost.user.email = '';
    this.newPost.content = '';
    this.newPost.attachment = '';
  }
}
