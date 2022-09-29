export class User implements UserInterface {
  public id?: number;
  public username: string;
  public email: string;
  public password: string;

  constructor(miCfg: UserInterface) {
    this.id = miCfg.id;
    this.username = miCfg.username;
    this.email = miCfg.email;
    this.password = miCfg.password;
  }
}

export interface UserInterface {
  id?: number;
  username: string;
  email: string;
  password: string;
}
