import { Component, OnInit } from '@angular/core';
import { AppService } from '../app.service';
import { UserDto } from '../DTO/User.dto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public userDto:UserDto;


  constructor(private appService:AppService) { 

    this.userDto={
      username:'',
      password:''
    }
  }



  ngOnInit(): void {
  }

  login(){
    alert(this.userDto.username)
    this.appService.login(this.userDto).subscribe(res=>localStorage.setItem('user', JSON.stringify(res)));
  }

}
