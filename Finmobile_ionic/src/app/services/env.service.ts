import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EnvService {

  API_URL = 'http://192.168.43.125:8000/api/';

  constructor() { }
}
