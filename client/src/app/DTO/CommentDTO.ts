import { Post } from '../model/Post.model';
import { User } from '../model/User.model';

export class CommentDTO {
  public user: User;
  public content: string;
  public attachment: string;
  public post: Post;

  constructor(user: User, content: string, attachment: string, post: Post) {
    this.user = user;
    this.content = content;
    this.attachment = attachment;
    this.post = post;
  }
}
