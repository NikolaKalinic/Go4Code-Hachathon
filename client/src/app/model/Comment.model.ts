import { Post } from './Post.model';
import { User } from './User.model';

export class Comment implements CommentInterface {
  public id?: number;
  public user: User;
  public content: string;
  public post: Post;
  public attachment: string;
  public date: Date;

  constructor(miCfg: CommentInterface) {
    this.id = miCfg.id;
    this.user = miCfg.user;
    this.content = miCfg.content;
    this.post = miCfg.post;
    this.attachment = miCfg.attachment;
    this.date = miCfg.date;
  }
}

export interface CommentInterface {
  id?: number;
  user: User;
  content: string;
  post: Post;
  attachment: string;
  date: Date;
}
