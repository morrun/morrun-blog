import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifyBlogComponent } from './modify-blog.component';

describe('ModifyBlogComponent', () => {
  let component: ModifyBlogComponent;
  let fixture: ComponentFixture<ModifyBlogComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModifyBlogComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModifyBlogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
