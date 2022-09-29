import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppService } from '../app.service';
import { UserDto } from '../DTO/User.dto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  public userDto: UserDto;
  public error: boolean;

  constructor(private appService: AppService, private route: Router) {
    this.userDto = {
      username: '',
      password: '',
    };
    this.error = false;
  }

  ngOnInit(): void {}

  login() {
    this.appService.login(this.userDto).subscribe((res) => {
      if (res === null) {
        this.error = true;
      } else {
        localStorage.setItem('user', JSON.stringify(res));
        this.appService.editUser(res);
        this.route.navigate(['/main']);
      }
    });
  }
}
