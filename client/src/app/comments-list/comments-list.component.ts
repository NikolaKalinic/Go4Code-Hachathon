import { Component, Input, OnInit } from '@angular/core';
import { CommentInterface } from '../model/Comment.model';
import {  Post  } from '../model/Post.model';

@Component({
  selector: 'app-comments-list',
  templateUrl: './comments-list.component.html',
  styleUrls: ['./comments-list.component.css']
})
export class CommentsListComponent implements OnInit {

  @Input() public post: Post | undefined;
  @Input() public comments: CommentInterface[] = [];

  constructor() {
    
   }

  ngOnInit(): void {
  }

}
