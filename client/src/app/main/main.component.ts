import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { Post } from '../model/Post.model';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
  public previewNewCommentSection: boolean[] = [];
  public posts: Post[];
  public comments: string[] = [];
  public forAllComment: string = '';
  public logged: boolean;

  constructor(private appService: AppService) {
    this.posts = [];
    this.appService.getAllPosts().subscribe((res) => (this.posts = res));
    for (let post of this.posts) {
      this.previewNewCommentSection.push(false);
      this.comments.push('');
    }
    localStorage.getItem('user') === null
      ? (this.logged = false)
      : (this.logged = true);
  }

  ngOnInit(): void {
    this.appService.getAllPosts().subscribe((res) => (this.posts = res));
  }

  openNewComment(i: number) {
    localStorage.getItem('user') !== null
      ? (this.logged = true)
      : (this.logged = false);
    this.previewNewCommentSection[i] === false
      ? (this.previewNewCommentSection[i] = true)
      : (this.previewNewCommentSection[i] = false);
  }

  convertDate(date: Date) {
    var dateString: string = date.toString();
    return (
      dateString.replace('T', ' ').split(':')[0] +
      ':' +
      dateString.split(':')[1]
    );
  }

  sendComment(i: number) {
    alert(this.comments[i]);
  }
}
