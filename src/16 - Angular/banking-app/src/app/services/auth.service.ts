import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedIn = false;

  login(username: string, password: string): boolean {

    if (
      username === 'user' &&
      password === 'pass123'
    ) {
      this.loggedIn = true;
      return true;
    }

    return false;
  }

  logout(): void {
    this.loggedIn = false;
  }

  isLoggedIn(): boolean {
    return this.loggedIn;
  }
}
