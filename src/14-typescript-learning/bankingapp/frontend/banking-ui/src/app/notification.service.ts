import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  notifyUser(message: string): void {
    console.log('Notification:', message);
  }

}