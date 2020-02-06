import { Component } from '@angular/core';
import { Platform, NavController } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import { AuthService } from './services/auth.service';
import { AlertService } from './services/alert.service';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent {


  
  navigate : any;
  constructor(private platform    : Platform,
              private splashScreen: SplashScreen,
              private statusBar   : StatusBar,
              private authService: AuthService,
              private navCtrl: NavController,
              private alertService: AlertService
              ) 
  {
    this.sideMenu();
    this.initializeApp();
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      //this.splashScreen.hide();
      
      this.authService.getToken();
    });
  }

  logout() {
    this.authService.logout().subscribe(
      data => {
        this.alertService.presentToast(data['message']);        
      },
      error => {
        console.log(error);
      },
      () => {
        this.navCtrl.navigateRoot('/home');
      }
    );
  }


  sideMenu()
{
  this.navigate =
  [
    {
      title : "Home",
      url   : "/tabs/tab1",
      icon  : "home"
    },
    {
      title : "Group",
      url   : "/tabs/tab3",
      icon  : "people"
    },
    
    {
      title : "Chatroom",
      url   : "/chatroom",
      icon  : "mail"
    },
    {
      title : "Settings",
      url   : "/login",
      icon  : "settings"
    },
    {
      title : "Logout",
      url   : "/home",
      icon  : "log-out"
    },
  ]
}
}