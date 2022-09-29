import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
  public previewNewCommentSection: boolean = false;
  constructor() {}

  ngOnInit(): void {}

  openNewComment() {
    this.previewNewCommentSection === false
      ? (this.previewNewCommentSection = true)
      : (this.previewNewCommentSection = false);
  }
}
