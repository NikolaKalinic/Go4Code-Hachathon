import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { Post } from '../model/Post.model';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
  public previewNewCommentSection: boolean = false;
  public posts: Post[];

  constructor(private appService: AppService) {
    this.posts = [];
  }

  ngOnInit(): void {
    this.appService.getAllPosts().subscribe((res) => (this.posts = res));
  }

  openNewComment() {
    this.previewNewCommentSection === false
      ? (this.previewNewCommentSection = true)
      : (this.previewNewCommentSection = false);
  }
}
