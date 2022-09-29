import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';
import { User } from '../model/User.model';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  public user: User;

  password: string;

  repassword: string;

  constructor(private appService: AppService, private route: Router) {
    this.user = {
      username: '',
      email: '',
      password: '',
    };
    this.password='';
    this.repassword='';
  }

  ngOnInit(): void {
  }
 

  checkSame(password: string) {
    this.password = this.password;
    this.repassword=this.repassword;
    if (this.password === this.repassword) {
      alert("HaHA")
  }

  }

  register(){
    console.log(this.password+"this is pass");
    console.log(this.repassword + "this is repa");
    if(this.password === this.repassword){
      this.user.password=this.password;
      this.appService.register(this.user).subscribe(res=>console.log(res));
      this.route.navigate(['/login']);
    }else{
      alert('nece')
    }
    
}
}