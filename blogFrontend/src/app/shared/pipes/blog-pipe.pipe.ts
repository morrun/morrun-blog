import { Pipe, PipeTransform } from '@angular/core';
import {Blog} from '../models/blog';

@Pipe({
  name: 'blogPipe'
})
export class BlogPipePipe implements PipeTransform {

  transform(blog: Blog[], type: string): Blog[] {
    if (type === 'All') {
      return blog;
    }
    if (blog && type) {
      return blog.filter(res => {
        return res.type.type === type;
      });
    }
    return blog;
  }

}
