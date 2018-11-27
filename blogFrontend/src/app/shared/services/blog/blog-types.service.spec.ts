import { TestBed } from '@angular/core/testing';

import { BlogTypesService } from './blog-types.service';

describe('BlogTypesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BlogTypesService = TestBed.get(BlogTypesService);
    expect(service).toBeTruthy();
  });
});
