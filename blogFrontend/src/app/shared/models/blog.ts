import {BlogType} from './blog-type';

export class Blog {
  id?: number;
  comments: Comment[];
  title: string;
  content: string;
  userId?: number;
  createDate: Date;
  updateDate: Date;
  like: number;
  unlike: number;
  type: BlogType;
}
