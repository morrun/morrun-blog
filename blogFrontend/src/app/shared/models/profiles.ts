import {ProfilesDegrees} from './profiles-degrees';
import {ProfilesSkills} from './profiles-skills';

export class Profiles {
  id?: number;
  imageUrl: string;
  email: string;
  profilesDegrees: ProfilesDegrees[];
  profilesSkills: ProfilesSkills[];
}
