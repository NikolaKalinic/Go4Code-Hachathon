import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {



  constructor() { }

  ngOnInit(): void {
  }
 
  @Input() password?: String;

  @Input() repassword?: String;

  checkSame(password: string) {
    this.password = password;
    this.repassword=this.repassword;
    if (this.password === this.repassword) {
      alert("HaHA")
  }

  }
}