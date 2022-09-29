import { User } from './User.model';

export class Post implements PostInterface {
  public id?: number;
  public user: User;
  public comments: Comment[];
  public date: Date;
  public content: string;
  public attachment: string;
  public rating: number;
  public viewers: number;

  constructor(miCfg: PostInterface) {
    this.id = miCfg.id;
    this.user = miCfg.user;
    this.comments = miCfg.comments;
    this.date = miCfg.date;
    this.content = miCfg.content;
    this.attachment = miCfg.attachment;
    this.rating = miCfg.rating;
    this.viewers = miCfg.viewers;
  }
}

export interface PostInterface {
  id?: number;
  user: User;
  comments: Comment[];
  date: Date;
  content: string;
  attachment: string;
  rating: number;
  viewers: number;
}
