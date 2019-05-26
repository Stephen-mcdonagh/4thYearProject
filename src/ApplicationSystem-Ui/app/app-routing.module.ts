import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { HomeComponent } from './components/home/home.component';
import { ViewRegistrationComponent } from './components/view-registration/view-registration.component';
import {ChatbotComponent} from './components/chatbot/chatbot.component';
import {AboutComponent} from './components/about/about.component';
// most specific paths first is why admin/view/:id comes before admin
const routes: Routes = [
  {
    path:'',
    component: HomeComponent
  },
  {
    path:'admin/view/:id',
    component: ViewRegistrationComponent
  },
  {
    path:'admin',
    component: AdminComponent
  },
  {
    path:'about',
    component: AboutComponent
  },
  {
    path:'chatbot',
    component: ChatbotComponent
  },
  //This handles all unKnown URLS
  {
    path: '**',
    component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
