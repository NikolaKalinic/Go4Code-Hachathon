import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Comment } from '../model/Comment.model';
import { HttpResponse, HttpClient, HttpParams } from '@angular/common/http';
import { Post } from '../model/Post.model';
import { getLocaleDateFormat } from '@angular/common';
import { AppService } from '../app.service';
import { User } from '../model/User.model';

@Component({
  selector: 'app-comments-list',
  templateUrl: './comments-list.component.html',
  styleUrls: ['./comments-list.component.css'],
})
export class CommentsListComponent implements OnInit {
  public post: Post;
  public comments: Comment[];
  public showDeletePost: boolean=false;
  public showDeleteComment: boolean=false;

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private appService: AppService,
    private router:Router
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
    this.appService.editUser(localStorage.getItem('user'));
    
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
    var aa:any=JSON.parse(localStorage.getItem('user')||'{}');
    this.appService.getPostById(this.id).subscribe((res) => {this.post = res;if(this.post.user.username===aa.username){
      this.showDeletePost=true;
    }else{
      this.showDeletePost=false;
    }});

    this.appService.getCommentsByPostId(this.id).subscribe((res) => {this.comments = res;if(this.post.user.username===aa.username){
      this.showDeleteComment=true;
    }else{
      this.showDeleteComment=false;
    }});
    

    this.appService
      .getCommentsByPostId(this.id)
      .subscribe((res) => (this.comments = res)); 
  }

  deletePost(){
    this.appService.deletePost(this.post.id).subscribe(res =>this.router.navigate(['main']));
  }

  deleteComment(id:number|undefined){
    this.appService.deleteComment(id).subscribe(res =>window.location.reload);
    window.location.reload();
  }


}
