import { Component, OnInit } from '@angular/core';
import {ProfilesService} from '../shared/services/profiles/profiles.service';
import {Profiles} from '../shared/models/profiles';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  profiles: Profiles;
  constructor(
    private profileS: ProfilesService
  ) { }

  ngOnInit() {
    this.profileS.getAllProfiles().subscribe(res => {
      this.profiles = res[0];
      console.log(this.profiles);
    });
  }
  arrayGen(length: number) {
    const res: number[] = [];
    for (let i = 1;i <= length;i ++) {
      res.push(i);
    }
    return res;
  }
}
