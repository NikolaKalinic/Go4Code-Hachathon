import { Post } from './Post.model';
import { User } from './User.model';

export class Comment implements CommentInterface {
  public id?: number;
  public user: User;
  public content: string;
  public post: Post;

  constructor(miCfg: CommentInterface) {
    this.id = miCfg.id;
    this.user = miCfg.user;
    this.content = miCfg.content;
    this.post = miCfg.post;
  }
}

export interface CommentInterface {
  id?: number;
  user: User;
  content: string;
  post: Post;
}
