import {Blog} from './blog';

export class Comment {
  id?: number;
  content: string;
  commenterEmail: string;
  createDate: Date;
  updateDate: Date;
  like: number;
  unlike: number;
  blog: Blog;
}
