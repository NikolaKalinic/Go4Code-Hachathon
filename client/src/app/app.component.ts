import { Component } from '@angular/core';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  public logged: boolean;
  title = 'client';
  constructor(private appService: AppService) {
    this.logged = false;
  }

  ngOnInit() {
    // localStorage.getItem('user') !== null
    //   ? (this.logged = true)
    //   : (this.logged = false);
    this.appService.cast.subscribe((res) =>
      res != null ? (this.logged = true) : (this.logged = false)
    );
  }

  logout() {
    // this.appService.editUser(null);
    localStorage.removeItem('user');
    localStorage.getItem('user') !== null
      ? (this.logged = true)
      : (this.logged = false);
  }
}
