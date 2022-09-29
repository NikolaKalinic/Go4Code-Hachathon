import { User } from "../model/User.model";

export class PostDto  {
    public user: User;
    public content: string;
    public attachment:string;
  
    constructor(user:User,content:string,attachment:string) {
      this.user = user;
      this.content = content;
      this.attachment=attachment;
      
    }
  }