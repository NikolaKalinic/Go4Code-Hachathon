import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Comment } from '../model/Comment.model';
import { HttpResponse, HttpClient, HttpParams } from '@angular/common/http';
import { Post } from '../model/Post.model';
import { getLocaleDateFormat } from '@angular/common';
import { AppService } from '../app.service';

@Component({
  selector: 'app-comments-list',
  templateUrl: './comments-list.component.html',
  styleUrls: ['./comments-list.component.css'],
})
export class CommentsListComponent implements OnInit {
  public post: Post;
  public comments: Comment[];

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private appService: AppService
  ) {
    this.comments = [];

    this.post = {
      id: -1,
      user: {
        id: -1,
        username: '',
        email: '',
        password: '',
      },
      comments: [],
      date: new Date('2019-01-16'),
      content: '',
      attachment: '',
      rating: -1,
      viewers: -1,
    };
  }
  id: number = -1;
  ngOnInit(): void {
    //this.route.queryParams.subscribe(params => {this.post = params[];})
    // this.route.params.subscribe( params =>
    //   {
    //     this.http.get('api/posts/'+params['id']).subscribe((resp) => {
    //       this.post = resp;
    //     });
    //   });

    this.route.params.subscribe((params) => {
      this.id = +params['id'];
    });
    this.appService.getPostById(this.id).subscribe((res) => (this.post = res));

    this.appService
      .getCommentsByPostId(this.id)
      .subscribe((res) => (this.comments = res));
    console.log(this.comments);
  }
}
